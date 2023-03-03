package com.example.breakingbad.ui.charcter.detail

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
 import com.example.breakingbad.model.CharacterQuote
import com.navin.breakingbad.R

class QuoteAdapter (mContext :  Context ,image : String, list: List<CharacterQuote>): RecyclerView.Adapter<QuoteAdapter.QuoteVH>() {

    var context = mContext;
    var characterQuote  = list
    var imagePath = image


    class QuoteVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var imgCharacter =  itemView.findViewById<AppCompatImageView>(R.id.img_character);
        var txtQuote =  itemView.findViewById<AppCompatTextView>(R.id.txt_quote);
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuoteVH {

        var view : View = LayoutInflater.from(context).inflate(R.layout.quote_row , null)

        return  QuoteVH(view)

    }

    override fun onBindViewHolder(holder: QuoteVH, position: Int) {

       var quote :  CharacterQuote = characterQuote.get(position)

        holder.imgCharacter.load(imagePath)
        holder.txtQuote.setText(quote.quote)



    }

    override fun getItemCount(): Int {
       return  characterQuote.size
    }

}