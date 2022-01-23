package com.gbjm.characters.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gbjm.core.ui_view_holder.BaseViewHolder
import com.gbjm.characters.R
import com.gbjm.characters.ui.entity.UiCharacterRow
import com.squareup.picasso.Picasso

class CharacterListAdapter : RecyclerView.Adapter<CharacterListAdapter.ListViewHolder>() {

    interface CharacterListener {
        fun onCharacterClicked(character: UiCharacterRow)
    }

    private var characters: List<UiCharacterRow> = emptyList()
    private lateinit var listener: CharacterListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_character, parent, false)
        return ListViewHolder(view,listener)
    }

    override fun getItemCount(): Int = characters.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        with (characters[position]) {
            holder.bind(this)
        }
    }

    fun set(listModel: List<UiCharacterRow>) {
        characters = listModel
        notifyDataSetChanged()
    }

    fun listener(listener: CharacterListener) {
        this.listener = listener
    }

    class ListViewHolder(view: View, private val listener: CharacterListener) : BaseViewHolder<UiCharacterRow>(view) {
        var image: ImageView = view.findViewById(R.id.ivCharacter)
        var title: TextView = view.findViewById(R.id.tvTitle)
        var description: TextView = view.findViewById(R.id.tvDescription)
        var parent: View = view.findViewById(R.id.parent)

        override fun bind(item: UiCharacterRow) {
            Picasso.get().cancelRequest(image)
            if (!item.image.isNullOrEmpty()) {
               image?.let {
                    Picasso.get().isLoggingEnabled = true
                    Picasso.get()
                        .load(item.image)
                        .placeholder(R.drawable.place_holder)
                        .error(R.drawable.image_error)
                        .into(it)
                }
            } else {
                image.setImageResource(R.drawable.image_error)
            }
            title.text = item.name
            description.text = item.description

            parent.setOnClickListener {
                listener.onCharacterClicked(item)
            }
        }
    }

}
