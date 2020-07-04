package br.com.gympass.f1.repository;

public class InputFile {
	private final String path;
	private static final String DEFAULT_INPUT_LOG_NAME = "src/main/resources/input.log";

	public InputFile() {
		this.path = DEFAULT_INPUT_LOG_NAME;
	}

	public InputFile(String inputFile) {
		this.path = inputFile;
	}

	public String getPath() {
		return path;
	}
}
