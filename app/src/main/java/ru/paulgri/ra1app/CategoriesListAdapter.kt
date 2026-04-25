package ru.paulgri.ra1app

import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.paulgri.ra1app.databinding.ItemCategoryBinding.bind

class CategoriesListAdapter(private val dataSet: List<Category>) :
    RecyclerView.Adapter<CategoriesListAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val binding = bind(itemView)
        val ivImage = binding.ivCardImage
        val tvTitle = binding.tvCardTitle
        val tvDescription = binding.tvCardDescription
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_category, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.tvTitle.text = dataSet[position].title
        viewHolder.tvDescription.text = dataSet[position].description
        viewHolder.ivImage.setImageDrawable(
            try {
                Drawable.createFromStream(
                    viewHolder.itemView.context.assets.open(dataSet[position].imageUrl),
                    null
                )
            } catch (e: Exception) {
                Log.e("CategoryListAdapter", e.stackTrace.toString())
                null
            }
        )
    }

    override fun getItemCount() = dataSet.size
}