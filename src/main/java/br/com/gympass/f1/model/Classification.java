package br.com.gympass.f1.model;

import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import br.com.gympass.f1.formatter.enums.FormatterEnum;
import br.com.gympass.f1.util.FormatDateUtil;

/**
 * Represent the classification of a race
 * 
 * @author yvesmendes
 */
public final class Classification {

	private static final String CHARACTER_SEPARATOR = " - ";
	private Set<RaceResult> resultsByLap;
	private final Driver bestLapDriver;
	private Date bestLapTimeRace;

	public Classification(final Map<Driver, Lap> laps, final Driver bestLapDriver, final Date bestLapTimeRace,
			final FormatterEnum formatter) {
		this.resultsByLap = new TreeSet<>(formatter.getComparator());
		
		for (Driver key : laps.keySet()) {
			resultsByLap.add(new RaceResult(key, laps.get(key)));
		}
		this.bestLapDriver = bestLapDriver;
		this.bestLapTimeRace = bestLapTimeRace;
	}

	/**
	 * Returns a unmodifiable set of laps
	 * @return
	 */
	public Set<RaceResult> getResultsByLap() {
		return Collections.unmodifiableSet(resultsByLap);
	}

	/**
	 * Returns the best lap formated
	 * @return
	 */
	public String bestLapRace() {
		return bestLapDriver + CHARACTER_SEPARATOR + FormatDateUtil.getLapTimeDateFormat().format(bestLapTimeRace);
	}
}
