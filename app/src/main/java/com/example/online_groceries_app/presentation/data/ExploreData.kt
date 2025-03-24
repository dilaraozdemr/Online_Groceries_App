package com.example.online_groceries_app.presentation.data

import android.os.Parcel
import android.os.Parcelable
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.versionedparcelable.ParcelField


data class ExploreData(
    @DrawableRes val image: Int,
    val title: String,
    @ColorRes val color: Int,
    @ColorRes val borderColor: Int,
    val cardDataList: List<CardData>
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readInt(),
        parcel.readInt(),
        mutableListOf<CardData>().apply {
            parcel.readTypedList(this, CardData.CREATOR)
        }
    )
    val formattedTitle: String
        get() = title.replace("+", " ")
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(image)
        parcel.writeString(title)
        parcel.writeInt(color)
        parcel.writeInt(borderColor)
        parcel.writeTypedList(cardDataList)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ExploreData> {
        override fun createFromParcel(parcel: Parcel): ExploreData {
            return ExploreData(parcel)
        }

        override fun newArray(size: Int): Array<ExploreData?> {
            return arrayOfNulls(size)
        }
    }
}
