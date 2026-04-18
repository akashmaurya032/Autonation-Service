package com.autonationUSA.AutonationUSA.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.autonationUSA.AutonationUSA.model.Sale;
import java.util.Date;


@Repository
public interface SalesRepo extends JpaRepository<Sale, Long>{

	List<Sale> findBySaleDateBetween(Date startDate, Date endDate);
	
	
}
