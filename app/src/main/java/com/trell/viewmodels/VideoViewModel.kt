package com.trell.viewmodels

import android.app.Application
import android.content.Context
import android.provider.MediaStore
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.trell.models.Video
import java.util.*

class VideoViewModel(application: Application) : AndroidViewModel(application) {
    var videoList: MutableLiveData<List<Video?>>? = null
        private set

    fun init() {
        if (videoList != null) {
            return
        }
    }


}