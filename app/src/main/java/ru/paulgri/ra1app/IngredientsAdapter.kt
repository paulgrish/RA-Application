package ru.paulgri.ra1app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.paulgri.ra1app.RecipesListAdapter.ViewHolder
import ru.paulgri.ra1app.databinding.ItemRecipeBinding.bind

class IngredientsAdapter(val dataset: List<Ingredient>) :
    RecyclerView.Adapter<IngredientsAdapter.ViewHolder() {

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        p1: Int
    ): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_recipe, viewGroup, false)
        return ViewHolder(view)    }

    override fun onBindViewHolder(
        p0: ViewHolder,
        p1: Int
    ) {
        TODO("Not yet implemented")
    }

    override fun getItemCount() = dataset.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {

            val binding = bind(itemView)
            val ivHeaderImage = binding.ivHeaderImage

        }

}