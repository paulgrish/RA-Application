package ru.paulgri.ra1app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ru.paulgri.ra1app.databinding.FragmentFavoritesBinding

class FavoritesFragment : Fragment() {

    private val binding: FragmentFavoritesBinding
        get() = _binding ?: throw IllegalStateException("FavoritesFragment: Binding is null")

    private var _binding: FragmentFavoritesBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        _binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}