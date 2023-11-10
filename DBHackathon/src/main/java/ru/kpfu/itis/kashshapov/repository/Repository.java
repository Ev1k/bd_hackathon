package ru.kpfu.itis.kashshapov.repository;

import java.util.List;

public interface Repository<T> {
    T get(Integer id);
    List<T> getAll();
    void add(T model);
    void update(Integer id);
    void delete(Integer id);
}
