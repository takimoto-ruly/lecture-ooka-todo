package ruly.lecture.ooka.practice.instance.hige_level.c14;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TicketingServiceTest {
	private final TicketingService service = new TicketingService();

	@Test
	@DisplayName("正常系・同値クラス：全ての条件を満たす場合")
	void testCanIssue_Success() {
		PassportDTO p = new PassportDTO("AB123", false);
		PassengerDTO passenger = new PassengerDTO("TANAKA", p);
		TicketDTO ticket = new TicketDTO("TANAKA", "JL101");
		assertTrue(service.canIssue(passenger, ticket));
	}

	@Test
	@DisplayName("異常系：名前の不一致・パスポート期限切れ")
	void testCanIssue_FailConditions() {
		PassportDTO validP = new PassportDTO("AB123", false);
		PassportDTO expiredP = new PassportDTO("AB123", true);

		// 名前不一致
		assertFalse(service.canIssue(new PassengerDTO("SATO", validP), new TicketDTO("TANAKA", "JL101")));
		// パスポート期限切れ
		assertFalse(service.canIssue(new PassengerDTO("TANAKA", expiredP), new TicketDTO("TANAKA", "JL101")));
	}

	@Test
	@DisplayName("異常系・境界値：nullの階層チェック")
	void testCanIssue_NullCheck() {
		TicketDTO t = new TicketDTO("T", "J");
		// 引数がnull
		assertFalse(service.canIssue(null, t));
		// 中のインスタンスがnull
		assertFalse(service.canIssue(new PassengerDTO("T", null), t));
	}
}
