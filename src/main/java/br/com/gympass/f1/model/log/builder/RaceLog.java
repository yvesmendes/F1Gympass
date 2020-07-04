package br.com.gympass.f1.model.log.builder;

import java.util.Date;

import br.com.gympass.f1.model.Driver;

public class RaceLog {
	
	private final Date eventHour;
	private final Driver driver;
	private final int lapNumber;
	private final Date lapTime;
	private final Double averageSpeed;

	/**
	 * Default constructor to avoid other classes to instantiate a RaceLog class
	 */
	RaceLog(Date eventHour, Driver driver, int lapNumber, Date lapTime, Double averageSpeed) {
		this.eventHour = eventHour;
		this.driver = driver;
		this.lapNumber = lapNumber;
		this.lapTime = lapTime;
		this.averageSpeed = averageSpeed;
	}

	public Double getAverageSpeed() {
		return averageSpeed;
	}

	public Driver getDriver() {
		return driver;
	}

	public Date getEventHour() {
		return eventHour;
	}

	public int getLapNumber() {
		return lapNumber;
	}

	public Date getLapTime() {
		return lapTime;
	}
}
