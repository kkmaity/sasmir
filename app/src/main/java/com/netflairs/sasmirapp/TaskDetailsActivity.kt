package com.netflairs.sasmirapp

import android.os.Bundle
import android.R
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import android.view.View
import com.netflairs.sasmirapp.adapter.TaskListAdapter
import kotlinx.android.synthetic.main.activity_task_list.*


class TaskDetailsActivity : BaseActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.netflairs.sasmirapp.R.layout.activity_task_details)

        ivBack.setOnClickListener(View.OnClickListener {
            onBackPressed()
        })


    }

}
