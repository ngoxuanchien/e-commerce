package nxc.hcmus.infrastructure.presistence.repository;

import nxc.hcmus.domain.repository.InMemoryRepository;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ConcurrentHashMapRepository<T> extends InMemoryRepository<T> {

    private final ConcurrentHashMap<String, T> cache = new ConcurrentHashMap<>();

    @Override
    protected Map<String, T> getCache() {
        return cache;
    }
}
