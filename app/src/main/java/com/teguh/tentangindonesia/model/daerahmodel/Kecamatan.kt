package com.teguh.tentangindonesia.model.daerahmodel

data class Kecamatan (
    val id: Int,
    val id_kota: Int,
    val nama: String
) {
    override fun toString(): String {
        return this.nama
    }
}