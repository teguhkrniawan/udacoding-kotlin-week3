package com.teguh.tentangindonesia.model.covidmodel

data class CovidResponse (
    val last_date: String,
    val list_data: ArrayList<CovidProvinsi>
)