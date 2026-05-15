package ruly.lecture.ooka.practice.instance.advanced.c20.service;

import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import ruly.lecture.ooka.practice.instance.advanced.c20.dto.EmployeeDTO;
import ruly.lecture.ooka.practice.instance.advanced.c20.dto.WorkRecordDTO;
import ruly.lecture.ooka.practice.instance.advanced.c20.logic.SalaryLogic;

@RequiredArgsConstructor
@Getter
public class AttendanceService {

	private final SalaryLogic logic;
	private int totalAmount;

	public int calculateDairyPay(EmployeeDTO employee, WorkRecordDTO record) {
		int rate = employee.getHourlyRate();
		double hours = record.getHours();
		int dairyPay = 0;
		//休日出勤
		if (record.isHoliday()) {
			dairyPay = logic.calculate(rate, hours, 1.35);
		}
		//平日出勤(MANAGER)
		if ("MANAGER".equals(employee.getRole())) {
			dairyPay = logic.calculate(rate, hours, 1.0);
		}
		//平日出勤(STANDARD)
		if ("STANDARD".equals(employee.getRole())) {
			double regularHours = Math.min(hours, 8.0);
			double overHours = Math.max(0, hours - 8.0);
			dairyPay = logic.calculate(rate, regularHours, 1.0) + logic.calculate(rate, overHours, 1.25);
		}

		return dairyPay;
	}

	public int calculateMonthlySalary(EmployeeDTO employee, List<WorkRecordDTO> records) {
		this.totalAmount = records.stream()
				.mapToInt(x -> calculateDairyPay(employee, x))
				.sum();

		return totalAmount;
	}
}