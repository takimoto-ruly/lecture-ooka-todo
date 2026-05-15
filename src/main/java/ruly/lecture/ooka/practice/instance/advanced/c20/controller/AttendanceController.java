package ruly.lecture.ooka.practice.instance.advanced.c20.controller;

import lombok.RequiredArgsConstructor;
import ruly.lecture.ooka.practice.instance.advanced.c20.dto.AttendanceRequest;
import ruly.lecture.ooka.practice.instance.advanced.c20.service.AttendanceService;

@RequiredArgsConstructor
public class AttendanceController {

	private final AttendanceService service;

	public String processAttendance(AttendanceRequest request) {
		service.calculateMonthlySalary(request.getEmployee(), request.getRecords());

		if (request == null || request.getRecords() == null) {
			return "Error: No Data";
		}

		if (service.getTotalAmount() > 1000000) {
			return "Alert: Check Manual";
		}

		return "Total:" + service.getTotalAmount() + "JPY";
	}
}