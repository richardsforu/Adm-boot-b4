package com.cts.flight.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.flight.dao.BookingDao;
import com.cts.flight.dao.CheckinDao;
import com.cts.flight.entity.BookingRecord;
import com.cts.flight.entity.CheckIn;

@Service
public class CheckinServiceImpl implements CheckinService {

	@Autowired
	private CheckinDao checkinDao;

	@Autowired
	private BookingDao bookingDao;

	@Override
	public CheckIn checkin(int bookingId) {

		BookingRecord bookingRecord = bookingDao.findById(bookingId).orElse(null);

		if (bookingRecord != null) {
			CheckIn checkin = new CheckIn();
			checkin.setCheckinTime(LocalDateTime.now());
			checkin.setSeatNumber("A2");

			bookingRecord.setStatus("CheckedIN");
			checkin.setBookingRecord(bookingRecord);

			checkinDao.save(checkin);
			return checkin;

		}
		// BookingRecord bookingRecord= checkinDao.findByBookingId(bookingId);

		return null;
	}

	@Override
	public CheckIn findById(int checkinId) {
		// TODO Auto-generated method stub
		return checkinDao.findById(checkinId).orElse(null);
	}

}
