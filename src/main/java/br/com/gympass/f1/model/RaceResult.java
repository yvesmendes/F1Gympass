package br.com.gympass.f1.model;

import java.util.Date;

import br.com.gympass.f1.util.FormatDateUtil;

/**
 * Model as result of the race
 * 
 * @author yvesmendes
 */
public class RaceResult implements Comparable<RaceResult> {

	private final Driver driver;
	private final Lap lap;

	public RaceResult(final Driver driver, final Lap lap) {
		this.driver = driver;
		this.lap = lap;
	}

	public boolean isFinish() {
		return lap.isFinish();
	}

	public Double getAverageSpeed() {
		return lap.getAverageSpeed() / lap.getLastNumberLap();
	}

	public String getAverageSpeedFormated() {
		return FormatDateUtil.getDecimalFormat().format(this.getAverageSpeed());
	}

	public Date getBestLap() {
		return this.lap.getBestLap();
	}

	public String getBestLapFormated() {
		return FormatDateUtil.getLapTimeDateFormat().format(this.lap.getBestLap());
	}

	public int getLastLapNumber() {
		return lap.getLastNumberLap();
	}

	public Long getElapsedTime() {
		return this.lap.getElapsedTime();
	}

	public String getFormatedElapsedTime() {
		return FormatDateUtil.getLapTimeDateFormat().format(this.lap.getElapsedTime());
	}

	public Driver getDriver() {
		return driver;
	}

	public String getLastEventTime() {
		return FormatDateUtil.getEventHourDateFormat().format(lap.getLastEventTime());
	}

	@Override
	public int compareTo(RaceResult o) {
		if (!this.lap.isFinish()) {
			int r = this.lap.getLastNumberLap().compareTo(o.lap.getLastNumberLap());
			if (r == 0) {
				return this.lap.getLastEventTime().compareTo(o.lap.getLastEventTime());
			}
			return 1;
		}
		return this.lap.getLastEventTime().compareTo(o.lap.getLastEventTime());
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
