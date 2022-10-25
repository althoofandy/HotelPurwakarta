package com.example.myapplication.porto1.UI

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.porto1.About.AboutActivity
import com.example.myapplication.porto1.Detail.DetailHotelActivity
import com.example.myapplication.porto1.R
import com.example.myapplication.porto1.Response.Hotel
import com.example.myapplication.porto1.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showImage(true)
        viewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[MainViewModel::class.java]
        adapter = Adapter()
        viewModel.setListHotel()
        binding.rvHotel.setHasFixedSize(true)
        viewModel.getListHotel().observe(this) {
            adapter.setList(it)
            binding.apply {
                rvHotel.layoutManager = LinearLayoutManager(this@MainActivity)
                rvHotel.adapter = adapter
                showImage(false)
            }
        }


        adapter.setOnItemClickCallback(object : Adapter.OnItemClickCallback {
            override fun onItemClicked(hotel: Hotel) {
                Intent(this@MainActivity, DetailHotelActivity::class.java).also {
                    val listHotel = Hotel(
                        hotel.id,
                        hotel.nama,
                        hotel.alamat,
                        hotel.nomor_telp,
                        hotel.kordinat,
                        hotel.gambar_url
                    )
                    it.putExtra(DetailHotelActivity.dataHotel, listHotel)
                    startActivity(it)
                }
            }
        })

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_about -> {
                Intent(this, AboutActivity::class.java).also {
                    startActivity(it)
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }


    fun showImage(boolean: Boolean = true) {
        if (boolean) {
            binding.noInternet.visibility = View.VISIBLE
        } else {
            binding.noInternet.visibility = View.GONE
        }
    }
}