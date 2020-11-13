package com.teguh.tentangindonesia.model.batikmodel

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * @property link_batik : adalah gambar batik
 */

@Parcelize
data class Batik (
    val nama_batik: String,
    val daerah_batik: String,
    val makna_batik: String,
    val harga_rendah: Int,
    val harga_tinggi: Int,
    val link_batik: String
) : Parcelable