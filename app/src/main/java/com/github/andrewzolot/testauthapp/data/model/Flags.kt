package com.github.andrewzolot.testauthapp.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Flags() : Parcelable {

    @SerializedName("sources")
    @Expose
    var sources: List<String>? = null
    @SerializedName("isd-stations")
    @Expose
    var isdStations: List<String>? = null
    @SerializedName("units")
    @Expose
    var units: String? = null

    constructor(parcel: Parcel) : this() {
        sources = parcel.createStringArrayList()
        isdStations = parcel.createStringArrayList()
        units = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeStringList(sources)
        parcel.writeStringList(isdStations)
        parcel.writeString(units)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Flags> {
        override fun createFromParcel(parcel: Parcel): Flags {
            return Flags(parcel)
        }

        override fun newArray(size: Int): Array<Flags?> {
            return arrayOfNulls(size)
        }
    }

}
