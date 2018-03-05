package ltd.leotech.cryptotracking.model

/**
 * Created by CharlesAE on 2/25/18.
 */
data class CryptoModel(
    val id: String,
    val name: String,
    val symbol: String,
    val price_usd: String,
    val percent_change_1h: String,
    val percent_change_24h: String,
    val percent_change_7d: String
)
