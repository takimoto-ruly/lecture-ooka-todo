package ruly.lecture.ooka.practice.instance.advanced.c20.dto;

import java.util.List;

import lombok.Value;

@Value
public class AttendanceRequest {
	/**従業員*/
	private EmployeeDTO employee;
	private List<WorkRecordDTO> records;
}