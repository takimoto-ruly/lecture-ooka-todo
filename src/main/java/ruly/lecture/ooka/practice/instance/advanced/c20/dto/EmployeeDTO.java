package ruly.lecture.ooka.practice.instance.advanced.c20.dto;

import lombok.Value;

@Value
public class EmployeeDTO {
	String id;
	int hourlyRate;
	String role; // "STANDARD" or "MANAGER"
}
