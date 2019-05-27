package com.gokhaneskin.petclinic.dao;

import com.gokhaneskin.petclinic.model.Owner;

import java.util.List;

public interface OwnerRepository {

    List<Owner> findAll();
    Owner findById(Long id);
    List<Owner> findByLastName(String lastName);
    void create(Owner owner);
    Owner update(Owner owner);
    void delete(Long id);

}
