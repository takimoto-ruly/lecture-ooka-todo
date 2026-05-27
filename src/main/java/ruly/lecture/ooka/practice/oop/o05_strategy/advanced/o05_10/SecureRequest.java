package ruly.lecture.ooka.practice.oop.o05_strategy.advanced.o05_10;

public class SecureRequest extends StreamRequest {
	public SecureRequest(String paylord) {
		super(paylord);
	}

	@Override
	public String getMaintext(DataProcessingStrategy dataProcessingStrategy) {
		return " [SECURE_CHANNEL] " + super.getMaintext(dataProcessingStrategy);
	}
}
