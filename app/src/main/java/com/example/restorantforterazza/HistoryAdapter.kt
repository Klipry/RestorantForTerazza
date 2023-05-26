package com.example.restorantforterazza

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView


class HistoryAdapter:RecyclerView.Adapter<HistoryAdapter.UserViewHolder> (){

    private var HistoryList= emptyList<HistoryModel>()

    class UserViewHolder(view:View):RecyclerView.ViewHolder(view)

    fun setList(list: List<HistoryModel>){
        HistoryList=list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_history_layout,parent,
            false)
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int {
        return HistoryList.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {

        holder.itemView.findViewById<TextView>(R.id.TextHistory).text = HistoryList[position].info

    }
}
