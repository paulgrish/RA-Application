package ru.paulgri.ra1app

import android.os.Build
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
        return 0
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(title)
        parcel.writeString(description)
        parcel.writeString(imageUrl)
    }

    companion object CREATOR : Parcelable.Creator<Category> {
        override fun createFromParcel(parcel: Parcel): Category? {
            return Category(
                parcel.readInt(),
                parcel.readString().toString(),
                parcel.readString().toString(),
                parcel.readString().toString(),
            )
        }

        override fun newArray(size: Int): Array<out Category?>? {
            return arrayOfNulls(size)
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
        return 0
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeFloat(quantity)
        parcel.writeString(unitOfMeasure)
        parcel.writeString(description)
    }

    companion object CREATOR : Parcelable.Creator<Ingredient> {
        override fun createFromParcel(parcel: Parcel): Ingredient? {
            return Ingredient(
                parcel.readFloat(),
                parcel.readString().toString(),
                parcel.readString().toString(),
            )
        }

        override fun newArray(size: Int): Array<out Ingredient?>? {
            return arrayOfNulls(size)
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
        return 0
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(title)
        parcel.writeParcelableList(ingredients, flags)
        parcel.writeStringList(method)
        parcel.writeString(imageUrl)
    }

    companion object CREATOR : Parcelable.Creator<Recipe> {
        override fun createFromParcel(parcel: Parcel): Recipe? {
            return Recipe(
                parcel.readInt(),
                parcel.readString().toString(),
                @Suppress("DEPRECATION") parcel.readParcelableList(mutableListOf(), Ingredient::class.java.classLoader),
                parcel.createStringArrayList() ?: emptyList(),
                parcel.readString().toString(),
            )
        }

        override fun newArray(size: Int): Array<out Recipe?>? {
            return arrayOfNulls(size)
        }

    }
}