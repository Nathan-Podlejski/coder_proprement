package com.example.coder_proprement.ui.recyclerviewadapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.coder_proprement.R
import com.example.coder_proprement.ui.recyclerviewholder.ComicViewHolder
import fr.iem.model.Comic

class RecyclerViewComicAdapter(private val context: Context, private val dataSet: MutableList<Comic>, private var onItemClicked: ((comic: Comic) -> Unit)) :
    RecyclerView.Adapter<ComicViewHolder>() {


    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ComicViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.list_comic_item, viewGroup, false)

        return ComicViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ComicViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.nomComic.text = dataSet[position].title

        viewHolder.itemView.setOnClickListener {
            onItemClicked(dataSet[position])
        }

        viewHolder.imageComic.load(dataSet[position].thumbnail!!.path!! + "." + dataSet[position].thumbnail!!.extension!!)

        /*CoroutineScope(Dispatchers.IO).launch {
            var bmp = GetImageUseCase().invoke(dataSet[position].id!!)
            Handler(Looper.getMainLooper()).post(Runnable { viewHolder.imageComic.setImageBitmap(bmp) })
        }*/
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

    public fun updateItems(newItems: List<Comic>){
        this.dataSet.clear()
        this.dataSet.addAll(newItems)
    }

}
