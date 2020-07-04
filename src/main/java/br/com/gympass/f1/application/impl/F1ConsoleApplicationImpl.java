package br.com.gympass.f1.application.impl;

import br.com.gympass.f1.application.F1Application;
import br.com.gympass.f1.config.ComponentFactory;
import br.com.gympass.f1.controller.RaceController;
import br.com.gympass.f1.controller.impl.RaceControllerImpl;
import br.com.gympass.f1.exceptions.InvalidFileException;
import br.com.gympass.f1.formatter.enums.FormatterEnum;
import br.com.gympass.f1.model.Classification;

/**
 * Implementation of console application
 * 
 * @author yvesmendes
 */
public class F1ConsoleApplicationImpl implements F1Application {

	private RaceController raceControlle;

	public F1ConsoleApplicationImpl() {
		this.raceControlle = new RaceControllerImpl(ComponentFactory.getInstance().getRaceService());
	}

	@Override
	public void run(FormatterEnum formatterEnum) {
		try {
			Classification classification = this.raceControlle.executeAction(formatterEnum);
			System.out.println(formatterEnum.getConsoleFormaterClassification().formatClassification(classification));
		} catch (InvalidFileException e) {
			e.printStackTrace();
			System.out.println("Invalid file! Please inform a valid log file.");
		}
	}
}
