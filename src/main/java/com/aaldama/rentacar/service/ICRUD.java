package com.aaldama.rentacar.service;

import java.util.List;
import java.util.Optional;

public interface ICRUD<T> {

    List<T> findAll();
    Optional<T> findById(Integer id) throws Exception;
    T save(T t);
    T update(T t);
    void deleteById(Integer id) throws Exception;
}
