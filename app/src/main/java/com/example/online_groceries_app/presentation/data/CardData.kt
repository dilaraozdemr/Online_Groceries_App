package com.example.online_groceries_app.presentation.data

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.DrawableRes

data class CardData(
    val cardId: Int,
    @DrawableRes val imageResId: Int,
    val total: Int,
    val productDetail: String,
    val title: String,
    val desc: String,
    val amount: Double,
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readDouble()
    )
    val formattedTitle: String
        get() = title.replace("+", " ")

    val formattedDesc: String
        get() = desc.replace("+", " ")

    val formattedProductDetail: String
        get() = productDetail.replace("+", " ")

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(cardId)
        parcel.writeInt(imageResId)
        parcel.writeInt(total)
        parcel.writeString(productDetail)
        parcel.writeString(title)
        parcel.writeString(desc)
        parcel.writeDouble(amount)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CardData> {
        override fun createFromParcel(parcel: Parcel): CardData {
            return CardData(parcel)
        }

        override fun newArray(size: Int): Array<CardData?> {
            return arrayOfNulls(size)
        }
    }
}



