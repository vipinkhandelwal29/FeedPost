package com.example.feed.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.feed.bean.PostData
import com.example.feed.databinding.PostItemCellBinding

class PostAdapter(
    private val postList: ArrayList<PostData>,
    internal val callBackIntent: (position: Int) -> Unit
) :
    RecyclerView.Adapter<PostAdapter.PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        return PostViewHolder(
            PostItemCellBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.itemCell.postData = this .postList[position]

        Glide.with(holder.itemCell.ivUserImage).load(postList[position].image)
            .circleCrop().into(holder.itemCell.ivUserImage)

        Glide.with(holder.itemCell.ivUserImageTwo).load(postList[position].image)
            .into(holder.itemCell.ivUserImageTwo)

        holder.itemCell.root.setOnClickListener {
            callBackIntent(holder.adapterPosition)
        }
    }

    override fun getItemCount() = postList.size

    class PostViewHolder(val itemCell: PostItemCellBinding) :
        RecyclerView.ViewHolder(itemCell.root)

}