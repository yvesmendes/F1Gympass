package br.com.gympass.f1.repository;

import java.io.IOException;
import java.net.URISyntaxException;
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

	private static final String DEFAULT_INPUT_LOG_NAME = "input.log";
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
	public List<RaceLog> findAll(String pathLogFile) throws InvalidFileException {
		Path path = null;
		List<String> lines = null;
		try {
			path = getPath(pathLogFile);
			lines = Files.readAllLines(path);
		} catch (IOException | URISyntaxException e) {
			lines = tryWithClassLoader(pathLogFile, lines, e);
		}
		return this.parseLines(lines);
	}

	private List<String> tryWithClassLoader(String pathLogFile, List<String> lines, Exception e)
			throws InvalidFileException {
		Path path;
		URL url = ClassLoader.getSystemResource(pathLogFile);

		try {
			path = Paths.get(url.toURI());
			lines = Files.readAllLines(path);
		} catch (Exception e1) {
			throw new InvalidFileException(e1);
		}
		return lines;
	}

	private Path getPath(String pathLogFile) throws URISyntaxException {
		Path path = null;
		if (pathLogFile == null) {
			path = Paths.get(ClassLoader.getSystemResource(DEFAULT_INPUT_LOG_NAME).toURI());
		} else {
			path = Paths.get(pathLogFile);
		}
		return path;
	}

	/**
	 * Parse the lines of the log to a {@link RaceLog}
	 * 
	 * @param lines
	 * @return
	 */
	protected abstract List<RaceLog> parseLines(List<String> lines);
}
