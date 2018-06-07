package com.github.andrewzolot.testauthapp.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Datum_() : Parcelable{

    @SerializedName("time")
    @Expose
    var time: Int? = null
    @SerializedName("summary")
    @Expose
    var summary: String? = null
    @SerializedName("icon")
    @Expose
    var icon: String? = null
    @SerializedName("precipIntensity")
    @Expose
    var precipIntensity: Double? = null
    @SerializedName("precipProbability")
    @Expose
    var precipProbability: Double? = null
    @SerializedName("temperature")
    @Expose
    var temperature: Double? = null
    @SerializedName("apparentTemperature")
    @Expose
    var apparentTemperature: Double? = null
    @SerializedName("dewPoint")
    @Expose
    var dewPoint: Double? = null
    @SerializedName("humidity")
    @Expose
    var humidity: Double? = null
    @SerializedName("pressure")
    @Expose
    var pressure: Double? = null
    @SerializedName("windSpeed")
    @Expose
    var windSpeed: Double? = null
    @SerializedName("windGust")
    @Expose
    var windGust: Double? = null
    @SerializedName("windBearing")
    @Expose
    var windBearing: Double? = null
    @SerializedName("cloudCover")
    @Expose
    var cloudCover: Double? = null
    @SerializedName("uvIndex")
    @Expose
    var uvIndex: Double? = null
    @SerializedName("visibility")
    @Expose
    var visibility: Double? = null
    @SerializedName("ozone")
    @Expose
    var ozone: Double? = null
    @SerializedName("precipType")
    @Expose
    var precipType: String? = null

    constructor(parcel: Parcel) : this() {
        time = parcel.readValue(Int::class.java.classLoader) as? Int
        summary = parcel.readString()
        icon = parcel.readString()
        precipIntensity = parcel.readValue(Double::class.java.classLoader) as? Double
        precipProbability = parcel.readValue(Double::class.java.classLoader) as? Double
        temperature = parcel.readValue(Double::class.java.classLoader) as? Double
        apparentTemperature = parcel.readValue(Double::class.java.classLoader) as? Double
        dewPoint = parcel.readValue(Double::class.java.classLoader) as? Double
        humidity = parcel.readValue(Double::class.java.classLoader) as? Double
        pressure = parcel.readValue(Double::class.java.classLoader) as? Double
        windSpeed = parcel.readValue(Double::class.java.classLoader) as? Double
        windGust = parcel.readValue(Double::class.java.classLoader) as? Double
        windBearing = parcel.readValue(Double::class.java.classLoader) as? Double
        cloudCover = parcel.readValue(Double::class.java.classLoader) as? Double
        uvIndex = parcel.readValue(Double::class.java.classLoader) as? Double
        visibility = parcel.readValue(Double::class.java.classLoader) as? Double
        ozone = parcel.readValue(Double::class.java.classLoader) as? Double
        precipType = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(time)
        parcel.writeString(summary)
        parcel.writeString(icon)
        parcel.writeValue(precipIntensity)
        parcel.writeValue(precipProbability)
        parcel.writeValue(temperature)
        parcel.writeValue(apparentTemperature)
        parcel.writeValue(dewPoint)
        parcel.writeValue(humidity)
        parcel.writeValue(pressure)
        parcel.writeValue(windSpeed)
        parcel.writeValue(windGust)
        parcel.writeValue(windBearing)
        parcel.writeValue(cloudCover)
        parcel.writeValue(uvIndex)
        parcel.writeValue(visibility)
        parcel.writeValue(ozone)
        parcel.writeString(precipType)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Datum_> {
        override fun createFromParcel(parcel: Parcel): Datum_ {
            return Datum_(parcel)
        }

        override fun newArray(size: Int): Array<Datum_?> {
            return arrayOfNulls(size)
        }
    }

}
