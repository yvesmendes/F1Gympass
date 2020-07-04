package br.com.gympass.f1;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.gympass.f1.controller.RaceController;
import br.com.gympass.f1.controller.impl.RaceControllerImpl;
import br.com.gympass.f1.formatter.enums.FormatterEnum;
import br.com.gympass.f1.model.Classification;
import br.com.gympass.f1.parsers.ParserLog;
import br.com.gympass.f1.parsers.impl.ParserLogRegexImpl;
import br.com.gympass.f1.repository.InputFile;
import br.com.gympass.f1.repository.RaceLogRepository;
import br.com.gympass.f1.repository.impl.RaceLogInMemoryRepositoryImpl;
import br.com.gympass.f1.services.RaceService;
import br.com.gympass.f1.services.impl.RaceServiceImpl;

/**
 * Unit test for simple App.
 */
public class RaceControllerTest {
	private static final String SRC_TEST_RESOURCES_INPUT_LOG = "src/test/resources/input.log";
	private static final int SIZE_OF_DRIVERS = 6;
	private static RaceController raceController;

	@BeforeClass
	public static void setup() {
		ParserLog parserLog = new ParserLogRegexImpl();
		InputFile inputFile = new InputFile(SRC_TEST_RESOURCES_INPUT_LOG);
		RaceLogRepository raceLogRepository = new RaceLogInMemoryRepositoryImpl(parserLog, inputFile);
		RaceService raceService = new RaceServiceImpl(raceLogRepository);
		raceController = new RaceControllerImpl(raceService);
	}

	@Test
	public void shouldSuccessOnGetRaceResult() throws Exception {
		Classification classification = raceController.executeAction(FormatterEnum.GENERAL);
		assertThat(classification.getResultsByLap().size(), equalTo(SIZE_OF_DRIVERS));
	}
}
