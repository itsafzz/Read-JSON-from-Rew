package com.example.readjson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.TextView
import org.json.JSONArray
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView=findViewById(R.id.textView)


        val jsonData= applicationContext.resources.openRawResource(
            applicationContext.resources.getIdentifier(
                "ex",
                "raw",
                applicationContext.packageName
            )


        ).bufferedReader().use { it.readText() }

        val outputJsonString= JSONObject(jsonData)
        val colors= outputJsonString.getJSONArray("colors") as JSONArray
        for (i in 0 until colors.length()){

            val color=colors.getJSONObject(i).getString("color")
            val category=colors.getJSONObject(i).getString("category")
            val type=colors.getJSONObject(i).getString("type")
            val code=colors.getJSONObject(i).getString("code")

            val previousData=textView.text
            var data:String="$color\n$category\n$type\n$code"

            textView.text=previousData.toString()+data
        }

    }
}