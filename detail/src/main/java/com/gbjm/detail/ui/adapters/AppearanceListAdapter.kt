package com.gbjm.detail.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gbjm.core.ui_view_holder.BaseViewHolder
import com.gbjm.detail.R
import com.gbjm.detail.ui.entity.UiAppearanceRow

class AppearanceListAdapter : RecyclerView.Adapter<AppearanceListAdapter.AppearanceViewHolder>() {

    private var appearanceList: List<UiAppearanceRow> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppearanceViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_appearance, parent, false)
        return AppearanceViewHolder(view)
    }

    override fun getItemCount(): Int = appearanceList.size

    override fun onBindViewHolder(holder: AppearanceViewHolder, position: Int) {
        with (appearanceList[position]) {
            holder.bind(this)
        }
    }

    fun set(listModel: List<UiAppearanceRow>) {
        appearanceList = listModel
        notifyDataSetChanged()
    }

    class AppearanceViewHolder(view: View) : BaseViewHolder<UiAppearanceRow>(view) {
        var name: TextView = view.findViewById(R.id.tvName)
        var type: TextView = view.findViewById(R.id.tvType)
        var url: TextView = view.findViewById(R.id.tvUrl)

        override fun bind(item: UiAppearanceRow) {
            name.text = item.name
            type.text = item.type
            url.text = item.url
        }
    }
}