package com.example.superherous.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.superherous.R

data class Hero(

    @StringRes val name : Int,
    @StringRes val description : Int,
    @DrawableRes val imageResourceId : Int,
)
val heros = listOf(
    Hero(R.string.hero1,R.string.description1,R.drawable.android_superhero1),
    Hero(R.string.hero2,R.string.description2,R.drawable.android_superhero2))