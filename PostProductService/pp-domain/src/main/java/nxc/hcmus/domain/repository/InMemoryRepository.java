package nxc.hcmus.domain.repository;

import java.util.Map;

public abstract class InMemoryRepository <T> {
    protected abstract Map<String, T> getCache();

    public T get(String key) {
        return getCache().get(key);
    }

    public void put(String key, T value) {
        getCache().put(key, value);
    }

    public void remove(String key) {
        getCache().remove(key);
    }
}
