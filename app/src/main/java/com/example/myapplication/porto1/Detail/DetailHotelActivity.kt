package com.example.myapplication.porto1.Detail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.myapplication.porto1.Response.Hotel
import com.example.myapplication.porto1.databinding.ActivityDetailBinding

class DetailHotelActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    companion object {
        const val dataHotel = "data_hotel"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataHotel = intent.getParcelableExtra<Hotel>(dataHotel)

        binding.apply {
            Glide.with(this@DetailHotelActivity)
                .load(dataHotel?.gambar_url)
                .transition(DrawableTransitionOptions.withCrossFade())
                .centerCrop()
                .into(photoHotel)
            namaHotel.text = dataHotel?.nama
            alamatHotel.text = dataHotel?.alamat
            noHotel.text = dataHotel?.nomor_telp
        }

        binding.noHotel.setOnClickListener {
            val phoneNumber = dataHotel?.nomor_telp
            val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
            startActivity(dialPhoneIntent)
        }
        binding.alamatHotel.setOnClickListener {
            val alamatHotel = Uri.parse("geo:${dataHotel?.kordinat}?q=${dataHotel?.nama}")
            val mapIntent = Intent(Intent.ACTION_VIEW, alamatHotel)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)
        }
    }
}

