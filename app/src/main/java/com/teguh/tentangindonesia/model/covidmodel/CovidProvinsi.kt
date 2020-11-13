package com.teguh.tentangindonesia.model.covidmodel

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CovidProvinsi (
    val key: String,
    val jumlah_kasus: String,
    val jumlah_sembuh: String,
    val jumlah_meninggal: String,
    val jumlah_dirawat: String
): Parcelable