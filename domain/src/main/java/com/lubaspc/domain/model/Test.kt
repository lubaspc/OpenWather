package com.lubaspc.domain.model
data class Test (

	val coord : Coord,
	val weather : List<Weather>,
	val base : String,
	val main : Main,
	val visibility : Int,
	val wind : Wind,
	val rain : String,
	val clouds : Clouds,
	val dt : Int,
	val sys : Sys,
	val timezone : Int,
	val id : Int,
	val name : String,
	val cod : Int
)