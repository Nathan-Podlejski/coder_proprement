package com.example.coder_proprement.ui.recyclerviewholder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coder_proprement.R

class ComicViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val nomComic: TextView
    val imageComic: ImageView

    init {
        nomComic = view.findViewById(R.id.nomComicItem)
        imageComic = view.findViewById(R.id.imageComicItem)
    }
}
