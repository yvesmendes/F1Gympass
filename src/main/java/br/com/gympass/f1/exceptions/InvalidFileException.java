package br.com.gympass.f1.exceptions;

/**
 * Identify an invalid file 
 * @author yvesmendes
 *
 */
public final class InvalidFileException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidFileException(Exception e) {
		super(e);
	}
}
