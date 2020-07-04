package br.com.gympass.f1.model.log.builder;

import java.text.ParseException;
import java.util.Date;

import br.com.gympass.f1.model.Driver;
import br.com.gympass.f1.util.FormatDateUtil;

public class RaceLogBuilder {
	
	private Date eventHour;
	private String driverName;
	private int lapNumber;
	private Date lapTime;
	private Double averageSpeed;
	private String driverId;

	private RaceLogBuilder() {
	}

	/**
	 * Provides access to a RaceLogBuilder
	 * 
	 * @return returns a instance of {@link RaceLogBuilder}
	 */
	public static RaceLogBuilder getInstance() {
		return new RaceLogBuilder();
	}

	public RaceLogBuilder atHour(String eventHour) throws ParseException {
		this.eventHour = FormatDateUtil.getEventHourDateFormat().parse(eventHour);
		return this;
	}

	public RaceLogBuilder ofDriverName(String driverName) {
		this.driverName = driverName;
		return this;
	}

	public RaceLogBuilder ofDriverId(String driverId) {
		this.driverId = driverId;
		return this;
	}

	public RaceLogBuilder inLapNumber(String lapNumber) {
		this.lapNumber = Integer.valueOf(lapNumber);
		return this;
	}

	public RaceLogBuilder withLapTime(String lapTime) throws ParseException {
		this.lapTime = FormatDateUtil.getLapTimeDateFormat().parse(lapTime);
		return this;
	}

	public RaceLogBuilder withAverageSpeed(String averageSpeed) {
		this.averageSpeed = Double.valueOf(averageSpeed.replaceAll(",", "."));
		return this;
	}

	public RaceLog build() {
		return new RaceLog(this.eventHour, new Driver(this.driverId, this.driverName), this.lapNumber, this.lapTime,
				this.averageSpeed);
	}
}
