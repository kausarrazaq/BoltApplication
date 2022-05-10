package com.example.boltapplication.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.boltapplication.R
import com.example.boltapplication.Models.TripsModel

class TripsAdapter(private val mList: List<TripsModel>): RecyclerView.Adapter<TripsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.tripslayout, parent, false)

        return ViewHolder(view)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val itemsViewModel = mList[position]
        holder.nameTextView.text=itemsViewModel.nameTextview
        holder.dateTextview.text=itemsViewModel.dateTextview
        holder.timeTextview.text=itemsViewModel.timeTextView
        holder.finishTextview.text=itemsViewModel.finishTextview
//        holder.cancelTextview.text= itemsViewModel.cancelTextview

    }
    override fun getItemCount(): Int {
        return mList.size
    }
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        var nameTextView: TextView = itemView.findViewById(R.id.name)
        var dateTextview: TextView = itemView.findViewById(R.id.date)
        var timeTextview: TextView = itemView.findViewById(R.id.time)
        var finishTextview: TextView = itemView.findViewById(R.id.finish)
//        var cancelTextview :TextView= itemView.findViewById(R.id.cancel)
    }
}