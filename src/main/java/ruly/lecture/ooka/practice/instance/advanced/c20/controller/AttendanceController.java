package ruly.lecture.ooka.practice.instance.advanced.c20.controller;

import lombok.RequiredArgsConstructor;
import ruly.lecture.ooka.practice.instance.advanced.c20.dto.AttendanceRequest;
import ruly.lecture.ooka.practice.instance.advanced.c20.service.AttendanceService;

@RequiredArgsConstructor
public class AttendanceController {

	private final AttendanceService service;

	public String processAttendance(AttendanceRequest request) {
		// TODO: serviceを呼び出し、結果メッセージを生成
		return "";
	}
}