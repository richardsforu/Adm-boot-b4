package com.cts.flight.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.flight.dao.FlightDao;
import com.cts.flight.entity.Flight;
import com.cts.flight.model.SearchQuery;

@Service
public class SearchServiceImpl implements SearchService {

	@Autowired
	private FlightDao flightDao;

	@Override
	public List<Flight> findFlightByOriginAndDestinationAndFlightDate(SearchQuery query) {

		List<Flight> flights = flightDao.findFlightByOriginAndDestinationAndFlightDate(query.getOrigin(),
				query.getDestination(), query.getFlightDate());

		return flights.stream().filter(flight -> flight.getInventory().getCount() >= query.getNumberofPassengers())
				.collect(Collectors.toList());
	}
	
	
	public Flight findById(int id) {
		return flightDao.findById(id).orElse(null);
	}
	
	
	

}
