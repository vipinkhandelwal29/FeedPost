package com.example.feed.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.feed.bean.Comment
import com.example.feed.databinding.CommentItemCellBinding

class CommentAdapter(
    private val commentList: ArrayList<Comment>
) :
    RecyclerView.Adapter<CommentAdapter.CommentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        return CommentViewHolder(
            CommentItemCellBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        holder.itemCell.comment = this.commentList[position]

    }

    override fun getItemCount() = commentList.size

    class CommentViewHolder(val itemCell: CommentItemCellBinding) :
        RecyclerView.ViewHolder(itemCell.root)

}