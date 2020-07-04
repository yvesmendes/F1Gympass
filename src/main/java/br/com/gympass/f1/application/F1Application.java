package br.com.gympass.f1.application;

import br.com.gympass.f1.formatter.enums.FormatterEnum;

/**
 * Contract that defines run method to the application
 * @author yvesmendes
 */
public interface F1Application {

	/**
	 * Run application
	 * @param pathFile path to log file
	 * @param formatterEnum the type of tabular formatation
	 */
	void run(String pathFile, FormatterEnum formatterEnum);

}
