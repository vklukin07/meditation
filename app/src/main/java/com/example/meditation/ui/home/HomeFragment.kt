package com.example.meditation.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.meditation.R
import com.example.meditation.recycAdapter.*
import retrofit2.Call
import retrofit2.Response

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val root = inflater.inflate(R.layout.nav_home, container, false)

        val recycler1:RecyclerView = root.findViewById(R.id.recyclerView1)
        val recycler2:RecyclerView = root.findViewById(R.id.rV2)

        val quotes = myRetrofit().getRetrofit()
        val api_ret = quotes.create(myInterface::class.java)
        val quotes_call:retrofit2.Call<quotes> = api_ret.getQuotes()
        quotes_call.enqueue(object : retrofit2.Callback<quotes>{
            override fun onResponse(call: Call<quotes>, response: Response<quotes>) {
                if (response.isSuccessful){
                    recycler2.adapter = response.body()?.let { FeelRecycler2(requireContext(), it) }
                }
            }

            override fun onFailure(call: Call<quotes>, t: Throwable) {

            }

        })

        val feelings = myRetrofit().getRetrofit()
        val api_ret1 = feelings.create(myInterface::class.java)
        val feelings_call:retrofit2.Call<feelings> = api_ret1.getFeel()
        feelings_call.enqueue(object : retrofit2.Callback<feelings>{
            override fun onResponse(call: Call<feelings>, response: Response<feelings>) {
                if (response.isSuccessful){
                    recycler1.adapter = response.body()?.let { FeelRecycler1(requireContext(), it) }
                }
            }

            override fun onFailure(call: Call<feelings>, t: Throwable) {

            }

        })

        return root
    }
}