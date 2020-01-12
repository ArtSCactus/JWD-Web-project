package com.epam.model.dao.common;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {
    Optional<T> getById(Long id);

    List<T> getAll(String sql);

    void save(T item);

    void update(Long id, Object ... params);

    void removeById(Long id);
}
