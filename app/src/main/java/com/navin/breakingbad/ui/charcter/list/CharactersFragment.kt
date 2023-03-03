package com.example.breakingbad.ui.charcter.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
  import com.example.breakingbad.model.BreakingBadCharacter
import com.navin.breakingbad.R
import com.navin.breakingbad.databinding.FragmentCharactersBinding

class CharactersFragment : Fragment() {

    private val viewModel: CharactersViewModel by lazy {
        ViewModelProvider(this)[CharactersViewModel::class.java]
    }
    lateinit var binding: FragmentCharactersBinding
    private val charactersAdapter = CharactersAdapter(onItemClick = this::onCharacterItemClick)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharactersBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerViewCharacters.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.recyclerViewCharacters.adapter = charactersAdapter
        binding.recyclerViewCharacters.setHasFixedSize(true)
        setObservers()
    }

    private fun onCharacterItemClick(character: BreakingBadCharacter) {
        val bundle = Bundle()
        bundle.putParcelable("obj", character)
        findNavController().navigate(R.id.navigate_to_details_fragment, bundle)
    }

    private fun setObservers() {
        viewModel.characters.observe(viewLifecycleOwner) { charactersList ->
            charactersAdapter.updateCharacters(charactersList)
        }
    }
}


//    override fun onItemClicked(characterName: String) {
//        viewModel.onItemClicked(characterName)


//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        owner = this
//       adapter = CharactersAdapter(context, listOf(),  this)
//    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        // Inflate the layout for this fragment
//        binding = FragmentFirstBinding.inflate(layoutInflater)
//        viewModel = ViewModelProvider(this)[CharactersViewModel::class.java]
//        return binding.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        // Initialize your views
//        initRecyclerView()
//        // Set observers
//        setObservers()
//
//
//        viewModel.selectedCharacter.observe(viewLifecycleOwner){ item->
//            val bundle = Bundle().also {
//                it.putParcelable("obj", item)
//            }
//            view.findNavController().navigate(R.id.action_firstFragment_to_secondFragment, bundle)
//        }
//    }
//
//    private fun initRecyclerView() {
//        binding.recyclerViewCharacters.layoutManager = LinearLayoutManager(context)
//        binding.recyclerViewCharacters.adapter = adapter
//        binding.recyclerViewCharacters.setHasFixedSize(true)
//    }
//
//    private fun setObservers() {
//        viewModel.characters.observe(owner) { charactersList ->
//            adapter.dataset = charactersList
//            adapter.notifyDataSetChanged()
//        }
//    }
//
//    override fun onItemClicked(characterName: String) {
//        viewModel.onItemClicked(characterName)
//
//    }


