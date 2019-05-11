package com.netflairs.sasmirapp.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.netflairs.sasmirapp.R
import com.netflairs.sasmirapp.TaskDetailsActivity
import kotlinx.android.synthetic.main.row_task_list.view.*

class TaskListAdapter(val context: Context) : RecyclerView.Adapter<ViewHolder>() {

    // Gets the number of animals in the list
    override fun getItemCount(): Int {
        return 10
    }

    // Inflates the item views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.row_task_list, parent, false))
    }

    // Binds each animal in the ArrayList to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       // holder?.tvAnimalType?.text = items.get(position)
       holder?.tvDetails?.setOnClickListener(View.OnClickListener {
           val showPhotoIntent = Intent(context, TaskDetailsActivity::class.java)
           context.startActivity(showPhotoIntent)
       })
    }
}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    // Holds the TextView that will add each animal to
    val card_main = view.card_main
    val tvDetails = view.tvDetails
}