package ru.kpfu.itis.kashshapov.dao;
import java.util.List;

public interface Dao<T> {
    T get(int id);
    List<T> getAll();

    void save(T t);

}
