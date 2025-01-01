package nxc.hcmus.infrastructure.cache.redis.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nxc.hcmus.infrastructure.cache.redis.RedisInfraService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Component
@Slf4j
public class RedisInfraServiceImpl implements RedisInfraService {

    private final RedisTemplate<String, Object> redisTemplate;

    @Override
    public void setString(String key, String value) {
        Optional.ofNullable(key)
                .filter(k -> !k.isEmpty())
                .ifPresent(k -> redisTemplate.opsForValue().set(k, value));
    }

    @Override
    public String getString(String key) {
        return Optional.ofNullable(redisTemplate.opsForValue().get(key))
                .map(String::valueOf)
                .orElse(null);
    }

    @Override
    public void setObject(String key, Object value) {
        Optional.ofNullable(key)
                .filter(k -> !k.isEmpty())
                .ifPresent(k -> redisTemplate.opsForValue().set(k, value));
    }

    @Override
    public <T> T getObject(String key, Class<T> targetClass) {
        Object result = redisTemplate.opsForValue().get(key);

        switch (result) {
            case null -> {
                return null;
            }
            case Map map -> {
                try {
                    ObjectMapper objectMapper = new ObjectMapper();
                    return objectMapper.convertValue(result, targetClass);
                } catch (IllegalArgumentException e) {
                    log.error("Error converting map to object: {}", e.getMessage());
                    return null;
                }
            }
            case String str -> {
                try {
                    ObjectMapper objectMapper = new ObjectMapper();
                    return objectMapper.readValue(str, targetClass);
                } catch (Exception e) {
                    log.error("Error converting string to object: {}", e.getMessage());
                    return null;
                }
            }
            default -> {
            }
        }

        return null;
    }
}
