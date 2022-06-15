package com.sofka.reto.retoFullStack.service;

import java.util.List;
import java.util.Optional;

public interface CrudService<T,ID> {
    List<T> findAll() throws Exception;
    T Save(T t) throws Exception;
    T update(T t) throws Exception;
    Optional<T> finById(ID id) throws Exception;
    boolean deleteById(ID id) throws Exception;
    void deleteAll() throws Exception;
}
