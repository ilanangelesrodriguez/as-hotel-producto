package com.arquitectura.ashotelproducto.datos;

import java.util.List;

public interface CRUD<T> {
    void insert(T t);
    void update(T t);
    void delete(T t);
    T select(T t);
    T selectById(int id);
    List<T> selectAll();

}
