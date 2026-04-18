package com.autonationUSA.AutonationUSA.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.autonationUSA.AutonationUSA.model.Car;
import java.util.List;


@Repository
public interface CarRepo extends JpaRepository<Car, Long>{
	
	List<Car> findByManufacturerAndPriceAndModelAndYearAndOdometerReading(String manufacturer, double price, String model, int year, int odometerReading);

}
