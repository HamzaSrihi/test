package com.srihi.testbankin.ui.parentList

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.srihi.domain.model.Category
import com.srihi.testbankin.R

class ParentListAdapter(context: Context) :
    RecyclerView.Adapter<ParentListViewHolder>() {

    private val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    var onItemClickListener: OnItemClickListener? = null

    var categories: List<Category> = ArrayList()


    override fun getItemCount(): Int = categories.size

    override fun onBindViewHolder(holder: ParentListViewHolder, position: Int) {
        holder.bind(getCategory(position))
    }


    private fun getCategory(position: Int): Category = categories[position]

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParentListViewHolder {
        val holder = ParentListViewHolder(inflater.inflate(R.layout.item_list, parent, false))
        holder.itemView.setOnClickListener {
            onItemClickListener?.onItemClick(getCategory(holder.adapterPosition))
        }
        return holder
    }

    interface OnItemClickListener {
        fun onItemClick(category: Category)
    }

}

class ParentListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val titleTextViex = itemView.findViewById<TextView>(R.id.title)
    private val imageView = itemView.findViewById<ImageView>(R.id.album_image)
    var url: String? = null

    fun bind(category: Category) {
        titleTextViex.text = category.name
        //imageView.load(album.thumbnailUrl)

    }
}


