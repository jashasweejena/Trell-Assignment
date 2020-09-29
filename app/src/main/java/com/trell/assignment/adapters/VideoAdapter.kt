package com.trell.assignment.adapters

import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.google.android.exoplayer2.DefaultRenderersFactory
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.trell.assignment.databinding.ItemMovieBinding
import com.trell.assignment.models.Video


class VideoAdapter(private val videoList: List<Video?>?) : RecyclerView.Adapter<VideoAdapter.MovieViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemBinding = ItemMovieBinding.inflate(inflater, parent, false)
        return MovieViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val video = videoList!![position]
        Log.d(TAG, "onBindViewHolder: " + position);
        holder.bind(video)
        holder.binding.itemVideoExoplayer.tag = position;
    }

    override fun getItemCount(): Int {
        return videoList?.size ?: 0
    }

    inner class MovieViewHolder(val binding: ItemMovieBinding) : ViewHolder(binding.root) {
        lateinit var mPlayer: SimpleExoPlayer
         var currentPos: Int = 0
        fun bind(video: Video?) {
            binding.video = video
            binding.index = adapterPosition;
            binding.executePendingBindings()
        }

        private fun buildMediaSource(uri: Uri): MediaSource {
            val dataSourceFactory: DataSource.Factory = DefaultDataSourceFactory(binding.itemVideoExoplayer.context, "ua")
            val extractorSourceFactory = DefaultExtractorsFactory()

            // Create a progressive media source pointing to a stream uri.
            return ProgressiveMediaSource.Factory(dataSourceFactory, extractorSourceFactory).createMediaSource(uri)
        }

       private fun initializePlayer() {
            // create a new instance of SimpleExoPlayer

        }
        init {

        }
    }

    companion object {
        private const val TAG = "VideoAdapter"
    }

}