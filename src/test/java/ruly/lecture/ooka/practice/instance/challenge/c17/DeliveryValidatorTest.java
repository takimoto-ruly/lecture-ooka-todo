package ruly.lecture.ooka.practice.instance.challenge.c17;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DeliveryValidatorTest {
	private final DeliveryValidator validator = new DeliveryValidator();

	@Test
	@DisplayName("正常系：積載量・ルートともに問題なし")
	void testCanAdd_Success() {
		TruckDTO truck = new TruckDTO(1000.0, new ArrayList<>(Arrays.asList(new ParcelDTO(300.0, "OSA-01"))));
		ParcelDTO newParcel = new ParcelDTO(200.0, "TOK-01");
		RouteRestrictionDTO route = new RouteRestrictionDTO("TOK", true);

		assertTrue(validator.canAddParcel(truck, newParcel, route));
	}

	@Test
	@DisplayName("境界値：最大積載量ぴったり")
	void testCanAdd_WeightBoundary() {
		TruckDTO truck = new TruckDTO(500.0, new ArrayList<>(Arrays.asList(new ParcelDTO(300.0, "TOK-01"))));
		ParcelDTO newParcel = new ParcelDTO(200.0, "TOK-02");
		RouteRestrictionDTO route = new RouteRestrictionDTO("TOK", true);

		assertTrue(validator.canAddParcel(truck, newParcel, route), "合計500.0kgちょうどはOK");

		ParcelDTO overParcel = new ParcelDTO(200.1, "TNG-01");
		assertFalse(validator.canAddParcel(truck, overParcel, route), "500.1kgはNG");
	}

	@Test
	@DisplayName("同値クラス：重量物通行禁止ルートの判定")
	void testCanAdd_RouteRestriction() {
		RouteRestrictionDTO restrictedRoute = new RouteRestrictionDTO("TOK", false); // 重量物不可
		TruckDTO truck = new TruckDTO(2000.0, new ArrayList<>());

		// 500.0kg以下なら通行禁止ルートでもOK
		assertTrue(validator.canAddParcel(truck, new ParcelDTO(500.0, "TOK-01"), restrictedRoute));

		// 500.1kg以上で通行禁止ルートならNG
		assertFalse(validator.canAddParcel(truck, new ParcelDTO(500.1, "TOK-01"), restrictedRoute));
	}

	@Test
	@DisplayName("異常系：nullまたはルート不一致")
	void testCanAdd_Abnormal() {
		TruckDTO truck = new TruckDTO(1000.0, new ArrayList<>());
		ParcelDTO p = new ParcelDTO(100.0, "OSA-01");
		RouteRestrictionDTO r = new RouteRestrictionDTO("TOK", true);

		assertFalse(validator.canAddParcel(truck, p, r), "目的地コードがエリアコードと一致しない");
		assertFalse(validator.canAddParcel(null, p, r), "引数がnull");
	}
}