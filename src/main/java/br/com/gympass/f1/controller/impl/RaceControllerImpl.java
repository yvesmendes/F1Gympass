package br.com.gympass.f1.controller.impl;

import br.com.gympass.f1.controller.RaceController;
import br.com.gympass.f1.exceptions.InvalidFileException;
import br.com.gympass.f1.formatter.enums.FormatterEnum;
import br.com.gympass.f1.model.Classification;
import br.com.gympass.f1.services.RaceService;

/**
 * 
 * @author yvesmendes
 */
public class RaceControllerImpl implements RaceController {

	private RaceService raceService;

	public RaceControllerImpl(RaceService raceService) {
		this.raceService = raceService;
	}

	@Override
	public Classification executeAction(final FormatterEnum formatter) throws InvalidFileException {
		return raceService.getRaceResult(formatter);
	}
}
