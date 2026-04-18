package com.autonationUSA.AutonationUSA.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.autonationUSA.AutonationUSA.model.OTP;

@Repository
public interface OTPRepo extends JpaRepository<OTP, String>{

}
