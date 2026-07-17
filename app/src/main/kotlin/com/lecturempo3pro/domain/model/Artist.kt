package com.lecturempo3pro.domain.model

data class Artist(
    val id: String,
    val name: String,
    val songCount: Int = 0,
    val albumCount: Int = 0
)
