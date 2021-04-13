package com.example.feed

import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.feed.adapter.CommentAdapter
import com.example.feed.bean.PostData
import com.example.feed.databinding.ShowDetailBinding

class ShowDetailActivity : BaseActivity<ShowDetailBinding>() {

    override fun getLayoutId() = R.layout.show_detail
    private lateinit var postBean: PostData
    private var adapter: CommentAdapter? = CommentAdapter()


    override fun initControl() {

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        setSupportActionBar(binding.iToolbar.toolbar)
        title = "User Details"

        if (intent.hasExtra("post")) {
            val post = intent.getParcelableExtra<PostData>("post") ?: PostData()
            post.apply { binding.postData = PostData(image, name, comments) }
            val imageDrawable = resources.getDrawable(post.image,resources.newTheme())
            binding.ivImage.setImageDrawable(imageDrawable)
            adapter?.setComments(post.comments)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        return if (id == android.R.id.home) {
            onBackPressed()
            true
        } else {
            super.onOptionsItemSelected(item)
        }
    }
}