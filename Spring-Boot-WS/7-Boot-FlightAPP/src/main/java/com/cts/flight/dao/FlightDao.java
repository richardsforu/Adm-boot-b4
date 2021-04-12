package com.cts.flight.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cts.flight.entity.Flight;

public interface FlightDao extends JpaRepository<Flight, Integer>{

	// DSL  domain-specific language
	
	/*
	 * Notes
	 * --------
	 * keywords like find,get,select,fetch,update and delete
	 * 
	 * 
	 * 
	 * 
	 */
	
	// using find
	//----------------
	
	// list all flights on a specified date
	List<Flight> findByFlightDate(LocalDate flightDate);
	
	// list all flights based on origin and destination
	List<Flight> findByOriginAndDestination(String origin,String destination);
	
	// list all flights based on date, origin and destination
	 
	List<Flight> findByOriginAndDestinationAndFlightDate(String origin,String destination,LocalDate flightDate);
	
	// list all flights whose fare is grater than or equals to 10000: is it possible with DSL? :: YES
	List<Flight> findByFare_FareGreaterThanEqual(double fare);
	
	
	// Custom Queries in Data JPA
	
	@Query(value = "from Flight f where f.origin =:origin")
	List<Flight> getOriginFlights(String origin);
	
	@Query(value = "from Flight f where f.destination =:dest")
	List<Flight> getDestinationFlights(@Param("dest") String str);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
