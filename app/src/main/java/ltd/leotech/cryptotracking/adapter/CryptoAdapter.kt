package ltd.leotech.cryptotracking.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.crypto_layout.view.*
import ltd.leotech.cryptotracking.R
import ltd.leotech.cryptotracking.model.CryptoModel
import ltd.leotech.cryptotracking.utils.Constants

/**
 * Created by CharlesAE on 2/25/18.
 */
class CryptoAdapter(val cryptoCoins: List<CryptoModel>): RecyclerView.Adapter<CryptoViewHolder>() {

    /**
     * Adapter takes in list of model objects
     */



    override fun getItemCount(): Int {

        /**
         *  lets the Adapter know how many items to display
         */
        return cryptoCoins.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CryptoViewHolder {

        val view = LayoutInflater.from(parent?.context).inflate(R.layout.crypto_layout, parent,  false)
        return CryptoViewHolder(view)

    }


    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: CryptoViewHolder?, position: Int) {


        /**
         *  coin - A single CryptoModel object from list
         */

        val coin = cryptoCoins.get(position)

        /**
         * get CryptoModel data and bind them to corresponding
         * viewholder widgets(text view, imageview etc)
         */

        holder?.coinName?.text = coin.name
        holder?.coinSymbol?.text = coin.symbol
        holder?.coinPrice?.text = coin.price_usd
        holder?.oneHourChange?.text = coin.percent_change_1h+"%"
        holder?.twentyFourHourChange?.text = coin.percent_change_24h+"%"
        holder?.sevenDayChange?.text = coin.percent_change_7d+"%"

        /**
         *  Picasso for async image loading
         */

        Picasso.with(holder?.itemView?.context).load(Constants.imageUrl.imageUrl+coin.symbol.toLowerCase()+".png").into(holder?.coinIcon)


        /**
         *  Set color of percentage change textview to reflect
         *  if the percentage change was negative or positive
         */
        if(coin.percent_change_1h.contains("-")){
            holder?.oneHourChange?.setTextColor(Color.parseColor("#ff0000"))
        }
        else{
            holder?.oneHourChange?.setTextColor(Color.parseColor("#32CD32"))
        }

        if(coin.percent_change_24h.contains("-")){
            holder?.twentyFourHourChange?.setTextColor(Color.parseColor("#ff0000"))
        }
        else{
            holder?.twentyFourHourChange?.setTextColor(Color.parseColor("#32CD32"))
        }

        if(coin.percent_change_7d.contains("-")){
            holder?.sevenDayChange?.setTextColor(Color.parseColor("#ff0000"))
        }
        else{
            holder?.sevenDayChange?.setTextColor(Color.parseColor("#32CD32"))
        }
    }

}


class CryptoViewHolder(v: View): RecyclerView.ViewHolder(v) {

    /**
     * ViewHolder items (textviews, imageviews) from the crypto_layout.xml
     */
    var coinName = v.coin_name
    var coinSymbol = v.coin_symbol
    var coinPrice = v.price_usd_text
    val oneHourChange = v.percent_change_1h_text
    var twentyFourHourChange = v.percent_change_24h_text
    var sevenDayChange = v.percent_change_7day_text
    var coinIcon = v.coin_icon

}