package br.com.gympass.f1;

import static org.hamcrest.core.IsEqual.equalTo;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.gympass.f1.exceptions.InvalidFileException;
import br.com.gympass.f1.exceptions.InvalidInputException;
import br.com.gympass.f1.model.log.builder.RaceLog;
import br.com.gympass.f1.parsers.impl.ParserLogRegexImpl;
import br.com.gympass.f1.repository.RaceLogRepository;
import br.com.gympass.f1.repository.impl.RaceLogInMemoryRepositoryImpl;

/**
 * Unit test for simple App.
 */
public class RaceRepositoryTest {

	private static final int S = 23;
	private static final String INVALID_PARSE_LOG = "invalid_parse.log";
	private static final String INVALID_PATH = "INVALID_PATH";
	private static RaceLogRepository raceLogRepository;

	@BeforeClass
	public static void setup() {
		raceLogRepository = new RaceLogInMemoryRepositoryImpl(new ParserLogRegexImpl());
	}

	@Test
	public void shouldReturnsAnArrayWithSize23() throws Exception {
		List<RaceLog> logs = raceLogRepository.findAll(null);
		Assert.assertThat(logs.size(), equalTo(S));
	}

	@Test(expected = InvalidFileException.class)
	public void shouldThrowsIOException() throws Exception {
		raceLogRepository.findAll(INVALID_PATH);
	}

	@Test(expected = InvalidInputException.class)
	public void shouldThrowsInvalidParseException() throws Exception {
		raceLogRepository.findAll(INVALID_PARSE_LOG);
	}

}
