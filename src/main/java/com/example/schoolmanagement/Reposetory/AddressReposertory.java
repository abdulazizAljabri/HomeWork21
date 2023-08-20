package com.example.schoolmanagement.Reposetory;

import com.example.schoolmanagement.Model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressReposertory extends JpaRepository<Address,Integer> {
    Address findAddressByAddressId(Integer addressId);
}
