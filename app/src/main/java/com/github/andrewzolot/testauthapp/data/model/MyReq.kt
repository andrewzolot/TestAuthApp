package com.github.andrewzolot.testauthapp.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MyReq() : Parcelable {
    var cityID: Int = 0
    var tableName: String? = null

    @SerializedName("latitude")
    @Expose
    var latitude: Double? = null
    @SerializedName("longitude")
    @Expose
    var longitude: Double? = null
    @SerializedName("timezone")
    @Expose
    var timezone: String? = null
    @SerializedName("currently")
    @Expose
    var currently: Currently? = null
    @SerializedName("minutely")
    @Expose
    var minutely: Minutely? = null
    @SerializedName("hourly")
    @Expose
    var hourly: Hourly? = null
    @SerializedName("daily")
    @Expose
    var daily: Daily? = null
    @SerializedName("flags")
    @Expose
    var flags: Flags? = null
    @SerializedName("offset")
    @Expose
    var offset: Int? = null

    constructor(parcel: Parcel) : this() {
        cityID = parcel.readInt()
        tableName = parcel.readString()
        latitude = parcel.readValue(Double::class.java.classLoader) as? Double
        longitude = parcel.readValue(Double::class.java.classLoader) as? Double
        timezone = parcel.readString()
        offset = parcel.readValue(Int::class.java.classLoader) as? Int
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(cityID)
        parcel.writeString(tableName)
        parcel.writeValue(latitude)
        parcel.writeValue(longitude)
        parcel.writeString(timezone)
        parcel.writeValue(offset)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MyReq> {
        override fun createFromParcel(parcel: Parcel): MyReq {
            return MyReq(parcel)
        }

        override fun newArray(size: Int): Array<MyReq?> {
            return arrayOfNulls(size)
        }
    }
}
