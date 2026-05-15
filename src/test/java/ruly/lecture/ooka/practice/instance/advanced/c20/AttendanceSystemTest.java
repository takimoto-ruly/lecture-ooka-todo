package ruly.lecture.ooka.practice.instance.advanced.c20;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ruly.lecture.ooka.practice.instance.advanced.c20.controller.AttendanceController;
import ruly.lecture.ooka.practice.instance.advanced.c20.dto.AttendanceRequest;
import ruly.lecture.ooka.practice.instance.advanced.c20.dto.EmployeeDTO;
import ruly.lecture.ooka.practice.instance.advanced.c20.dto.WorkRecordDTO;
import ruly.lecture.ooka.practice.instance.advanced.c20.logic.SalaryLogic;
import ruly.lecture.ooka.practice.instance.advanced.c20.service.AttendanceService;

public class AttendanceSystemTest {
	private AttendanceController controller;
	private SalaryLogic logic;

	@BeforeEach
	void setUp() {
		// コンストラクタインジェクションによる組み立て
		logic = new SalaryLogic();
		AttendanceService service = new AttendanceService(logic);
		controller = new AttendanceController(service);
	}

	// --- 同値クラス・境界値テスト (Service & Logic 統合) ---

	@Test
	@DisplayName("正常系：一般社員(STANDARD)の平日残業と休日出勤の合算")
	void testStandardEmployeeCombined() {
		EmployeeDTO emp = new EmployeeDTO("E01", 1000, "STANDARD");
		// 平日10h: (8h * 1.0) + (2h * 1.25) = 10.5h相当 = 10500円
		WorkRecordDTO weekday = new WorkRecordDTO(10.0, false);
		// 休日2h: (2h * 1.35) = 2.7h相当 = 2700円
		WorkRecordDTO holiday = new WorkRecordDTO(2.0, true);

		AttendanceRequest req = new AttendanceRequest(emp, Arrays.asList(weekday, holiday));
		assertEquals("Total: 13200 JPY", controller.processAttendance(req));
	}

	@Test
	@DisplayName("正常系：マネージャー(MANAGER)は平日10h働いても残業代がつかない")
	void testManagerWeekday() {
		EmployeeDTO emp = new EmployeeDTO("M01", 1000, "MANAGER");
		// マネージャーは平日なら10h * 1.0 = 10000円
		WorkRecordDTO weekday = new WorkRecordDTO(10.0, false);

		AttendanceRequest req = new AttendanceRequest(emp, Collections.singletonList(weekday));
		assertEquals("Total: 10000 JPY", controller.processAttendance(req));
	}

	@Test
	@DisplayName("正常系：マネージャーでも休日出勤手当はつく")
	void testManagerHoliday() {
		EmployeeDTO emp = new EmployeeDTO("M01", 1000, "MANAGER");
		// 休日2h: (2h * 1.35) = 2700円
		WorkRecordDTO holiday = new WorkRecordDTO(2.0, true);

		AttendanceRequest req = new AttendanceRequest(emp, Collections.singletonList(holiday));
		assertEquals("Total: 2700 JPY", controller.processAttendance(req));
	}

	@Test
	@DisplayName("境界値：残業時間の境界線（8.0時間）")
	void testOvertimeBoundary() {
		EmployeeDTO emp = new EmployeeDTO("E01", 1000, "STANDARD");
		// 8.0h -> 8000円
		assertEquals("Total: 8000 JPY", controller.processAttendance(
				new AttendanceRequest(emp, Collections.singletonList(new WorkRecordDTO(8.0, false)))));
		// 8.1h -> (8000 + 0.1*1000*1.25) = 8125円
		assertEquals("Total: 8125 JPY", controller.processAttendance(
				new AttendanceRequest(emp, Collections.singletonList(new WorkRecordDTO(8.1, false)))));
	}

	@Test
	@DisplayName("境界値：給与合計1,000,000円の制限")
	void testSalaryLimitBoundary() {
		EmployeeDTO emp = new EmployeeDTO("E99", 100000, "STANDARD");
		// 10時間(平日) = 100,000 * (8 + 2*1.25) = 1,050,000 -> 超過
		AttendanceRequest overReq = new AttendanceRequest(emp,
				Collections.singletonList(new WorkRecordDTO(10.0, false)));
		assertEquals("Alert: Check Manual", controller.processAttendance(overReq));

		// 8時間(平日) = 100,000 * 8 = 800,000 -> 許容内
		AttendanceRequest safeReq = new AttendanceRequest(emp,
				Collections.singletonList(new WorkRecordDTO(8.0, false)));
		assertEquals("Total: 800000 JPY", controller.processAttendance(safeReq));
	}

	@Test
	@DisplayName("Logic単体：四捨五入の精度テスト")
	void testRoundingPrecision() {
		// 1005円 * 1.25倍 = 1256.25 -> 1256
		assertEquals(1256, logic.calculate(1005, 1.0, 1.25));
		// 1006円 * 1.25倍 = 1257.5 -> 1258
		assertEquals(1258, logic.calculate(1006, 1.0, 1.25));
	}

	// --- 異常系テスト ---

	@Test
	@DisplayName("異常系：nullリクエストや空リスト")
	void testAbnormalInputs() {
		// リクエスト自体がnull
		assertEquals("Error: No Data", controller.processAttendance(null));

		// リストが空
		AttendanceRequest emptyReq = new AttendanceRequest(new EmployeeDTO("A", 1000, "S"), Collections.emptyList());
		assertEquals("Error: No Data", controller.processAttendance(emptyReq));

		// リストがnull
		AttendanceRequest nullListReq = new AttendanceRequest(new EmployeeDTO("A", 1000, "S"), null);
		assertEquals("Error: No Data", controller.processAttendance(nullListReq));
	}
}
