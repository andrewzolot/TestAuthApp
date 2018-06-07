package com.github.andrewzolot.testauthapp.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Datum() : Parcelable {

    @SerializedName("time")
    @Expose
    var time: Int? = null
    @SerializedName("precipIntensity")
    @Expose
    var precipIntensity: Double? = null
    @SerializedName("precipProbability")
    @Expose
    var precipProbability: Double? = null

    constructor(parcel: Parcel) : this() {
        time = parcel.readValue(Int::class.java.classLoader) as? Int
        precipIntensity = parcel.readValue(Double::class.java.classLoader) as? Double
        precipProbability = parcel.readValue(Double::class.java.classLoader) as? Double
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(time)
        parcel.writeValue(precipIntensity)
        parcel.writeValue(precipProbability)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Datum> {
        override fun createFromParcel(parcel: Parcel): Datum {
            return Datum(parcel)
        }

        override fun newArray(size: Int): Array<Datum?> {
            return arrayOfNulls(size)
        }
    }

}
