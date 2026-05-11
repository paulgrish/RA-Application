package ru.paulgri.ra1app

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

//@Parcelize
data class Category(
    val id: Int,
    val title: String,
    val description: String,
    val imageUrl: String,
) : Parcelable {
    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }
    override fun writeToParcel(p0: Parcel, p1: Int) {
        TODO("Not yet implemented")
    }
    companion object CREATOR: Parcelable.Creator<Category> {
        override fun createFromParcel(p0: Parcel?): Category? {
            TODO("Not yet implemented")
        }
        override fun newArray(p0: Int): Array<out Category?>? {
            TODO("Not yet implemented")
        }
    }
}

//@Parcelize
data class Ingredient(
    val quantity: Float,
    val unitOfMeasure: String,
    val description: String,
) : Parcelable {
    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }
    override fun writeToParcel(p0: Parcel, p1: Int) {
        TODO("Not yet implemented")
    }
    companion object CREATOR: Parcelable.Creator<Ingredient> {
        override fun createFromParcel(p0: Parcel?): Ingredient? {
            TODO("Not yet implemented")
        }
        override fun newArray(p0: Int): Array<out Ingredient?>? {
            TODO("Not yet implemented")
        }

    }
}

//@Parcelize
data class Recipe(
    val id: Int,
    val title: String,
    val ingredients: List<Ingredient>,
    val method: List<String>,
    val imageUrl: String,
) : Parcelable {
    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }
    override fun writeToParcel(p0: Parcel, p1: Int) {
        TODO("Not yet implemented")
    }
    companion object CREATOR: Parcelable.Creator<Recipe> {
        override fun createFromParcel(p0: Parcel?): Recipe? {
            TODO("Not yet implemented")
        }
        override fun newArray(p0: Int): Array<out Recipe?>? {
            TODO("Not yet implemented")
        }

    }
}