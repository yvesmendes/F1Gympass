package br.com.gympass.f1.formatter;

import br.com.gympass.f1.model.Classification;

/**
 * @author yvesmendes
 *
 */
public interface ConsoleFormaterClassification {

	/**
	 * Print the classification according the strategy
	 * @param classification the result for the race
	 */
	String formatClassification(Classification classification);
}
