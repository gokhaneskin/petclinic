package com.gokhaneskin.petclinic.service;

import com.gokhaneskin.petclinic.exception.OwnerNotFoundException;
import com.gokhaneskin.petclinic.model.Owner;

import java.util.List;

public interface PetClinicService {
    List<Owner> findOwners();
    List<Owner> findOwners(String lastName);
    Owner findOwner(Long id)throws OwnerNotFoundException;
    void createOwner(Owner owner);
    void update(Owner owner);
    void deleteOwner(Long id);
}
