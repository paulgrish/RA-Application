package ru.paulgri.ra1app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.paulgri.ra1app.databinding.FragmentListCategoriesBinding

/**
 * A simple [Fragment] subclass.
 * Use the [CategoriesListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CategoriesListFragment : Fragment() {

    private val binding: FragmentListCategoriesBinding
        get() = _binding ?: throw IllegalStateException("CategoriesListFragment: Binding is null")

    private var _binding: FragmentListCategoriesBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = FragmentListCategoriesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
    }

    fun initRecycler() {
        binding.rvCategories.adapter = CategoriesListAdapter(STUB.getCategories())
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}