package com.genxmultiplexer.recyclerviewwithonclicklistener.Adapter

import android.graphics.Color
import android.text.Html
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.genxmultiplexer.recyclerviewwithonclicklistener.Model.Model
import com.genxmultiplexer.recyclerviewwithonclicklistener.R
import java.util.*
import kotlin.collections.ArrayList


class Adapter(private var list: List<Model>, private val listener: OnItemClickListener,private val longPress:OnItemLongClickListener) :
    RecyclerView.Adapter<Adapter.MyviewHolder>(),
    Filterable { //Filtering:Step-3, inherit Filterable

    //Filtering:Step-1, Make variable and intitalize it

    var filterList: List<Model>

    init {
        this.filterList = list

        //Filtering:Step-2, assigning main list to filtered list
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.sample_layout, parent, false)
        return MyviewHolder(view)
    }

    override fun getItemCount(): Int {

        //Filtering:Step-5, change the old list new filtered list
        return filterList.size
    }

    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {

        //Filtering:Step-6, change the old list new filtered list
        val itemPositon = filterList[position]

        holder.textViewserialNo.text = itemPositon.id
        holder.textViewName.text = itemPositon.name




    }

    interface OnItemClickListener {
        fun OnItemClick(position: Int)
    }

    interface OnItemLongClickListener {
        fun OnItemLongClick(position: Int)
    }


    inner class MyviewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener, View.OnLongClickListener {

        val textViewserialNo: TextView = itemView.findViewById(R.id.textViewSerialId)
        val textViewName: TextView = itemView.findViewById(R.id.textViewNameId)


        init {
            itemView.setOnClickListener(this)
            itemView.setOnLongClickListener(this)

        }

        override fun onClick(view: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.OnItemClick(position)
            }

        }

        override fun onLongClick(view: View?): Boolean {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                longPress.OnItemLongClick(position)
            }

            return true
        }

    }


    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(constraint: CharSequence?): FilterResults {
                val charSearch = constraint.toString()

                if (charSearch.isEmpty()) {
                    filterList = list //ekhane filter na kore main list ke, filter list a add kore
                } else {
                    val resultList = ArrayList<Model>()
                    for (row in list) {

                        val valueFromList = row.name.toLowerCase(Locale.ROOT)

                        if (valueFromList.contains(charSearch.toLowerCase(Locale.ROOT))) {
                            resultList.add(row);
                        }


                    }

                    ////


                    ///////
                    filterList = resultList
                }
                val filterResults = FilterResults()
                filterResults.values = filterList
                return filterResults
            }

            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
                filterList = results!!.values as List<Model>
                notifyDataSetChanged()
            }
        }
    }


}

