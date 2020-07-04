package br.com.gympass.f1;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.BeforeClass;
import org.junit.Test;

import br.com.gympass.f1.controller.RaceController;
import br.com.gympass.f1.controller.impl.RaceControllerImpl;
import br.com.gympass.f1.formatter.enums.FormatterEnum;
import br.com.gympass.f1.model.Classification;

/**
 * Unit test for simple App.
 */
public class RaceControllerTest {

	private static final int SIZE_OF_DRIVERS = 6;
	private static RaceController raceController;

	@BeforeClass
	public static void setup() {
		raceController = new RaceControllerImpl();
	}

	@Test
	public void shouldSuccessOnGetRaceResult() throws Exception {
		Classification classification = raceController.executeAction(null, FormatterEnum.GENERAL);
		assertThat(classification.getResultsByLap().size(), equalTo(SIZE_OF_DRIVERS));
	}
}
