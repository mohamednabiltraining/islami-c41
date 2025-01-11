package com.route.islamic41.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Chapter(
    val index: Int,
    val titleEn: String,
    val titleAr: String,
    val versesNumber: String,
):Parcelable
