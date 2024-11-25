package com.example.androidtestroom

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(
    private val users: MutableList<User>,
) : RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>() {
    class RecyclerViewHolder(
        itemView: View,
    ) : RecyclerView.ViewHolder(itemView) {
        val firstName = itemView.findViewById<TextView>(R.id.firstName)
        val lastName = itemView.findViewById<TextView>(R.id.lastName)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): RecyclerViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycle_item, parent, false)
        return RecyclerViewHolder(itemView)
    }

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val user = users[position]
        holder.firstName.text = user.firstName
        holder.lastName.text = user.lastName
    }
}