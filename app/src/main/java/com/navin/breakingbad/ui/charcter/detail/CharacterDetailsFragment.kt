package com.example.breakingbad.ui.charcter.detail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import coil.load
import com.example.breakingbad.model.BreakingBadCharacter
import com.example.breakingbad.ui.charcter.list.CharactersAdapter
import com.navin.breakingbad.databinding.FragmentCharacterDetailsBinding


class CharacterDetailsFragment : Fragment() {
    private val viewModel: CharacterDetailViewModel by lazy {
        ViewModelProvider(this)[CharacterDetailViewModel::class.java]
    }

    lateinit var binding: FragmentCharacterDetailsBinding
    private val charactersAdapter = CharactersAdapter(onItemClick = this::onCharacterItemClick)

    private lateinit var character: BreakingBadCharacter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharacterDetailsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        character = requireArguments().getParcelable("obj") ?: return

        viewModel.loadCharactersDetail(character.name)

        binding.imgCharacter.load(character.pictureUrl)
        setObservers()
    }

    private fun onCharacterItemClick(character: BreakingBadCharacter) {
        val bundle = Bundle()
        bundle.putParcelable("obj", character)
       // findNavController().navigate(R.id.navigate_to_details_fragment, bundle)
    }
    private fun setObservers() {
        Log.e("","")
        viewModel.selectedCharacter.observe(viewLifecycleOwner) {
          //  binding.textView.setText(it.toString())

            binding.recyclerQuotes.adapter = QuoteAdapter(requireContext() ,character.pictureUrl , it )
            binding.recyclerQuotes.layoutManager = LinearLayoutManager(requireContext() ,
                LinearLayoutManager.VERTICAL , false)


        }
    }



}