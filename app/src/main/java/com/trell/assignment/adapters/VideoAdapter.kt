package com.trell.assignment.adapters

import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.trell.assignment.adapters.VideoAdapter.MovieViewHolder
import com.trell.assignment.models.Video
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.trell.assignment.databinding.ItemMovieBinding


class VideoAdapter(private val videoList: List<Video?>?) : RecyclerView.Adapter<MovieViewHolder>() {
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
            binding.v = video
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
//            binding.root.setOnClickListener { view ->
//                val uri = videoList!![adapterPosition]!!.location
//                val intent = Intent(view.context, PlayerActivity::class.java)
//                intent.putExtra("VIDEO_URI", uri)
//                view.context.startActivity(intent)
//            }
//
//            mPlayer = SimpleExoPlayer.Builder(binding.itemVideoExoplayer.context, DefaultRenderersFactory(binding.itemVideoExoplayer.context)).build()
//
//            // attach the just created player to the view responsible for displaying the media (i.e. media controls, visual feedback)
//            binding.itemVideoExoplayer.player = mPlayer
//            mPlayer.playWhenReady = false
//
////             resume playback position
////            mPlayer!!.seekTo(currentWindow, playbackPosition)
//            val mediaSource = buildMediaSource(Uri.parse(videoList!![currentPos]!!.location))
//            mPlayer.prepare(mediaSource)



        }
    }

    companion object {
        private const val TAG = "VideoAdapter"
    }

}