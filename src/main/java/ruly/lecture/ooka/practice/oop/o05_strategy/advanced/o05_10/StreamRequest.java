package ruly.lecture.ooka.practice.oop.o05_strategy.advanced.o05_10;

public class StreamRequest {
	private final String paylord;

	public StreamRequest(String paylord) {
		if (paylord == null || paylord.isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.paylord = paylord;
	}

	public String getMaintext(DataProcessingStrategy dataProcessingStrategy) {
		return dataProcessingStrategy.textProcessing(paylord);
	}
}