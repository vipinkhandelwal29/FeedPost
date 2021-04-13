package com.example.feed

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.feed.adapter.PostAdapter
import com.example.feed.bean.PostData
import com.example.feed.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun getLayoutId() = R.layout.activity_main
    private val dataList = ArrayList<PostData>()
    private var adapter: PostAdapter? = null

    override fun initControl() {
        dataList.add(PostData(R.drawable.vipin1, "Vipin"))
        dataList.add(PostData(R.drawable.aryan, "Vikram"))
        dataList.add(PostData(R.drawable.kartik, "Shubham"))
        dataList.add(PostData(R.drawable.anshuman, "Karan"))
        dataList.add(PostData(R.drawable.punit, "Punit"))

        val image= binding.root.toString()
        Log.d("==>", "$image ")

        adapter = PostAdapter(dataList,
        callBackIntent = {
            val intent = Intent(this, ShowDetailActivity::class.java)
            intent.putExtra("name",image)
            startActivity(intent)
        })
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter =adapter

        setSupportActionBar(binding.iToolBar.toolbar)
        title = "Feed"
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