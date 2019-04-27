package com.projekat.poslovna.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Created by milan.miljus on 2019-04-28 01:03.
 */
public interface IRead<T> {

    Optional<T> findById(UUID id);

    List<T> findAll();
}
