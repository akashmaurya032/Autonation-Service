package com.autonationUSA.AutonationUSA.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.autonationUSA.AutonationUSA.model.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin, String>{

}
