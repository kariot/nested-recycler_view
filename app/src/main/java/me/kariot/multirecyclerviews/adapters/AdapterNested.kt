package me.kariot.multirecyclerviews.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import me.kariot.multirecyclerviews.R
import me.kariot.multirecyclerviews.model.ModelNestedData

class AdapterNested(val context: Context, val data : ArrayList<ModelNestedData>,val onItemClick : (Int) -> Unit) : RecyclerView.Adapter<AdapterNested.NestedVH>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NestedVH {
       return NestedVH(LayoutInflater.from(parent.context).inflate(R.layout.recycler_nested_item,parent,false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: NestedVH, position: Int) {

        holder.mTxtMain.text = data[position].title
        holder.mTxtSub.text = data[position].message
        holder.itemView.setOnClickListener {
            onItemClick(position)
        }

    }

    class NestedVH(itemView: View) : RecyclerView.ViewHolder(itemView){
         val mTxtSub by lazy { itemView.findViewById<TextView>(R.id.txtSub) }
         val mTxtMain by lazy { itemView.findViewById<TextView>(R.id.txtMain) }
    }

}