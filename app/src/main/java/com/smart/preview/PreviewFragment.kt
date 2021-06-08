package com.smart.preview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import com.smart.preview.databinding.FragmentPreviewBinding

class PreviewFragment : Fragment() {

    private var binding: FragmentPreviewBinding? = null
    private var player: Player? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPreviewBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = binding ?: return
        val isImage = arguments?.getBoolean("isImage") ?: false
        val uri = arguments?.getString("uri") ?: return
        binding.playerView.isVisible = !isImage
        binding.image.isVisible = isImage
        if (isImage) {
            Glide.with(this).load(uri).into(binding.image)
        } else {
            player = SimpleExoPlayer.Builder(requireContext()).build()
            binding.playerView.player = player
            val mediaItem = MediaItem.fromUri(uri)
            player?.apply {
                setMediaItem(mediaItem)
                prepare()
            }
        }
    }


    override fun onPause() {
        super.onPause()
        if (player?.isPlaying == true) {
            player?.pause()
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        player?.release()
    }



    companion object {
        fun newInstance(isImage: Boolean, uri: String?): PreviewFragment {
            return PreviewFragment().apply {
                arguments = Bundle().also {
                    it.putString("uri", uri)
                    it.putBoolean("isImage", isImage)
                }
            }
        }
    }
}