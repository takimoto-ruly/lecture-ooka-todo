# 配送可否判定システム 仕様書

## 1. 登場クラス（DTO）の設計要件
*   **ParcelDTO（荷物）**
    *   `double weight`: 重量(kg)
    *   `String destinationCode`: 配送先コード（例: "TOK-01", "OSA-02"）
*   **TruckDTO（トラック）**
    *   `double maxPayload`: 最大積載重量(kg)
    *   `List<ParcelDTO> loadedParcels`: 現在積まれている荷物のリスト
*   **RouteRestrictionDTO（ルート制限）**
    *   `String areaCode`: エリアコード（例: "TOK", "OSA"）
    *   `boolean isHeavyVehicleAllowed`: 重量物通行の可否

## 2. ロジッククラス：DeliveryValidator
*   **メソッド**: `boolean canAddParcel(TruckDTO truck, ParcelDTO newParcel, RouteRestrictionDTO route)`
*   **判定ロジック**:
    1.  **ガード句**: 引数のいずれかが `null`、または `truck.loadedParcels` が `null` の場合は `false` を返す。
    2.  **積載制限**: （現在の積荷の合計重量 + 新しい荷物の重量）が `truck.maxPayload` を超える場合は `false`。
    3.  **ルート一致確認**: `newParcel.destinationCode` が `route.areaCode` で始まっているかを確認する。一致しない場合は `false`（ルート違い）。
    4.  **特殊車両制限**: `newParcel.weight` が **500.0kg を超える** 場合、`route.isHeavyVehicleAllowed` が `false` ならば `false` を返す。
    5.  **許可**: 上記をすべてクリアすれば `true`。