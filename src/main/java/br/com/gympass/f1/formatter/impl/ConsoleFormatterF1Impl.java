package br.com.gympass.f1.formatter.impl;

import br.com.gympass.f1.formatter.AbstractConsoleFormaterClassification;
import br.com.gympass.f1.model.RaceResult;

/**
 * Default Implemetation of formatter
 * @author yvesmendes
 *
 */
public class ConsoleFormatterF1Impl extends AbstractConsoleFormaterClassification {

	@Override
	protected String formatLine(RaceResult raceResult, int position, long firstElapsedTime) {
		boolean finish = raceResult.isFinish();
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("|%-10s|", finish ? String.format("%02d", position) : NOT_CONCLUDED));
		sb.append(String.format("%-25s|", raceResult.getDriver()));
		sb.append(String.format(" %-4d|", raceResult.getLastLapNumber()));
		sb.append(String.format(" %-25s|", finish ? 
				this.getElapsedTimeCumulative(raceResult, position, finish, firstElapsedTime) : TIME_NOT_DEFINED));
		sb.append(System.lineSeparator());
		
		return sb.toString();
	}

	@Override
	protected String formatHeader() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(this.formatSeparator());
		sb.append(System.lineSeparator());
		sb.append(String.format("|%-10s|", " POSITION"));
		sb.append(String.format("%-25s|", " DRIVER"));
		sb.append(String.format("%-5s|", " LAP"));
		sb.append(String.format("%-26s|", " TIME"));
		sb.append(System.lineSeparator());
		sb.append(this.formatSeparator());
		sb.append(System.lineSeparator());
		return sb.toString();
	}

	@Override
	protected String getLengthFooter() {
		return "69";
	}
}
