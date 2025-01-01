package nxc.hcmus.infrastructure.distributed.redisson.impl;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import nxc.hcmus.infrastructure.distributed.redisson.RedisDistributedLocker;
import nxc.hcmus.infrastructure.distributed.redisson.RedisDistributedService;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class RedisDistributedServiceImpl implements RedisDistributedService {

    @Resource
    private RedissonClient redissonClient;

    @Override
    public RedisDistributedLocker getDistributedLock(String lockKey) {
        RLock rLock = redissonClient.getLock(lockKey);
        return new RedisDistributedLocker() {
            @Override
            public boolean tryLocK(long waitTime, long leaseTime, TimeUnit unit) throws InterruptedException {
                boolean isLockSuccess = rLock.tryLock(waitTime, leaseTime, unit);
                log.info("{} get lock result: {}", lockKey, isLockSuccess);
                return isLockSuccess;
            }

            @Override
            public void lock(long leaseTime, TimeUnit unit) {
                rLock.lock(leaseTime, unit);
            }

            @Override
            public void unlock() {
                if (isLocked() && isHeldByCurrentThread()) {
                    rLock.unlock();
                }
            }

            @Override
            public boolean isLocked() {
                return rLock.isLocked();
            }

            @Override
            public boolean isHeldByThread(long threadId) {
                return rLock.isHeldByThread(threadId);
            }

            @Override
            public boolean isHeldByCurrentThread() {
                return rLock.isHeldByCurrentThread();
            }
        };
    }
}