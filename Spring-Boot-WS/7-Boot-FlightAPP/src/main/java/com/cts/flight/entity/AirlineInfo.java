package com.cts.flight.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class AirlineInfo {

	@Id
	@GeneratedValue
	private int airlineId;
	private String airlineName;
	private String airlineLogo;
	
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(name="flightsInformation",
	joinColumns = {@JoinColumn(name="airlineId")},
	inverseJoinColumns = {@JoinColumn(name="flightInfoid")})
	List<FlightInfo> flightsInformation=new ArrayList<>();
	
	
	

	public List<FlightInfo> getFlightsInformation() {
		return flightsInformation;
	}

	public void setFlightsInformation(List<FlightInfo> flightsInformation) {
		this.flightsInformation = flightsInformation;
	}

	public int getAirlineId() {
		return airlineId;
	}

	public void setAirlineId(int airlineId) {
		this.airlineId = airlineId;
	}

	public String getAirlineName() {
		return airlineName;
	}

	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}

	public String getAirlineLogo() {
		return airlineLogo;
	}

	public void setAirlineLogo(String airlineLogo) {
		this.airlineLogo = airlineLogo;
	}
	
	

}
