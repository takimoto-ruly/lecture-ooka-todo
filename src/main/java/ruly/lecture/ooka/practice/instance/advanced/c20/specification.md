# 勤怠管理システム 仕様書

## 1. 概要
社員の月間勤務記録から、役職に応じた計算ルールを適用して最終的な支払額を算出する。
本システムは「Controller（制御）」「Service（業務フロー）」「Logic（計算）」の三層で構成し、
Lombokおよびコンストラクタインジェクションを利用したテスタブルな設計とする。

## 2. 登場エンティティ（Lombok @Value で定義）
- **EmployeeDTO**: `id` (String), `hourlyRate` (int), `role` (String: "STANDARD" or "MANAGER")
- **WorkRecordDTO**: `hours` (double), `isHoliday` (boolean)
- **AttendanceRequest**: `employee` (EmployeeDTO), `records` (List<WorkRecordDTO>)

## 3. 各層の責務と仕様

### ① SalaryLogic (計算ロジック層)
- **責務**: 与えられた時給・時間・係数を掛け合わせ、端数処理を行う。
- **仕様**: 
    - 計算式：`時給 * 時間 * 係数`
    - 端数処理：1円単位で四捨五入（`Math.round`）を行う。

### ② AttendanceService (業務サービス層)
- **責務**: 社員の役職や日毎のフラグに基づき、ビジネスルールを適用して1ヶ月分を集計する。
- **依存**: `SalaryLogic` をコンストラクタインジェクションで受け取る。
- **仕様**:
    - **休日出勤**: 役職に関わらず、すべての労働時間に対して **係数 1.35** を適用。
    - **平日出勤（STANDARD）**: 8時間までは係数 1.0、8時間を超えた分（残業）は **係数 1.25** を適用。
    - **平日出勤（MANAGER）**: 何時間働いても残業代は発生せず、すべて **係数 1.0** で計算。

### ③ AttendanceController (実行制御層)
- **責務**: 入力値のバリデーション、サービス層の呼び出し、結果のフォーマット、異常値アラートを行う。
- **依存**: `AttendanceService` をコンストラクタインジェクションで受け取る。
- **仕様**:
    - **バリデーション**: リクエストが `null`、または `records` が `null`/空の場合は `"Error: No Data"` を返す。
    - **金額チェック**: 合計金額が **1,000,000円 を超える** 場合は、結果を返さず `"Alert: Check Manual"` を返す。
    - **正常出力**: それ以外の場合は `"Total: [金額] JPY"` の形式で返す。