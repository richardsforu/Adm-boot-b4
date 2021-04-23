package com.cts.flight.service;

import com.cts.flight.entity.CheckIn;

public interface CheckinService {

	CheckIn checkin(int bookingId);

	CheckIn findById(int checkinId);

}