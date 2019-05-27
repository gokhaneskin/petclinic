package com.gokhaneskin.petclinic.dao;

import com.gokhaneskin.petclinic.model.Pet;

import java.util.List;

public interface PetRepository {

    Pet findById(Long id);
    List<Pet> findByOwnerId(Long ownerId);
    void create(Pet pet);
    Pet udpate(Pet pet);
    void delete(Long id);
    void deleteByOwnerId(Long ownerId);
}
