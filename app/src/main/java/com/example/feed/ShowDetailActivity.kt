package com.example.feed

import android.content.Intent
import android.view.MenuItem
import com.example.feed.bean.PostData
import com.example.feed.databinding.ShowDetailBinding

class ShowDetailActivity : BaseActivity<ShowDetailBinding>() {

    override fun getLayoutId() = R.layout.show_detail
    private lateinit var postBean: PostData


    override fun initControl() {
        setSupportActionBar(binding.iToolbar.toolbar)
        title = "User Details"

        postBean = intent.getParcelableExtra("name")!!
        binding.postData = postBean



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