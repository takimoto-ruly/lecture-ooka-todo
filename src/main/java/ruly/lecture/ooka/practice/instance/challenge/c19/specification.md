# 複数銀行口座の統合決済審査 仕様書

## 1. 登場クラス（DTO）の設計要件
*   **BankAccountDTO（銀行口座）**
    *   `String bankName`: 銀行名
    *   `int balance`: 残高
    *   `boolean isFrozen`: 凍結状態（true の場合は引き出し不可）
*   **UserProfileDTO（ユーザー）**
    *   `List<BankAccountDTO> accounts`: 所有している全口座のリスト
    *   `boolean isBlacklisted`: ブラックリスト登録者かどうか
*   **PurchaseRequestDTO（購入リクエスト）**
    *   `int price`: 商品の価格

## 2. ロジッククラス：FinancialService
*   **メソッド**: `boolean canAfford(UserProfileDTO user, PurchaseRequestDTO request)`
*   **判定ロジック**:
    1.  **ガード句**: 引数が `null`、または `user.accounts` が `null` の場合は `false`。
    2.  **信用チェック**: `user.isBlacklisted` が `true` の場合は、残高に関わらず `false`。
    3.  **有効残高の集計**: `user.accounts` の中から、`isFrozen` が `false`（凍結されていない）口座の `balance` のみを合計する。
    4.  **決済可否**: 合計した有効残高が `request.price` **以上** であれば `true`、不足していれば `false`。