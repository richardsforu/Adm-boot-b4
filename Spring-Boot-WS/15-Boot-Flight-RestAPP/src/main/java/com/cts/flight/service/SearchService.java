package com.cts.flight.service;

import java.util.List;

import com.cts.flight.entity.Flight;
import com.cts.flight.model.SearchQuery;

public interface SearchService {

	List<Flight> findFlightByOriginAndDestinationAndFlightDate(SearchQuery query);
	public Flight findById(int id);

}