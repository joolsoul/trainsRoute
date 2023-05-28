package ru.kudinov.electrictrainscontroll.repository;

import java.util.Collection;
import java.util.Optional;

public interface CrudRepository<T> {

    Optional<T> get(Long id);
    Collection<T> getAll();
    int save(T t);
    int update(T t);
    int delete(Long id);
}
