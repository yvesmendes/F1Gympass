package br.com.gympass.f1.exceptions;

/**
 * Identify an invalid input in a file
 * @author yvesmendes
 *
 */
public final class InvalidInputException extends RuntimeException{

	private static final String INVALID_INPUT_LINE_FOR_LOG = "Invalid input line for log";

	public InvalidInputException(Exception e) {
		super(e);
	}

	public InvalidInputException() {
		super(INVALID_INPUT_LINE_FOR_LOG);
	}

	private static final long serialVersionUID = 1L;

}
