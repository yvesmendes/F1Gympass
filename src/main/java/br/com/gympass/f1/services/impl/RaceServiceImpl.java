package br.com.gympass.f1.services.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.gympass.f1.exceptions.InvalidFileException;
import br.com.gympass.f1.formatter.enums.FormatterEnum;
import br.com.gympass.f1.model.Classification;
import br.com.gympass.f1.model.Driver;
import br.com.gympass.f1.model.Lap;
import br.com.gympass.f1.model.log.builder.RaceLog;
import br.com.gympass.f1.repository.RaceLogRepository;
import br.com.gympass.f1.services.RaceService;

public class RaceServiceImpl implements RaceService {

	private static final int NUMBER_ZERO = 0;
	private RaceLogRepository raceLogRepository;

	public RaceServiceImpl(RaceLogRepository raceLogRepository) {
		this.raceLogRepository = raceLogRepository;
	}

	@Override
	public Classification getRaceResult(FormatterEnum formatter) throws InvalidFileException {

		List<RaceLog> raceLogs = this.raceLogRepository.findAll();

		Driver bestLapDriver = null;
		Date bestLapTimeRace = null;
		Map<Driver, Lap> laps = new HashMap<>();

		for (RaceLog raceLog : raceLogs) {
			Lap lap = laps.computeIfAbsent(raceLog.getDriver(), (key) -> new Lap());
			this.fillLaps(lap, raceLog);
			if (isNewBestLapTime(bestLapTimeRace, raceLog)) {
				bestLapTimeRace = raceLog.getLapTime();
				bestLapDriver = raceLog.getDriver();
			}
		}

		return new Classification(laps, bestLapDriver, bestLapTimeRace, formatter);
	}

	private boolean isNewBestLapTime(Date bestLapTimeRace, RaceLog raceLog) {
		return bestLapTimeRace == null || bestLapTimeRace.compareTo(raceLog.getLapTime()) > NUMBER_ZERO;
	}

	private void fillLaps(Lap lap, RaceLog raceLog) {
		lap.incrementAverageSpeed(raceLog.getAverageSpeed());
		lap.defineLapNumber(raceLog.getLapNumber());
		lap.incrementeEvaluatedTime(raceLog.getLapTime());
		lap.defineBestLap(raceLog.getLapTime());
		lap.defineLastEventTime(raceLog.getEventHour());
	}
}
