package ruly.lecture.ooka.practice.instance.advanced.c20.dto;

import lombok.Value;

@Value
public class EmployeeDTO {
	private String id;
	/**時給*/
	private int hourlyRate;
	/**役割*/
	private String role; // "STANDARD" or "MANAGER"
}
