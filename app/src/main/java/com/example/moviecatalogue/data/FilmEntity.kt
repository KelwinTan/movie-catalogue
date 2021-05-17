package com.example.moviecatalogue.data

import java.util.*

data class FilmEntity(
    var filmId: String,
    var title: String,
    var description: String,
    var type: String,
    var releaseDate: String,
    var imagePath: String,
    var rating: Number,
    )
