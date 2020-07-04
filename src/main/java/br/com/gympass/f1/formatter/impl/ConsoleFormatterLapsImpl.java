package br.com.gympass.f1.formatter.impl;

import br.com.gympass.f1.formatter.AbstractConsoleFormaterClassification;
import br.com.gympass.f1.model.RaceResult;

/**
 * Laps implementation for a formatter
 * @author yvesmendes
 *
 */
public class ConsoleFormatterLapsImpl extends AbstractConsoleFormaterClassification {

	@Override
	protected String formatHeader() {
		StringBuilder sb = new StringBuilder();

		sb.append(this.formatSeparator());
		sb.append(System.lineSeparator());
		sb.append(String.format("|%-10s|", " POSITION"));
		sb.append(String.format("%-25s|", " DRIVER"));
		sb.append(String.format("%-5s|", " LAP"));
		sb.append(String.format("%-15s|", " BEST LAP"));
		sb.append(String.format("%-15s|", " AVERAGE SPEED"));
		sb.append(System.lineSeparator());
		sb.append(this.formatSeparator());
		sb.append(System.lineSeparator());
		return sb.toString();
	}

	@Override
	protected String formatLine(RaceResult raceResult, int position, long firstElapsedTime) {
		StringBuilder sb = new StringBuilder();

		sb.append(String.format("|%-10s|", raceResult.isFinish() ? String.format("%02d", position) : NOT_CONCLUDED));
		sb.append(String.format("%-25s|", raceResult.getDriver()));
		sb.append(String.format(" %-4d|", raceResult.getLastLapNumber()));
		sb.append(String.format(" %-14s|", raceResult.getBestLapFormated()));
		sb.append(String.format(" %-14s|", raceResult.getAverageSpeedFormated()));
		sb.append(System.lineSeparator());

		return sb.toString();
	}

	@Override
	protected String getLengthFooter() {
		return "74";
	}
}
