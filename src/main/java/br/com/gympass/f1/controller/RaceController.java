package br.com.gympass.f1.controller;

import br.com.gympass.f1.exceptions.InvalidFileException;
import br.com.gympass.f1.formatter.enums.FormatterEnum;
import br.com.gympass.f1.model.Classification;

/**
 * @author yvesmendes
 */
public interface RaceController {

	/**
	 * Execute a action trigged by the application.
	 * 
	 * @param pathLogFile a path to log file
	 * @param formatter formatter for the result
	 * @return return a classification result for the race
	 * @throws InvalidFileException  if a invalid input file has informed
	 */
	Classification executeAction(final String pathLogFile, final FormatterEnum formatter) throws InvalidFileException;
}
