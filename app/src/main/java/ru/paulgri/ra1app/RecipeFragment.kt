package ru.paulgri.ra1app

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.paulgri.ra1app.databinding.FragmentRecipeBinding
import ru.paulgri.ra1app.databinding.FragmentRecipesListBinding

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
    ): View? {
        _binding = FragmentRecipeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recipe = arguments?.getParcelable<Recipe>(ARG_RECIPE)
        Log.d("RecipeFragment", recipe.toString())
        binding.tvHeaderTitle.text = recipe?.title
    }
}