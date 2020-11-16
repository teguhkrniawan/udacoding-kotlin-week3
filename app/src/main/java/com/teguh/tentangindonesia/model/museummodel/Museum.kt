package com.teguh.tentangindonesia.model.museummodel

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Museum (
    val nama: String,
    val alamat_jalan: String,
    val kecamatan: String,
    val kabupaten_kota: String,
    val propinsi: String
): Parcelable