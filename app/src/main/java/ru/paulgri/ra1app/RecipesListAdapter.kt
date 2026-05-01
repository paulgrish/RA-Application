package ru.paulgri.ra1app

import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.paulgri.ra1app.databinding.ItemCardBinding.bind

class RecipesListAdapter(private val dataSet: List<Recipe>) :
    RecyclerView.Adapter<RecipesListAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val binding = bind(itemView)
        val ivImage = binding.ivCardImage
        val tvTitle = binding.tvCardTitle
        val tvDescription = binding.tvCardDescription
    }

    interface OnItemClickListener {
        fun onItemClick(recipeId: Int)
    }

    var itemClickListener: OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener) {
        itemClickListener = listener
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_card, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.tvTitle.text = dataSet[position].title
        viewHolder.tvDescription.text = null
        viewHolder.ivImage.setImageDrawable(
            try {
                Drawable.createFromStream(
                    viewHolder.itemView.context.assets.open(dataSet[position].imageUrl),
                    null
                )
            } catch (e: Exception) {
                Log.e("RecipesListAdapter", e.stackTrace.toString())
                null
            }
        )
        viewHolder.itemView.setOnClickListener {
            itemClickListener?.onItemClick(dataSet[position].id)
        }
    }

    override fun getItemCount() = dataSet.size
}