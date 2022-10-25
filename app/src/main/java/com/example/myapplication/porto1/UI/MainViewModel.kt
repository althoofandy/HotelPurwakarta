package com.example.myapplication.porto1.UI

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.porto1.API.Retrofit
import com.example.myapplication.porto1.Response.Hotel
import com.example.myapplication.porto1.Response.HotelResponse
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel: ViewModel() {

    private val listHotels = MutableLiveData<ArrayList<Hotel>>()
    fun setListHotel(){
        viewModelScope.launch {
            Retrofit.apiInstance
                .hotel()
                .enqueue(object : Callback<HotelResponse> {
                    override fun onResponse(
                        call: Call<HotelResponse>,
                        response: Response<HotelResponse>
                    ) {
                        if (response.isSuccessful) {
                            listHotels.postValue(response.body()?.listHotel as ArrayList<Hotel>?)
                            Log.d("CEK", response.body()!!.listHotel.toString())

                        }
                    }

                    override fun onFailure(call: Call<HotelResponse>, t: Throwable) {
                        Log.d("Failure", t.message!!)
                    }
                })
        }
    }

    fun getListHotel(): MutableLiveData<ArrayList<Hotel>> {
        return listHotels
    }
}