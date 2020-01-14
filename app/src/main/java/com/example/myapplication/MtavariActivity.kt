package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast

class MtavariActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mtavari)
        var listview = findViewById<ListView>(R.id.listView)
        var list = mutableListOf<Model>()
        list.add(Model("თქვენი მენიუ","სამარხვო",R.mipmap.samarxopica,"შერჩევა"))
        list.add(Model("40 კაციანი","სამარხვო",R.mipmap.samarxopica,"600₾ "))
        list.add(Model("35 კაციანი","სამარხვო",R.mipmap.samarxopica,"535₾ "))
        list.add(Model("30 კაციანი","სამარხვო",R.mipmap.samarxopica,"450₾ "))
        list.add(Model("25 კაციანი","სამარხვო",R.mipmap.samarxopica,"375₾ "))
        list.add(Model("20 კაციანი","სამარხვო",R.mipmap.samarxopica,"300₾ "))
        list.add(Model("15 კაციანი","სამარხვო",R.mipmap.samarxopica,"225₾ "))
        list.add(Model("10 კაციანი","სამარხვო",R.mipmap.samarxopica,"150₾ "))
        list.add(Model("5 კაციანი","სამარხვო",R.mipmap.samarxopica,"75₾ "))
        listview.adapter = MyAdapter(this,R.layout.row,list)
        listview.setOnItemClickListener { parent: AdapterView<*>, view: View, position: Int, id: Long ->
            if (position == 0){
                Toast.makeText(this,"40 kaciani",Toast.LENGTH_LONG).show()
            }
        }
    }
}