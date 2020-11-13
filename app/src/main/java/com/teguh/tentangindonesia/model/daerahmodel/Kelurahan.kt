package com.teguh.tentangindonesia.model.daerahmodel

data class Kelurahan (
    val id: Int,
    val id_kecamatan: Int,
    val nama: String
) {
    override fun toString(): String {
        return this.nama
    }
}