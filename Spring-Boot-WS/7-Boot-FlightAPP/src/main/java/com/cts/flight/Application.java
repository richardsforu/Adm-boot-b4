package com.cts.flight;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cts.flight.dao.AirlineInfoDao;
import com.cts.flight.dao.FlightDao;
import com.cts.flight.entity.AirlineInfo;
import com.cts.flight.entity.Flight;
import com.cts.flight.entity.FlightInfo;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ac= SpringApplication.run(Application.class, args);
		
		FlightDao flightDao = ac.getBean(FlightDao.class);
		AirlineInfoDao flightInfoDao = ac.getBean(AirlineInfoDao.class);
	
		
		// 1. list all flights scheduled...
		/*
		flightDao.findAll().forEach(flight->{
			System.out.println(flight.getId());
			System.out.println(flight.getFlightNumber());
			System.out.println(flight.getOrigin());
			System.out.println(flight.getDestination());
			System.out.println(flight.getFlightDate());
			System.out.println(flight.getFlightTime());
			System.out.println(flight.getDuration());
			
			System.out.println("fare: "+flight.getFare().getFare());
			System.out.println("Availanle Seats: "+flight.getInventory().getCount());
			System.out.println("Flight Type: "+flight.getFlightInfo().getAirlineInfo().getAirlineName());
			System.out.println("-----------------------------------------------------------------");
		});
		
		*/
		
		/*
		// list all flights only from indigo
		AirlineInfo flights = flightInfoDao.findById(21).orElse(null);
		
		System.out.println("AirlineID Info ID: "+flights.getAirlineId());
		System.out.println("Airline Name: "+flights.getAirlineName());
		System.out.println("Logo: "+flights.getAirlineLogo());
		System.out.println("Flights Information of "+flights.getAirlineName());
		System.out.println("=====================================================");
		
		flights.getFlightsInformation().forEach(fi->{
			System.out.println("Flight Number: "+fi.getFlightNumber());
			System.out.println("Flight Type: "+fi.getFlightType());
			System.out.println("Max Seat Capacity: "+fi.getSeatCapacity());
			System.out.println("-------------------------------------------------");
		});
		
		*/
		
		
		// fetch all scheduled flights on 2021-02-26 date only 
		// List<Flight> flights = flightDao.findByFlightDate(LocalDate.of(2021, 02, 26));
		
		 /*
		
		flights.forEach(flight->{
			System.out.println(flight.getId());
			System.out.println(flight.getFlightNumber());
			System.out.println(flight.getOrigin());
			System.out.println(flight.getDestination());
			System.out.println(flight.getFlightDate());
			System.out.println(flight.getFlightTime());
			System.out.println(flight.getDuration());
			
			System.out.println("fare: "+flight.getFare().getFare());
			System.out.println("Availanle Seats: "+flight.getInventory().getCount());
			System.out.println("Flight Type: "+flight.getFlightInfo().getAirlineInfo().getAirlineName());
			System.out.println("-----------------------------------------------------------------");
		});
		
		System.out.println("Total : >>>>> "+flights.size());
		
		*/
		
		
		/*
		
		List<Flight> flights=flightDao.findByOriginAndDestination("Delhi", "Chennai");
		
		flights.forEach(flight->{
			System.out.println(flight.getId());
			System.out.println(flight.getFlightNumber());
			System.out.println(flight.getOrigin());
			System.out.println(flight.getDestination());
			System.out.println(flight.getFlightDate());
			System.out.println(flight.getFlightTime());
			System.out.println(flight.getDuration());
			
			System.out.println("fare: "+flight.getFare().getFare());
			System.out.println("Availanle Seats: "+flight.getInventory().getCount());
			System.out.println("Flight Type: "+flight.getFlightInfo().getAirlineInfo().getAirlineName());
			System.out.println("-----------------------------------------------------------------");
		});
		
		System.out.println("Total : >>>>> "+flights.size());
		
		*/
		
		/*
		List<Flight> flights=flightDao.findByOriginAndDestinationAndFlightDate("delhi", "chennai", LocalDate.of(2021, 02, 26));
		
		
		flights.forEach(flight->{
			System.out.println(flight.getId());
			System.out.println(flight.getFlightNumber());
			System.out.println(flight.getOrigin());
			System.out.println(flight.getDestination());
			System.out.println(flight.getFlightDate());
			System.out.println(flight.getFlightTime());
			System.out.println(flight.getDuration());
			
			System.out.println("fare: "+flight.getFare().getFare());
			System.out.println("Availanle Seats: "+flight.getInventory().getCount());
			System.out.println("Flight Type: "+flight.getFlightInfo().getAirlineInfo().getAirlineName());
			System.out.println("-----------------------------------------------------------------");
		});
		
		System.out.println("Total : >>>>> "+flights.size());
		
		*/
		
		/*
		List<Flight> flights= flightDao.findByFare_FareGreaterThanEqual(10000.00);
		
		flights.forEach(flight->{
			System.out.println(flight.getId());
			System.out.println(flight.getFlightNumber());
			System.out.println(flight.getOrigin());
			System.out.println(flight.getDestination());
			System.out.println(flight.getFlightDate());
			System.out.println(flight.getFlightTime());
			System.out.println(flight.getDuration());
			
			System.out.println("fare: "+flight.getFare().getFare());
			System.out.println("Availanle Seats: "+flight.getInventory().getCount());
			System.out.println("Flight Type: "+flight.getFlightInfo().getAirlineInfo().getAirlineName());
			System.out.println("-----------------------------------------------------------------");
		});
		
		System.out.println("Total : >>>>> "+flights.size());
		
		*/
		
		List<Flight> flights = flightDao.getDestinationFlights("chennai");
		flights.forEach(flight->{
			System.out.println(flight.getId());
			System.out.println(flight.getFlightNumber());
			System.out.println(flight.getOrigin());
			System.out.println(flight.getDestination());
			System.out.println(flight.getFlightDate());
			System.out.println(flight.getFlightTime());
			System.out.println(flight.getDuration());
			
			System.out.println("fare: "+flight.getFare().getFare());
			System.out.println("Availanle Seats: "+flight.getInventory().getCount());
			System.out.println("Flight Type: "+flight.getFlightInfo().getAirlineInfo().getAirlineName());
			System.out.println("-----------------------------------------------------------------");
		});
		
		System.out.println("Total : >>>>> "+flights.size());
		
	}
	
	

}
