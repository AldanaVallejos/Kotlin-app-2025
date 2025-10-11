package com.example.tpgrupallllllllllll

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.tpgrupallllllllllll.dtos.PostDTO
import retrofit2.Call
import retrofit2.Response

class ApiRestActivity : AppCompatActivity() {

    private lateinit var tvServicioRest: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_api_rest)
        val api = RetrofitClient.retrofit.create(ApiEndpoints::class.java)
        val callGetDetails = api.getDetails()

        callGetDetails.enqueue(object : retrofit2.Callback<List<PostDTO>> {
            override fun onResponse(call: Call<List<PostDTO>?>, response: Response<List<PostDTO>?>) {
                //tvServicioRest.text = appdetails?appids=570.toString()
                //Log.d("Response", appdetails?appids=570.toSring())

            }

            override fun onFailure(call: Call<List<PostDTO>?>, t: Throwable) {
                Log.e( "Error", t.message ?:" ")
            }

        })
    }
}
