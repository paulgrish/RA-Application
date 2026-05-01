package ru.paulgri.ra1app

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.paulgri.ra1app.databinding.FragmentRecipesListBinding

class RecipesListFragment : Fragment() {

    private val binding: FragmentRecipesListBinding
        get() = _binding ?: throw IllegalStateException("RecipesListFragment: Binding is null")
    private var _binding: FragmentRecipesListBinding? = null

    var categoryId: Int? = null
    var categoryName: String? = null
    var categoryImageUrl: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = FragmentRecipesListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        categoryId = arguments?.getInt(ARG_CATEGORY_ID)
        categoryName = arguments?.getString(ARG_CATEGORY_NAME)
        categoryImageUrl = arguments?.getString(ARG_CATEGORY_IMAGE_URL)

        binding.tvHeaderTitle.text = categoryName
        binding.ivHeaderImage.setImageDrawable(
            try {
                Drawable.createFromStream(
                    binding.ivHeaderImage.context.assets.open(categoryImageUrl ?: ""),
                    null
                )
            } catch (e: Exception) {
                Log.e("RecipesListFragment", e.stackTrace.toString())
                null
            }
        )
    }
}