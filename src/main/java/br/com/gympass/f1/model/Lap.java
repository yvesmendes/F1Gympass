package br.com.gympass.f1.model;

import java.util.Date;

/**
 * Represents a lap in the model.
 * 
 * @author yvesmendes
 */
public class Lap {

	private static final int LAST_NUMBER_VALUE = 4;
	private Integer lapNumber;
	private Date bestLapTime;
	private Date evaluatedTime;
	private double averageSpeed;
	private Date eventTime;

	public Lap() {
		this.lapNumber = 0;
	}

	public int getLapNumber() {
		return lapNumber;
	}

	public void incrementAverageSpeed(Double averageSpeed) {
		this.averageSpeed = Double.sum(this.averageSpeed, averageSpeed);
	}

	public void incrementeEvaluatedTime(Date evaluatedTime) {
		if (this.evaluatedTime == null) {
			this.evaluatedTime = evaluatedTime;
			return;
		}
		this.evaluatedTime = new Date(this.evaluatedTime.getTime() + evaluatedTime.getTime());
	}

	public void defineBestLap(Date bestLap) {
		if (this.bestLapTime == null) {
			this.bestLapTime = bestLap;
		}

		if (this.bestLapTime.compareTo(bestLap) > 0) {
			this.bestLapTime = bestLap;
		}
	}

	public boolean isFinish() {
		return lapNumber.equals(LAST_NUMBER_VALUE);
	}

	public Double getAverageSpeed() {
		return this.averageSpeed;
	}

	public Integer getLastNumberLap() {
		return this.lapNumber;
	}

	public Long getElapsedTime() {
		return evaluatedTime.getTime();
	}

	public Date getLastEventTime() {
		return this.eventTime;
	}

	public Date getBestLap() {
		return this.bestLapTime;
	}

	public void defineLapNumber(int lapNumber) {
		if (lapNumber > this.lapNumber) {
			this.lapNumber = lapNumber;
		}
	}

	public void defineLastEventTime(Date eventHour) {
		if (this.eventTime == null) {
			this.eventTime = eventHour;
		}

		if (this.eventTime.compareTo(eventHour) > 0) {
			this.eventTime = eventHour;
		}
	}
}
