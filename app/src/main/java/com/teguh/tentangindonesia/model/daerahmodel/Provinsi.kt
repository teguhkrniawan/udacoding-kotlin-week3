package com.teguh.tentangindonesia.model.daerahmodel

data class Provinsi (
    val id: Int,
    val nama: String
){
    override fun toString(): String {
        return this.nama
    }
}
