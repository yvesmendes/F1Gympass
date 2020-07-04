package br.com.gympass.f1.config;

import br.com.gympass.f1.parsers.ParserLog;
import br.com.gympass.f1.parsers.impl.ParserLogRegexImpl;
import br.com.gympass.f1.repository.InputFile;
import br.com.gympass.f1.repository.impl.RaceLogInMemoryRepositoryImpl;
import br.com.gympass.f1.services.RaceService;
import br.com.gympass.f1.services.impl.RaceServiceImpl;

public class ComponentFactory {

	private ComponentFactory() {

	}

	public static ComponentFactory getInstance() {
		return new ComponentFactory();
	}

	public ParserLog getParserLog() {
		return new ParserLogRegexImpl();
	}

	public InputFile getInputFile() {
		return new InputFile();
	}

	public RaceService getRaceService() {
		return new RaceServiceImpl(new RaceLogInMemoryRepositoryImpl(this.getParserLog(), this.getInputFile()));
	}
}
