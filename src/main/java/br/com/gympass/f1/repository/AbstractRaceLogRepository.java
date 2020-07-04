package br.com.gympass.f1.repository;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import br.com.gympass.f1.exceptions.InvalidFileException;
import br.com.gympass.f1.model.log.builder.RaceLog;
import br.com.gympass.f1.parsers.ParserLog;

/**
 * AbstractRaceLog to load the logFile
 * 
 * @author yvesmendes
 */
public abstract class AbstractRaceLogRepository implements RaceLogRepository {
	private static final String DEFAULT_INPUT_LOG_NAME = "src/main/resources/input.log";

	protected ParserLog parser;

	/**
	 * Constructor of the RaceLogRepository
	 * 
	 * @param parser
	 *            a parserLog to parse lines of the log
	 */
	public AbstractRaceLogRepository(ParserLog parser) {
		this.parser = parser;
	}

	/**
	 * Return all lines of the log
	 * 
	 * @return
	 * @throws InvalidFileException
	 */
	public List<RaceLog> findAll() throws InvalidFileException {
		List<String> lines = null;
		lines = tryWithClassLoader(lines);
		return this.parseLines(lines);
	}

	private List<String> tryWithClassLoader(List<String> lines) throws InvalidFileException {
		Path path;
		
		try {
			path = Paths.get(DEFAULT_INPUT_LOG_NAME);
			lines = Files.readAllLines(path);
		} catch (Exception e1) {
			throw new InvalidFileException(e1);
		}
		return lines;
	}

	/**
	 * Parse the lines of the log to a {@link RaceLog}
	 * 
	 * @param lines
	 * @return
	 */
	protected abstract List<RaceLog> parseLines(List<String> lines);
}
