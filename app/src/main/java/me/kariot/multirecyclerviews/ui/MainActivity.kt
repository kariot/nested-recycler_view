package me.kariot.multirecyclerviews.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import me.kariot.multirecyclerviews.R
import me.kariot.multirecyclerviews.adapters.AdapterMain
import me.kariot.multirecyclerviews.model.ModelMainData
import me.kariot.multirecyclerviews.model.ModelNestedData

class MainActivity : AppCompatActivity() {

    var arrayList = ArrayList<ModelMainData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()
        recycler_main.adapter = AdapterMain(this,arrayList){ mainIndex,innerIndex->

            Toast.makeText(this,arrayList[mainIndex].mainHeading + " " + arrayList[mainIndex].dataList[innerIndex].title,Toast.LENGTH_LONG).show()

        }


    }

    //init list with data
    private fun initData() {

        for (i in 0..4){ // data for main recycler

            val mainHeading = "Heading $i"

            val innerArray = ArrayList<ModelNestedData>()

            for (j in 0..4) { // data for inner recycler
                innerArray.add(ModelNestedData("Title $j", "Message $j"))
            }
            arrayList.add(ModelMainData(mainHeading,innerArray))

        }

    }
}
