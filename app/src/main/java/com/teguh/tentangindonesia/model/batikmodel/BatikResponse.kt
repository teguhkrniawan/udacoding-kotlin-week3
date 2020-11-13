package com.teguh.tentangindonesia.model.batikmodel

data class BatikResponse (
    val total_halaman: Int,
    val total_element: Int,
    val min_price: Int,
    val max_price: Int,
    val hasil: ArrayList<Batik>
)