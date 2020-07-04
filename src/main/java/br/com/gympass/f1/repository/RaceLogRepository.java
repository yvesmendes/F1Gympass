package br.com.gympass.f1.repository;

import java.util.List;

import br.com.gympass.f1.exceptions.InvalidFileException;
import br.com.gympass.f1.model.log.builder.RaceLog;

/**
 * Repository to access the race data of the log
 * @author yvesmendes
 *
 */
public interface RaceLogRepository {

	/**
	 * Return all lines of the log
	 * @param inputFile Define the path of the input file
	 * @return
	 * @throws InvalidFileException
	 */
	List<RaceLog> findAll() throws InvalidFileException;
}
