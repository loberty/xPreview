package com.smart.preview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.smart.preview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setSupportActionBar(binding.toolbar)

        binding.viewPager.adapter = PreviewFragmentAdapter(this, mockData())
    }



    class PreviewFragmentAdapter(activity: FragmentActivity, val data: MutableList<MediaEntry>) :
        FragmentStateAdapter(activity) {
        override fun getItemCount() = data.size

        override fun createFragment(position: Int) =
            PreviewFragment.newInstance(data[position].isImage, data[position].uri)
    }


    private fun mockData(): MutableList<MediaEntry> = mutableListOf<MediaEntry>().apply {
        add(
            MediaEntry(
                "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2954337718,1649681218&fm=26&gp=0.jpg",
                null
            )
        )
        add(
            MediaEntry(
                "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fqqpublic.qpic.cn%2Fqq_public%2F0%2F0-519532956-12999B5642F6C91F8E16337305B661BE%2F0%3Ffmt%3Djpg%26size%3D63%26h%3D690%26w%3D690%26ppv%3D1&refer=http%3A%2F%2Fqqpublic.qpic.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1616726286&t=ea98e83724d902e79b1994bfc5ecd77c",
                null
            )
        )
        add(MediaEntry(null, "https://cdn.videvo.net/videvo_files/video/free/2014-06/small_watermarked/Blue_Sky_and_Clouds_Timelapse_0892__Videvo_preview.webm"))
        add(
            MediaEntry(
                "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2954337718,1649681218&fm=26&gp=0.jpg",
                null
            )
        )
        add(
            MediaEntry(
                "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fqqpublic.qpic.cn%2Fqq_public%2F0%2F0-519532956-12999B5642F6C91F8E16337305B661BE%2F0%3Ffmt%3Djpg%26size%3D63%26h%3D690%26w%3D690%26ppv%3D1&refer=http%3A%2F%2Fqqpublic.qpic.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1616726286&t=ea98e83724d902e79b1994bfc5ecd77c",
                null
            )
        )
        add(MediaEntry(null, "https://cdn.videvo.net/videvo_files/video/free/2014-06/small_watermarked/Blue_Sky_and_Clouds_Timelapse_0892__Videvo_preview.webm"))
        add(
            MediaEntry(
                "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2954337718,1649681218&fm=26&gp=0.jpg",
                null
            )
        )
        add(
            MediaEntry(
                "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fqqpublic.qpic.cn%2Fqq_public%2F0%2F0-519532956-12999B5642F6C91F8E16337305B661BE%2F0%3Ffmt%3Djpg%26size%3D63%26h%3D690%26w%3D690%26ppv%3D1&refer=http%3A%2F%2Fqqpublic.qpic.cn&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=jpeg?sec=1616726286&t=ea98e83724d902e79b1994bfc5ecd77c",
                null
            )
        )
        add(MediaEntry(null, "https://cdn.videvo.net/videvo_files/video/free/2014-06/small_watermarked/Blue_Sky_and_Clouds_Timelapse_0892__Videvo_preview.webm"))
    }
}