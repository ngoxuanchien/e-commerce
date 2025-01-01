package nxc.hcmus.application.service.cache;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nxc.hcmus.domain.model.entity.Category;
import nxc.hcmus.domain.service.category.CategoryDomainService;
import nxc.hcmus.infrastructure.cache.redis.RedisInfraService;
import nxc.hcmus.infrastructure.distributed.redisson.RedisDistributedLocker;
import nxc.hcmus.infrastructure.distributed.redisson.RedisDistributedService;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
@RequiredArgsConstructor
public class CategoryCacheService {

    private final RedisDistributedService redisDistributedService;
    private final RedisInfraService redisInfraService;
    private final CategoryDomainService categoryDomainService;


    public Category getCategoryCache(UUID id, Long version) {
        Category category = redisInfraService.getObject(generateEventItemKey(id), Category.class);

        if (category != null) {
            return category;
        }

        RedisDistributedLocker locker = redisDistributedService.getDistributedLock("LOCK_KEY_ITEM_" + id);
        try {
            boolean isLock = locker.tryLocK(1, 5, TimeUnit.SECONDS);

            if (!isLock) {
                return category;
            }

            category = redisInfraService.getObject(generateEventItemKey(id), Category.class);

            if (category != null) {
                return category;
            }

            category = categoryDomainService.findById(id).orElse(null);
            log.info("FROM DBS ->>>> {}, {}", category, version);
            if (category == null) {
                log.info("Category not found with id: {}", id);
                redisInfraService.setObject(generateEventItemKey(id), category);
                return category;
            }

            redisInfraService.setObject(generateEventItemKey(id), category);
            return category;
        }  catch (Exception e) {
            throw new RuntimeException("Error when get category cache", e);
        } finally {
            locker.unlock();
        }
    }

    private String generateEventItemKey(UUID itemId) {
        return "CATEGORY:ITEM:" + itemId;
    }
}
