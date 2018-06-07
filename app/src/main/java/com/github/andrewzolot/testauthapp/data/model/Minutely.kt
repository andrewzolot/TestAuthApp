package com.github.andrewzolot.testauthapp.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Minutely() : Parcelable {

    @SerializedName("summary")
    @Expose
    var summary: String? = null
    @SerializedName("icon")
    @Expose
    var icon: String? = null
    @SerializedName("data")
    @Expose
    var data: List<Datum>? = null

    constructor(parcel: Parcel) : this() {
        summary = parcel.readString()
        icon = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(summary)
        parcel.writeString(icon)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Minutely> {
        override fun createFromParcel(parcel: Parcel): Minutely {
            return Minutely(parcel)
        }

        override fun newArray(size: Int): Array<Minutely?> {
            return arrayOfNulls(size)
        }
    }

}
