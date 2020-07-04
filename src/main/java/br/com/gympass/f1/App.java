package br.com.gympass.f1;

import br.com.gympass.f1.application.F1Application;
import br.com.gympass.f1.application.impl.F1ConsoleApplicationImpl;
import br.com.gympass.f1.formatter.enums.FormatterEnum;

/**
 * Main class of the project
 */
public class App {
	public static void main(String[] args) {
		F1Application f1Application = new F1ConsoleApplicationImpl();

		FormatterEnum formatterEnum = FormatterEnum.GENERAL;

		if (args.length > 0) {
			formatterEnum = FormatterEnum.fromValue(args[0]);
		}

		f1Application.run(formatterEnum);
	}
}
