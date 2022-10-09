package net.konohana.sakuya.arrow.sample02.constant

/**
 * エラーコード定数クラス
 * @author lafleurblanche
 */
class ErrorCodeConst {
    companion object {
        /** エラーコード: コート形式誤り */
        const val ERROR_101 = "乗車駅コード形式ではありません。"
        /** エラーコード: 数字指定なし */
        const val ERROR_102 = "数字が含まれていません。"
    }
}
