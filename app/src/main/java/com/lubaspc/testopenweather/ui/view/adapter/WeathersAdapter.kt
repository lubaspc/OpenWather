package com.lubaspc.testopenweather.ui.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lubaspc.domain.model.Test
import com.lubaspc.testopenweather.R
import com.lubaspc.testopenweather.databinding.ItemRequestBinding

class WeathersAdapter (
    var weathers: List<Test>,
    val click: (Test) -> Unit
): RecyclerView.Adapter<WeathersAdapter.ViewHolder>(){
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var vBind = ItemRequestBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
            = ViewHolder(
            LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_request,parent,false))


    override fun getItemCount() = weathers.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.vBind.test = weathers[position]
        holder.vBind.cvWeather.setOnClickListener { click(weathers[position]) }
    }
}