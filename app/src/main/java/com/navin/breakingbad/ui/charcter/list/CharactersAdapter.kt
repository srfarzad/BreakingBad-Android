package com.example.breakingbad.ui.charcter.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
 import com.example.breakingbad.model.BreakingBadCharacter
import com.example.breakingbad.model.CharacterQuote
import com.navin.breakingbad.R

class CharactersAdapter(
    private val characters: MutableList<BreakingBadCharacter> = mutableListOf(),
    private val onItemClick: (BreakingBadCharacter) -> Unit
) : RecyclerView.Adapter<CharactersAdapter.ItemViewHolder>() {

    fun updateCharacters(newCharacters: List<BreakingBadCharacter>) {
        characters.clear()
        characters.addAll(newCharacters)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = characters[position]
        holder.titleTextView.text = item.name
        holder.statusTextView.text = item.status
        val imgUri = item.pictureUrl.toUri().buildUpon().scheme("https").build()
        holder.imageView.load(imgUri) {
            crossfade(true)
            transformations(CircleCropTransformation())
        }
        holder.itemView.setOnClickListener { onItemClick(item) }
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleTextView: TextView = view.findViewById(R.id.item_title)
        val statusTextView: TextView = view.findViewById(R.id.item_status)
        val imageView: ImageView = view.findViewById(R.id.item_image)
        val parentLayout: LinearLayout = view.findViewById(R.id.parent_layout)
    }

    override fun getItemCount(): Int {
        return characters.size
    }


    //interface ItemClickListener {
//        fun onItemClicked(characterName: String)
//    }}
}




