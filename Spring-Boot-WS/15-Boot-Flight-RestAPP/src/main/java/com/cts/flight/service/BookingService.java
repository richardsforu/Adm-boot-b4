package com.cts.flight.service;

import com.cts.flight.entity.BookingRecord;
import com.cts.flight.entity.Passenger;

public interface BookingService {

	BookingRecord bookFlight(int id, int numberofPassengers, Passenger passenger);

}