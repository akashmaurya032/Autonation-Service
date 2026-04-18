package com.autonationUSA.AutonationUSA.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.autonationUSA.AutonationUSA.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long>{

}
