package br.com.gympass.f1.services;

import br.com.gympass.f1.exceptions.InvalidFileException;
import br.com.gympass.f1.formatter.enums.FormatterEnum;
import br.com.gympass.f1.model.Classification;

/**
 * Provides a service to access a Race
 * 
 * @author yvesmendes
 *
 */
public interface RaceService {

	/**
	 * Returns the result of the race
	 * 
	 * @param formatter
	 *            formatter for the result
	 * @return
	 * @throws InvalidFileException
	 */
	Classification getRaceResult(FormatterEnum formatter) throws InvalidFileException;
}
