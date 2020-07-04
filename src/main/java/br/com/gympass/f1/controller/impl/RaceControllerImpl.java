package br.com.gympass.f1.controller.impl;

import br.com.gympass.f1.controller.RaceController;
import br.com.gympass.f1.exceptions.InvalidFileException;
import br.com.gympass.f1.formatter.enums.FormatterEnum;
import br.com.gympass.f1.model.Classification;
import br.com.gympass.f1.parsers.impl.ParserLogRegexImpl;
import br.com.gympass.f1.repository.impl.RaceLogInMemoryRepositoryImpl;
import br.com.gympass.f1.services.RaceService;
import br.com.gympass.f1.services.impl.RaceServiceImpl;

/**
 * 
 * @author yvesmendes
 */
public class RaceControllerImpl implements RaceController {

	private RaceService raceService;

	public RaceControllerImpl() {
		this.raceService = new RaceServiceImpl(new RaceLogInMemoryRepositoryImpl(new ParserLogRegexImpl()));
	}

	@Override
	public Classification executeAction(final FormatterEnum formatter) throws InvalidFileException {
		return raceService.getRaceResult(formatter);
	}
}
