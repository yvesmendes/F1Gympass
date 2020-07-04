package br.com.gympass.f1.formatter;

import java.util.Set;

import br.com.gympass.f1.model.Classification;
import br.com.gympass.f1.model.RaceResult;
import br.com.gympass.f1.util.FormatDateUtil;

/**
 * Abstract class that define a contract to a formatter
 * @author yvesmendes
 */
public abstract class AbstractConsoleFormaterClassification implements ConsoleFormaterClassification {

	protected static final String NOT_CONCLUDED = "NC";
	protected static final String TIME_NOT_DEFINED = "DNF";
	
	@Override
	public final String formatClassification(Classification classification) {
		StringBuilder sb = new StringBuilder();
		sb.append(this.formatHeader());
		int i = 1;

		long firstElapsedTime = this.getFirstElapsedTime(classification);
		for (RaceResult raceResult : classification.getResultsByLap()) {
			sb.append(this.formatLine(raceResult, i, firstElapsedTime));
			i++;
		}

		sb.append(this.formatFooter(classification));
		
		return sb.toString();
	}


	private Long getFirstElapsedTime(Classification classification) {
		return classification.getResultsByLap().stream().findFirst().get().getElapsedTime();
	}
	

	protected Set<RaceResult> getRaceResults(Classification classification) {
		return classification.getResultsByLap();
	}
	
	protected String getElapsedTimeCumulative(RaceResult raceResult, int position, boolean finish, long firstElapsedTime) {
		StringBuilder sb = new StringBuilder();
		sb.append(raceResult.getFormatedElapsedTime());

		if(position > 1 && finish) {
			sb.append(" (+"+FormatDateUtil.getCumulativeLapTimeDateFormat().format(raceResult.getElapsedTime() - firstElapsedTime)+"s)");
		}
		
		return sb.toString();
	}

	/**
	 * Print the specific header
	 */
	protected abstract String formatHeader();

	/**
	 * Print the foot of the table
	 * 
	 * @param classification
	 */
	protected String formatFooter(Classification classification) {
		return this.formatSeparator();
	}

	protected String formatSeparator() {
		return String.format("|%" + getLengthFooter() + "s|", "").replaceAll(" ", "-");
	}

	protected abstract String getLengthFooter();

	/**
	 * Print the line
	 * @param raceResult an object representation of the race
	 * @param position the classification number
	 * @param firstElapsedTime  total of amount elapsed by the first drive
	 */
	protected abstract String formatLine(RaceResult raceResult, int position, long firstElapsedTime);
}
