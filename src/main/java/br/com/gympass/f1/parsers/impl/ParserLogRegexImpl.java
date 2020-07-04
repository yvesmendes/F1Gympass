package br.com.gympass.f1.parsers.impl;

import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.gympass.f1.exceptions.InvalidInputException;
import br.com.gympass.f1.model.log.builder.RaceLog;
import br.com.gympass.f1.model.log.builder.RaceLogBuilder;
import br.com.gympass.f1.parsers.ParserLog;

/**
 * Regex implementation of the {@link ParserLog}
 * @author yvesmendes
 */
public class ParserLogRegexImpl implements ParserLog {

	private static final int INDEX_EVENT_HOUR = 1;
	private static final int INDEX_DRIVER_ID = 2;
	private static final int INDEX_DRIVER_NAME = 3;
	private static final int INDEX_LAP_NUMBER= 4;
	private static final int INDEX_LAP_TIME = 5;
	private static final int INDEX_AVERAGE_SPEED = 6;

	private final Pattern linePattern = Pattern.compile("(\\d{2}\\:\\d{2}\\:\\d{2}\\.\\d{3}) "
			+ "(\\d{3}) \\– "
			+ "(\\w{1}\\.\\w+) "
			+ "(\\d{1,2}) "
			+ "(\\d{1}\\:\\d{2}\\.\\d{3}) "
			+ "(\\d{2}\\,\\d+)");

	@Override
	public RaceLog parser(String line) throws InvalidInputException, ParseException {
		line = line.replaceAll("\\s+", " ");
		Matcher matcher = linePattern.matcher(line);

		if (!matcher.matches()) {
			throw new InvalidInputException();
		}

		return RaceLogBuilder.getInstance()
				.atHour(matcher.group(INDEX_EVENT_HOUR))
				.ofDriverId(matcher.group(INDEX_DRIVER_ID))
				.ofDriverName(matcher.group(INDEX_DRIVER_NAME))
				.inLapNumber(matcher.group(INDEX_LAP_NUMBER))
				.withLapTime(matcher.group(INDEX_LAP_TIME))
				.withAverageSpeed(matcher.group(INDEX_AVERAGE_SPEED)).build();
	}
}
