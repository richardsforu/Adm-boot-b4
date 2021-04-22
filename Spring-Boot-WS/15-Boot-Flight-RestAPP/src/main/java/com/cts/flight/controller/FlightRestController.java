package com.cts.flight.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.flight.entity.CheckIn;
import com.cts.flight.entity.Flight;
import com.cts.flight.entity.Passenger;
import com.cts.flight.model.SearchQuery;
import com.cts.flight.service.BookingService;
import com.cts.flight.service.CheckinService;
import com.cts.flight.service.SearchService;

@RestController
@RequestMapping("/api/pss")
@CrossOrigin
public class FlightRestController {

	@Autowired
	private SearchService searchService;

	@Autowired
	private BookingService bookingService;

	@Autowired
	private CheckinService checkinService;

	// find flight by origin,destination and flying date
	@PostMapping
	public List<Flight> findFlights(@RequestBody SearchQuery query) {
		System.out.println(">>>> origin:: " + query.getOrigin());
		System.out.println(">>>> Destination:: " + query.getDestination());
		System.out.println(">>>> Flying date:: " + query.getFlightDate());
		return searchService.findFlightByOriginAndDestinationAndFlightDate(query);
	}

	@PostMapping("/{id}/{numberofPassengers}")
	public ResponseEntity<?> bookFlight(@RequestBody Passenger passenger, @PathVariable("id") int id,

			@PathVariable("numberofPassengers") int numberofPassengers) {

		/*
		 * System.out.println(">>> Flight ID: "+id);
		 * System.out.println(">> Nunberof Passengwrs:: "+numberofPassengers);
		 * System.out.println(passenger); for(CoPassenger
		 * cp:passenger.getCoPassengers()) { System.out.println(cp);
		 * System.out.println("-----------------------------------"); }
		 * 
		 */

		if (passenger != null)
			if (numberofPassengers - 1 == passenger.getCoPassengers().size()) {
				// bookingDao.save(book);

				return new ResponseEntity<>(bookingService.bookFlight(id, numberofPassengers, passenger),
						HttpStatus.OK);

				// return ;
			}

		return new ResponseEntity<>("Some Error Occured...", HttpStatus.NOT_FOUND);
	}

	@GetMapping("/{bookingId}")
	public CheckIn checkin(@PathVariable int bookingId) {
		return checkinService.checkin(bookingId);
	}

	@GetMapping("/checkin/{checkinId}")
	public CheckIn getCheckinInfo(@PathVariable int checkinId) {
		return checkinService.findById(checkinId);
	}

}
