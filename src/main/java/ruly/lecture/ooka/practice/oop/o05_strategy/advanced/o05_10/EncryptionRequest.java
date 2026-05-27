package ruly.lecture.ooka.practice.oop.o05_strategy.advanced.o05_10;

public class EncryptionRequest extends SecureRequest {
	public EncryptionRequest(String paylord) {
		super(paylord);
	}

	public String getMaintext(DataProcessingStrategy dataProcessingStrategy) {
		return super.getMaintext(dataProcessingStrategy) + "_SIGNED_VERIFIED";
	}
}
