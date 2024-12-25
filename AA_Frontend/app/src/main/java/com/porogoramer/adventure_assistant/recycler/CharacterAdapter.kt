package com.porogoramer.adventure_assistant.recycler

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.porogoramer.adventure_assistant.R
import com.porogoramer.adventure_assistant.activities.player.PlayerActivity

/*mList only processes strings for now. Change to proper class once working on API*/
class CharacterAdapter : RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {

    var list: MutableList<String>? = ArrayList()

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.name)
        val layout: LinearLayout = itemView.findViewById(R.id.select_player)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.character_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemName = list?.get(position)
        holder.tvName.text = itemName

        // Set OnClickListener on the layout in onBindViewHolder
        holder.layout.setOnClickListener {
            val context = it.context
            val intent = Intent(context, PlayerActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }
}
