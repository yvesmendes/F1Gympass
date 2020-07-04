package br.com.gympass.f1.parsers;

import java.text.ParseException;

import br.com.gympass.f1.exceptions.InvalidInputException;
import br.com.gympass.f1.model.log.builder.RaceLog;

/**
 * Default interface to parsers
 * 
 * @author yvesmendes
 */
public interface ParserLog {

	/**
	 * Parser a line transforming in a {@link RaceLog}
	 * 
	 * @param line
	 *            The actual line of the log
	 * @return A {@link RaceLog} with the informations of the line
	 * @throws InvalidInputException
	 * @throws ParseException
	 */
	RaceLog parser(String line) throws InvalidInputException, ParseException;
}
