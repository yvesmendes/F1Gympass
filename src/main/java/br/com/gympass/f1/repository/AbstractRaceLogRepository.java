package br.com.gympass.f1.repository;

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

	protected ParserLog parser;
	private InputFile inputFile;

	/**
	 * Constructor of the RaceLogRepository
	 * 
	 * @param parser
	 *            a parserLog to parse lines of the log
	 */
	public AbstractRaceLogRepository(ParserLog parser, InputFile inputFile) {
		this.parser = parser;
		this.inputFile = inputFile;
	}

	/**
	 * Return all lines of the log
	 * 
	 * @return
	 * @throws InvalidFileException
	 */
	public List<RaceLog> findAll() throws InvalidFileException {
		return this.parseLines(getLinesFile());
	}

	private List<String> getLinesFile() throws InvalidFileException {
		try {
			Path path = Paths.get(this.inputFile.getPath());
			return Files.readAllLines(path);
		} catch (Exception e1) {
			throw new InvalidFileException(e1);
		}
	}

	/**
	 * Parse the lines of the log to a {@link RaceLog}
	 * 
	 * @param lines
	 * @return
	 */
	protected abstract List<RaceLog> parseLines(List<String> lines);
}
