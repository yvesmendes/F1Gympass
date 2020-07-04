package br.com.gympass.f1;

import static org.hamcrest.core.IsEqual.equalTo;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.gympass.f1.model.log.builder.RaceLog;
import br.com.gympass.f1.parsers.impl.ParserLogRegexImpl;
import br.com.gympass.f1.repository.InputFile;
import br.com.gympass.f1.repository.RaceLogRepository;
import br.com.gympass.f1.repository.impl.RaceLogInMemoryRepositoryImpl;

/**
 * Unit test for simple App.
 */
public class RaceRepositoryTest {

	private static final String SRC_TEST_RESOURCES_INPUT_LOG = "src/test/resources/input.log";
	private static final int EXCEPTED_SIZE = 23;
	private static RaceLogRepository raceLogRepository;

	@BeforeClass
	public static void setup() {
		raceLogRepository = new RaceLogInMemoryRepositoryImpl(new ParserLogRegexImpl(),
				new InputFile(SRC_TEST_RESOURCES_INPUT_LOG));
	}

	@Test
	public void shouldReturnsAnArrayWithSize23() throws Exception {
		List<RaceLog> logs = raceLogRepository.findAll();
		Assert.assertThat(logs.size(), equalTo(EXCEPTED_SIZE));
	}
}
