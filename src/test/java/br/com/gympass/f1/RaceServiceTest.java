package br.com.gympass.f1;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.gympass.f1.formatter.enums.FormatterEnum;
import br.com.gympass.f1.model.Classification;
import br.com.gympass.f1.model.Driver;
import br.com.gympass.f1.parsers.impl.ParserLogRegexImpl;
import br.com.gympass.f1.repository.impl.RaceLogInMemoryRepositoryImpl;
import br.com.gympass.f1.services.impl.RaceServiceImpl;

/**
 * Unit test for simple App.
 */
public class RaceServiceTest {

	private static final int SIZE_OF_DRIVERS = 6;
	private static final String BEST_LAP_TIME = "01:02.769";
	private static final String DRIVER_NAME_MASSA = "F.MASSA";
	private static final String DRIVER_ID_MASSA = "038";
	private static RaceServiceImpl raceService;

	@BeforeClass
	public static void setup() {
		raceService = new RaceServiceImpl(new RaceLogInMemoryRepositoryImpl(new ParserLogRegexImpl()));
	}

	@Test
	public void shouldSuccessOnGetRaceResult() throws Exception {
		Classification classification = raceService.getRaceResult(FormatterEnum.GENERAL);
		assertThat(classification.getResultsByLap().size(), equalTo(SIZE_OF_DRIVERS));
	}

	@Test
	public void shouldReturnsMassaAsWinner() throws Exception {
		Classification classification = raceService.getRaceResult(FormatterEnum.GENERAL);
		assertThat(classification.getResultsByLap().iterator().next().getDriver(),
				equalTo(new Driver(DRIVER_ID_MASSA, DRIVER_NAME_MASSA)));
		assertThat(classification.getResultsByLap().iterator().next().getBestLapFormated(), equalTo(BEST_LAP_TIME));
	}
}
