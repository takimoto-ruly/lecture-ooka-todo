package ruly.lecture.ooka.practice.instance.advanced.c20.dto;

import java.util.List;

import lombok.Value;

@Value
public class AttendanceRequest {
	EmployeeDTO employee;
	List<WorkRecordDTO> records;
}