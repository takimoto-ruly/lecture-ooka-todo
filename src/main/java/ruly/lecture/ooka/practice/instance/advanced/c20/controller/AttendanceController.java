package ruly.lecture.ooka.practice.instance.advanced.c20.controller;

import lombok.RequiredArgsConstructor;
import ruly.lecture.ooka.practice.instance.advanced.c20.dto.AttendanceRequest;
import ruly.lecture.ooka.practice.instance.advanced.c20.service.AttendanceService;

@RequiredArgsConstructor
public class AttendanceController {

	private final AttendanceService service;

	public String processAttendance(AttendanceRequest request) {

		if (request == null || request.getRecords() == null || request.getRecords().isEmpty()) {
			return "Error: No Data";
		}

		int totalAmount = service.calculateMonthlySalary(request.getEmployee(), request.getRecords());

		if (totalAmount > 1000000) {
			return "Alert: Check Manual";
		}

		return "Total: " + totalAmount + " JPY";
	}
}