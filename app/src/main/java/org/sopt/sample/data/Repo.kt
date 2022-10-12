package org.sopt.sample.data

import androidx.annotation.DrawableRes

data class Repo (
    @DrawableRes val image : Int,
    val name: String,
    val author: String,
    val viewType: Int)
{
    companion object {
        const val REPO_TYPE = 0 // repo view
        const val HEADER_TYPE = 1 // title view
    }
}
