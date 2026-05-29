package ru.paulgri.ra1app

import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.divider.MaterialDividerItemDecoration
import ru.paulgri.ra1app.databinding.FragmentRecipeBinding

class RecipeFragment : Fragment() {

    private val binding: FragmentRecipeBinding
        get() = _binding ?: throw IllegalStateException("RecipeFragment: Binding is null")
    private var _binding: FragmentRecipeBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecipeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recipe = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU)
            arguments?.getParcelable(ARG_RECIPE, Recipe::class.java)
        else
            @Suppress("DEPRECATION") arguments?.getParcelable(ARG_RECIPE)
        Log.d("RecipeFragment", recipe.toString())
        binding.tvHeaderTitle.text = recipe?.title
        binding.ivHeaderImage.setImageDrawable(
            try {
                Drawable.createFromStream(
                    binding.ivHeaderImage.context.assets.open((recipe?.imageUrl) ?: ""),
                    null
                )
            } catch (e: Exception) {
                Log.e("CategoryListAdapter", e.stackTrace.toString())
                null
            }
        )
        binding.rvIngredients.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = IngredientsAdapter(recipe?.ingredients)
            addItemDecoration(
                MaterialDividerItemDecoration(
                    requireContext(),
                    LinearLayoutManager.VERTICAL
                )
            )
        }
        binding.rvMethod.apply {
            layoutManager= LinearLayoutManager(requireContext())
            adapter= MethodAdapter(recipe?.method)
            addItemDecoration(
                MaterialDividerItemDecoration(
                    requireContext(),
                    LinearLayoutManager.VERTICAL
                )
            )
        }
    }
}