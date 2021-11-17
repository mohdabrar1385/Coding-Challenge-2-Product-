package com.smartherd.codingchallenge
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.Charset


class MainActivity : AppCompatActivity() {

    var productTitle: ArrayList<String> = ArrayList()
    var productDescription: ArrayList<String> = ArrayList()
    var productPrice: ArrayList<String> = ArrayList()
    var productRating: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val linearLayoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = linearLayoutManager

        try {
            val obj = JSONObject(loadJSONFromAsset())
            val userArray = obj.getJSONArray("products")
            for (i in 0 until userArray.length()) {
                val userDetail = userArray.getJSONObject(i)
                productTitle.add(userDetail.getString("title"))
                productDescription.add(userDetail.getString("description"))
                productPrice.add(userDetail.getString("price"))
                productRating.add(userDetail.getString("rating"))

            }
        }
        catch (e: JSONException) {
            e.printStackTrace()
        }

        val customAdapter = CustomAdapter(this@MainActivity, productTitle, productDescription, productPrice, productRating)
        recyclerView.adapter = customAdapter
    }


    private fun loadJSONFromAsset(): String {
        val json: String?
        try {
            val inputStream = assets.open("model.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            val charset: Charset = Charsets.UTF_8
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer, charset)
        }
        catch (ex: IOException) {
            ex.printStackTrace()
            return ""
        }

        return json
    }
}