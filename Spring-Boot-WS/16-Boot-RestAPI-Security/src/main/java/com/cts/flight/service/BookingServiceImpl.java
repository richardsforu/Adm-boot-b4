package com.cts.flight.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.flight.dao.BookingDao;
import com.cts.flight.entity.BookingRecord;
import com.cts.flight.entity.Flight;
import com.cts.flight.entity.Passenger;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingDao bookingDao;

	@Autowired
	private SearchService searchService;

	@Override
	public BookingRecord bookFlight(int id, int numberofPassengers, Passenger passenger) {

		Flight flight = searchService.findById(id);

		
			BookingRecord book = new BookingRecord();

			book.setOrigin(flight.getOrigin());
			book.setDestination(flight.getDestination());
			book.setFlightDate(flight.getFlightDate());
			book.setBookingDate(LocalDateTime.now());
			book.setFlightNumber(flight.getFlightNumber());
			book.setFlightTime(flight.getFlightTime());

			book.setPassenger(passenger);
			book.setFlightInfo(flight.getFlightInfo());
			book.setFare(flight.getFare().getFare() * numberofPassengers);

			book.setStatus("CONFIRMED");
			
			bookingDao.save(book);

		return book;
	}

}
