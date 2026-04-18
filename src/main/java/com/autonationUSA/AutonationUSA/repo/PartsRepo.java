package com.autonationUSA.AutonationUSA.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.autonationUSA.AutonationUSA.model.Parts;

@Repository("partsRepo")
public interface PartsRepo extends JpaRepository<Parts, Long>{

}
