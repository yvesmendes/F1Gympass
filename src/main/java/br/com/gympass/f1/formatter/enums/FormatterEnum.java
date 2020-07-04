package br.com.gympass.f1.formatter.enums;

import java.util.Arrays;
import java.util.Comparator;

import br.com.gympass.f1.formatter.ConsoleFormaterClassification;
import br.com.gympass.f1.formatter.impl.ConsoleFormatterF1Impl;
import br.com.gympass.f1.formatter.impl.ConsoleFormatterGeneralImpl;
import br.com.gympass.f1.formatter.impl.ConsoleFormatterLapsImpl;
import br.com.gympass.f1.model.RaceResult;

/**
 * Types of Formmaters used in application
 * @author yvesmendes
 *
 */
public enum FormatterEnum {

	GENERAL("general") {
		@Override
		public ConsoleFormaterClassification getConsoleFormaterClassification() {
			return new ConsoleFormatterGeneralImpl();
		}
	},
	FATEST_LAPS("laps") {
		@Override
		public ConsoleFormaterClassification getConsoleFormaterClassification() {
			return new ConsoleFormatterLapsImpl();
		}
		
		@Override
		public Comparator<RaceResult> getComparator() {
			return Comparator.comparing(RaceResult::getBestLap);
		}
	},
	F1_RESULT("f1") {
		@Override
		public ConsoleFormaterClassification getConsoleFormaterClassification() {
			return new ConsoleFormatterF1Impl();
		}
	};

	private String key;

	/**
	 * Returns the FormaterClassification according the type
	 * @return a {@link ConsoleFormaterClassification} to formatter the input file
	 */
	public abstract ConsoleFormaterClassification getConsoleFormaterClassification();
	
	public Comparator<RaceResult> getComparator(){
		return null;
	}

	private FormatterEnum(String key) {
		this.key = key;
	}

	public FormatterEnum fromValue(String value) {
		return Arrays.stream(FormatterEnum.values())
				.filter(e -> e.key.equals(value))
				.findFirst()
				.orElse(FormatterEnum.GENERAL);
	}
}
