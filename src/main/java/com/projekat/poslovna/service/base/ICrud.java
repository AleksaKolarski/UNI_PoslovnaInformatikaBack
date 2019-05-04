package com.projekat.poslovna.service.base;

/**
 * Created by milan.miljus on 2019-04-28 01:04.
 */
public interface ICrud<T> extends IRead<T> {

    T save(T entity);

    void delete(T entity);

}
