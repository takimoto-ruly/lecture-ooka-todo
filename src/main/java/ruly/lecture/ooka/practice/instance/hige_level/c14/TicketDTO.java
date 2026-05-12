package ruly.lecture.ooka.practice.instance.hige_level.c14;

import lombok.Getter;

@Getter
public class TicketDTO {

	private String passengerName;
	private String fileNumber;

	public TicketDTO(String passengerName, String fileNumber) {
		this.passengerName = passengerName;
		this.fileNumber = fileNumber;
	}
}
