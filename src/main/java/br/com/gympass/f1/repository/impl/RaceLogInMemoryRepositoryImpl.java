package br.com.gympass.f1.repository.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import br.com.gympass.f1.exceptions.InvalidInputException;
import br.com.gympass.f1.model.log.builder.RaceLog;
import br.com.gympass.f1.parsers.ParserLog;
import br.com.gympass.f1.repository.AbstractRaceLogRepository;
import br.com.gympass.f1.repository.RaceLogRepository;

/**
 * In memory implementation for {@link RaceLogRepository}
 * 
 * @author yvesmendes
 */
public class RaceLogInMemoryRepositoryImpl extends AbstractRaceLogRepository {

	private static final int INDEX_ONE = 1;

	public RaceLogInMemoryRepositoryImpl(ParserLog parser) {
		super(parser);
	}

	@Override
	protected List<RaceLog> parseLines(final List<String> lines) {
		List<RaceLog> races = new ArrayList<>();
		lines.stream().skip(INDEX_ONE).forEach(line -> races.add(createRaceLog(line)));
		return races;
	}

	private RaceLog createRaceLog(String line) {
		try {
			return parser.parser(line);
		} catch (ParseException | InvalidInputException e) {
			throw new InvalidInputException(e);
		}
	}
}
