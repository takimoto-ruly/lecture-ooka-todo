package ruly.lecture.ooka.practice.instance.advanced.c20.service;

import java.util.List;

import lombok.RequiredArgsConstructor;
import ruly.lecture.ooka.practice.instance.advanced.c20.dto.EmployeeDTO;
import ruly.lecture.ooka.practice.instance.advanced.c20.dto.WorkRecordDTO;
import ruly.lecture.ooka.practice.instance.advanced.c20.logic.SalaryLogic;

@RequiredArgsConstructor
public class AttendanceService {

	private final SalaryLogic logic;

	public int calculateMonthlySalary(EmployeeDTO employee, List<WorkRecordDTO> records) {
		// TODO: 集計ロジックの実装
		return 0;
	}
}