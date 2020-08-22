package com.genxmultiplexer.recyclerviewwithonclicklistener

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.genxmultiplexer.recyclerviewwithonclicklistener.Activities.ActivitySecond
import com.genxmultiplexer.recyclerviewwithonclicklistener.Adapter.Adapter
import com.genxmultiplexer.recyclerviewwithonclicklistener.Model.Model
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity(), Adapter.OnItemClickListener,
    Adapter.OnItemLongClickListener {

    lateinit var recyclerView: RecyclerView
    lateinit var textViewEmtyMessage: TextView
    lateinit var searchView: androidx.appcompat.widget.SearchView
    private val arrayList = ArrayList<Model>()
    private val adapter = Adapter(arrayList, this,this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewEmtyMessage = findViewById(R.id.textViewEmtyMessageId)
        searchView = findViewById(R.id.searchViewId)

        arrayList.add(
            Model(
                "1",
                "Samir-1",
                "https://www.freewebheaders.com/wp-content/uploads/water-coast-header-800x200.jpg"
            )
        )
        arrayList.add(
            Model(
                "2",
                "Samir-2",
                "https://www.freewebheaders.com/wp-content/uploads/water-coast-header-800x200.jpg"
            )
        )
        arrayList.add(
            Model(
                "3",
                "Samir-3",
                "https://www.freewebheaders.com/wp-content/uploads/water-coast-header-800x200.jpg"
            )
        )
        arrayList.add(
            Model(
                "3",
                "Rima",
                "https://www.freewebheaders.com/wp-content/uploads/water-coast-header-800x200.jpg"
            )
        )
        arrayList.add(
            Model(
                "4",
                "Samir-4",
                "https://www.freewebheaders.com/wp-content/uploads/water-coast-header-800x200.jpg"
            )
        )
        arrayList.add(
            Model(
                "5",
                "Samir-5",
                "https://www.freewebheaders.com/wp-content/uploads/water-coast-header-800x200.jpg"
            )
        )
        arrayList.add(
            Model(
                "6",
                "amirsa-6",
                "https://www.freewebheaders.com/wp-content/uploads/water-coast-header-800x200.jpg"
            )
        )
        arrayList.add(
            Model(
                "7",
                "jainal",
                "https://www.freewebheaders.com/wp-content/uploads/water-coast-header-800x200.jpg"
            )
        )
        arrayList.add(
            Model(
                "8",
                "Samir-8",
                "https://www.freewebheaders.com/wp-content/uploads/water-coast-header-800x200.jpg"
            )
        )
        arrayList.add(
            Model(
                "9",
                "Samir-9",
                "https://www.freewebheaders.com/wp-content/uploads/water-coast-header-800x200.jpg"
            )
        )
        arrayList.add(
            Model(
                "10",
                "Samir-10",
                "https://www.freewebheaders.com/wp-content/uploads/water-coast-header-800x200.jpg"
            )
        )


        recyclerView = findViewById(R.id.RecyclerViewId)
        recyclerView.setHasFixedSize(false)
        recyclerView.layoutManager = GridLayoutManager(this, 1)
        recyclerView.adapter = adapter
        checkDataIsAvailable()



        searchView.setOnQueryTextListener(object :
            androidx.appcompat.widget.SearchView.OnQueryTextListener {

            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return false
            }
        })


    }


    private fun checkDataIsAvailable() {
        if (arrayList.isEmpty()) {
            recyclerView.visibility = View.GONE
            textViewEmtyMessage.visibility = View.VISIBLE

        } else {
            recyclerView.visibility = View.VISIBLE
            textViewEmtyMessage.visibility = View.GONE
        }
    }




    private fun openNewActivity(id: String, name: String, image: String) {
        intent = Intent(this, ActivitySecond::class.java)

        intent.putExtra("ID", id)
        intent.putExtra("NAME", name)
        intent.putExtra("IMAGE", image)

        startActivity(intent)
    }


    override fun OnItemClick(position: Int) {
        val position = arrayList[position]
        val id = position.id
        val name = position.name
        val image = position.image

        openNewActivity(id, name, image)

    }



    override fun OnItemLongClick(position: Int) {
        val position = arrayList[position]
        val id = position.id
        val name = position.name
        val image = position.image

        

        Toast.makeText(this,"Long Pressed $name",Toast.LENGTH_SHORT).show()
    }


}


