package ru.paulgri.ra1app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import ru.paulgri.ra1app.databinding.FragmentCategoriesListBinding

class CategoriesListFragment : Fragment() {

    private val binding: FragmentCategoriesListBinding
        get() = _binding ?: throw IllegalStateException("CategoriesListFragment: Binding is null")

    private var _binding: FragmentCategoriesListBinding? = null

    private lateinit var categoriesListAdapter: CategoriesListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = FragmentCategoriesListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
    }

    fun initRecycler() {
        categoriesListAdapter = CategoriesListAdapter(STUB.getCategories())
        binding.rvCategories.adapter = categoriesListAdapter
        categoriesListAdapter.setOnItemClickListener(
            object: CategoriesListAdapter.OnItemClickListener {
                override fun onItemClick(categoryId: Int) {
                    openRecipesByCategoryId(categoryId)
                }
            }
        )
    }

    private fun openRecipesByCategoryId(categoryId: Int) {
        val category: Category? = STUB.getCategories().find { it.id == categoryId }
        val categoryName = category?.title ?: ""
        val categoryImageUrl = category?.imageUrl ?: ""
        val bundle = Bundle()
        bundle.putInt("ARG_CATEGORY_ID", categoryId)
        bundle.putString("ARG_CATEGORY_NAME", categoryName)
        bundle.putString("ARG_CATEGORY_IMAGE_URL", categoryImageUrl)
        requireActivity().supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(R.id.mainContainer, RecipesListFragment(), bundle)
            addToBackStack(null)
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}