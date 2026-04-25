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

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_category, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        try {
            viewHolder.tvTitle.text = dataSet[position].title
            viewHolder.tvDescription.text = dataSet[position].description
            viewHolder.ivImage.setImageDrawable(
                Drawable.createFromStream(
                    viewHolder.itemView.context.assets.open(dataSet[position].imageUrl),
                    null
                )
            )
        } catch (e: Exception) {
            Log.println(Log.ERROR, "CategoryListAdapter", e.stackTrace.toString())
        }
    }

    override fun getItemCount() = dataSet.size
}