package ru.paulgri.ra1app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.paulgri.ra1app.databinding.ItemIngredientBinding.bind

class IngredientsAdapter(private val dataset: List<Ingredient>?) :
    RecyclerView.Adapter<IngredientsAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = bind(itemView)
        val tvName = binding.tvName
        val tvAmount = binding.tvAmount
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_ingredient, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        dataset?.getOrNull(position)?.let {
            viewHolder.tvName.text = it.description
            viewHolder.tvAmount.text = "%.2f %s".format(it.quantity, it.unitOfMeasure)
        }.ifNull {
            viewHolder.tvName.text =
                viewHolder.itemView.context.getString(R.string.error_load_ingredients)
            viewHolder.tvAmount.text = ""
        }
    }

    override fun getItemCount() = dataset?.size ?: 1

}