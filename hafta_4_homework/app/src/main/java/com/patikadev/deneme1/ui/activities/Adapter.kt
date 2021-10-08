package com.patikadev.deneme1.ui.activities

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import com.patikadev.deneme1.R

class Adapter( val tasks: List<Task>) : RecyclerView.Adapter<Adapter.İtemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): İtemHolder {
        return İtemHolder(LayoutInflater.from(parent.context).inflate(R.layout.row_word, parent, false)
        )
    }
    override fun onBindViewHolder(holder: İtemHolder, position: Int) {
        val task = this.tasks[position]
        holder.bind(task)

    }
    override fun getItemCount(): Int = this.tasks.size

    inner class İtemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val taskk = itemView.findViewById<AppCompatTextView>(R.id.task)

        fun bind(task: Task) {
            taskk.text = task.description
        }
    }
}