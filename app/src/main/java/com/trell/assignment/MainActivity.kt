package com.assignment.trell.views

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.trell.assignment.R
import com.trell.assignment.adapters.VideoAdapter
import com.trell.assignment.databinding.ActivityMainBinding
import com.trell.assignment.viewmodels.VideoViewModel

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    private var mVideoViewModel: VideoViewModel? = null
    var adapter: VideoAdapter? = null
    var recyclerView: RecyclerView? = null
    private val TAG = "MainActivity"
    private val RECORD_REQUEST_CODE = 101

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setupObservers()
        setupRecyclerView()
        mVideoViewModel!!.videoList!!.observe(this, Observer { adapter!!.notifyDataSetChanged() })

    }

    private fun setupObservers(){
        mVideoViewModel = ViewModelProviders.of(this).get(VideoViewModel::class.java)
        mVideoViewModel!!.init()
    }

    private fun setupRecyclerView() {
        recyclerView = binding!!.rvMovieList
        recyclerView!!.setHasFixedSize(true)
        recyclerView!!.layoutManager = LinearLayoutManager(this)
        val snapHelper: SnapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView!!)
        adapter = VideoAdapter(mVideoViewModel!!.videoList!!.value)
        recyclerView!!.adapter = adapter
    }
}