# 複数試験の結果判定（進級判定） 仕様書

## 1. 登場クラス（DTO）の設計要件
*   **ExamScoreDTO（試験結果）**
    *   `String subjectName`: 科目名
    *   `int score`: 点数（0〜100）
*   **StudentReportDTO（成績表）**
    *   `String studentId`: 学生ID
    *   `List<ExamScoreDTO> scores`: 受験した全科目のリスト
*   **SchoolYearSettingsDTO（進級基準）**
    *   `int passingScore`: 合格基準点（例: 60）
    *   `int maxFailedAllowed`: 許容される不合格科目の最大数

## 2. ロジッククラス：PromotionService
*   **メソッド**: `boolean isEligibleForPromotion(StudentReportDTO report, SchoolYearSettingsDTO settings)`
*   **判定ロジック**:
    1.  **ガード句**: 引数のいずれか、または `report.scores` が `null` の場合は `false`。
    2.  **未受験チェック**: `report.scores` が空リスト（要素数0）の場合は、試験未受験とみなし `false`。
    3.  **不合格集計**: `scores` 内の各科目を確認し、`score` が `settings.passingScore` **未満**の科目を「不合格科目」としてカウントする。
    4.  **進級可否**: 不合格科目の総数が `settings.maxFailedAllowed` を **超える** 場合は `false`。
    5.  **許可**: それ以外は `true`。