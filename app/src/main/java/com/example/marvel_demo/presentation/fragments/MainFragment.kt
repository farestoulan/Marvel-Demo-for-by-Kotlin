package com.example.marvel_demo.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.marvel_demo.R
import com.example.marvel_demo.data.models.CharacterModel
import com.example.marvel_demo.presentation.adapter.CharactersAdapter
import com.example.marvel_demo.presentation.viewModels.MarvelViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.fragment_main) {

    private val viewModel by viewModels<MarvelViewModel>()


    private val charactersAdapter by lazy {
        CharactersAdapter(object :
            CharactersAdapter.ItemClickListener {
            override fun onItemClick(data: CharacterModel) {
                val action =
                    MainFragmentDirections.actionMainFragmentToDescriptionFragment(
                        data.description
                    )
                findNavController().navigate(action)
            }
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRV(view)

        lifecycleScope.launch {
            viewModel.getData().observe(viewLifecycleOwner) {
                if (it != null) {
                    charactersAdapter.submitList(it.data?.results.orEmpty())
                }
            }
        }
    }

    private fun initRV(view: View) {
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)

        recyclerView.adapter = charactersAdapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

}