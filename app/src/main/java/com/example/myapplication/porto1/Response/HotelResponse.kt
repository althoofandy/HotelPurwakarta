package com.example.myapplication.porto1.Response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class HotelResponse(
    @field:SerializedName("hotel")
    val listHotel: List<Hotel>
)
@Parcelize
data class Hotel(
    @field:SerializedName("id")
    val id: Int,

    @field:SerializedName("nama")
    val nama: String?,

    @field:SerializedName("alamat")
    val alamat: String?,

    @field:SerializedName("nomor_telp")
    val nomor_telp: String?,

    @field:SerializedName("kordinat")
    val kordinat: String?,

    @field:SerializedName("gambar_url")
    val gambar_url: String?
):Parcelable
