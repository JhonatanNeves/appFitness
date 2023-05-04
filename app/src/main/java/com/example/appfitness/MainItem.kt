package com.example.appfitness

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import java.sql.RowId

data class MainItem(
    val id : Int,
    @DrawableRes val drawId: Int,
    @StringRes val texStringId: Int,
    val color: Int
)
