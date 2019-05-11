package com.netflairs.sasmirapp

import android.os.Bundle
import android.R
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import android.view.View
import com.netflairs.sasmirapp.adapter.TaskListAdapter
import kotlinx.android.synthetic.main.activity_task_list.*


class TaskListActivity : BaseActivity(){
    private lateinit var linearLayoutManager: LinearLayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.netflairs.sasmirapp.R.layout.activity_task_list)
        ivBack.setOnClickListener(View.OnClickListener {
            onBackPressed()
        })


        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter=TaskListAdapter(this)
    }


}
