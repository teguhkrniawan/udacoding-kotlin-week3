package com.teguh.tentangindonesia.model.daerahmodel

data class Kabupaten (
    val id: Int,
    val id_provinsi: Int,
    val nama:String
) {
    override fun toString(): String {
        return this.nama
    }
}