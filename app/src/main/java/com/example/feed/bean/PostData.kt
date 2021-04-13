package com.example.feed.bean

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Comment(val message:String = "",val from: String = "") : Parcelable
@Parcelize
data class PostData(val image: Int = 0, val name: String = "", val comments: ArrayList<Comment> = ArrayList(0)) : Parcelable{
    val getTotalComments: String
    get() {
        return this.comments.size.toString()
    }
}