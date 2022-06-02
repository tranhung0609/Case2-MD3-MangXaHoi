package service;

import java.sql.SQLException;
import java.util.List;

public interface GenaraSevice<T> {
    List<T> findAll();

    void add(T t) throws SQLException;

    T findById(int id);

    boolean update(T t);

    boolean delete(int id) throws SQLException;

    List<T> findByName(String name);
}
