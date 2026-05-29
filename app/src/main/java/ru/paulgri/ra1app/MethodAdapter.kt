package ru.paulgri.ra1app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.paulgri.ra1app.databinding.ItemMethodBinding.bind

class MethodAdapter(private val dataset: List<String>?) :
    RecyclerView.Adapter<MethodAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = bind(itemView)
        val tvText = binding.tvText
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_method, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.tvText.text = dataset?.getOrNull(position)?.let {
            "%d. %s".format(position + 1, it)
        } ?: viewHolder.itemView.context.getString(R.string.error_load_recipe)
    }

    override fun getItemCount() = dataset?.size ?: 1

}