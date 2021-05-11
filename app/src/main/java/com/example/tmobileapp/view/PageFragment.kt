package com.example.tmobileapp.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.tmobileapp.R
import com.example.tmobileapp.adapter.CardsAdapter
import com.example.tmobileapp.databinding.FragmentPageBinding
import com.example.tmobileapp.model.CardHolder
import com.example.tmobileapp.repo.PageRepo
import com.example.tmobileapp.util.PageState
import com.example.tmobileapp.util.viewModelFactory
import com.example.tmobileapp.viewmodel.PageViewModel

class PageFragment : Fragment(R.layout.fragment_page) {

    private val pageViewModel by viewModelFactory {
        val pageRepo = PageRepo.getRepo(requireActivity().application)
        PageViewModel(pageRepo)
    }
    private lateinit var binding: FragmentPageBinding

    private val cardClicked: (CardHolder) -> Unit = {}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPageBinding.bind(view)
        pageViewModel.cards.observe(viewLifecycleOwner) {
            if (it is PageState.Loaded) binding.rvCard.adapter = CardsAdapter(it.data, cardClicked)
        }
    }
}