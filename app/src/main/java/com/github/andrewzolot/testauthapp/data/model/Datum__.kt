package com.github.andrewzolot.testauthapp.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Datum__() : Parcelable {

    @SerializedName("time")
    @Expose
    var time: Int? = null
    @SerializedName("summary")
    @Expose
    var summary: String? = null
    @SerializedName("icon")
    @Expose
    var icon: String? = null
    @SerializedName("sunriseTime")
    @Expose
    var sunriseTime: Int? = null
    @SerializedName("sunsetTime")
    @Expose
    var sunsetTime: Int? = null
    @SerializedName("moonPhase")
    @Expose
    var moonPhase: Double? = null
    @SerializedName("precipIntensity")
    @Expose
    var precipIntensity: Double? = null
    @SerializedName("precipIntensityMax")
    @Expose
    var precipIntensityMax: Double? = null
    @SerializedName("precipIntensityMaxTime")
    @Expose
    var precipIntensityMaxTime: Int? = null
    @SerializedName("precipProbability")
    @Expose
    var precipProbability: Double? = null
    @SerializedName("precipType")
    @Expose
    var precipType: String? = null
    @SerializedName("temperatureHigh")
    @Expose
    var temperatureHigh: Double? = null
    @SerializedName("temperatureHighTime")
    @Expose
    var temperatureHighTime: Int? = null
    @SerializedName("temperatureLow")
    @Expose
    var temperatureLow: Double? = null
    @SerializedName("temperatureLowTime")
    @Expose
    var temperatureLowTime: Int? = null
    @SerializedName("apparentTemperatureHigh")
    @Expose
    var apparentTemperatureHigh: Double? = null
    @SerializedName("apparentTemperatureHighTime")
    @Expose
    var apparentTemperatureHighTime: Int? = null
    @SerializedName("apparentTemperatureLow")
    @Expose
    var apparentTemperatureLow: Double? = null
    @SerializedName("apparentTemperatureLowTime")
    @Expose
    var apparentTemperatureLowTime: Int? = null
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
    @SerializedName("windGustTime")
    @Expose
    var windGustTime: Int? = null
    @SerializedName("windBearing")
    @Expose
    var windBearing: Double? = null
    @SerializedName("cloudCover")
    @Expose
    var cloudCover: Double? = null
    @SerializedName("uvIndex")
    @Expose
    var uvIndex: Double? = null
    @SerializedName("uvIndexTime")
    @Expose
    var uvIndexTime: Int? = null
    @SerializedName("visibility")
    @Expose
    var visibility: Double? = null
    @SerializedName("ozone")
    @Expose
    var ozone: Double? = null
    @SerializedName("temperatureMin")
    @Expose
    var temperatureMin: Double? = null
    @SerializedName("temperatureMinTime")
    @Expose
    var temperatureMinTime: Int? = null
    @SerializedName("temperatureMax")
    @Expose
    var temperatureMax: Double? = null
    @SerializedName("temperatureMaxTime")
    @Expose
    var temperatureMaxTime: Int? = null
    @SerializedName("apparentTemperatureMin")
    @Expose
    var apparentTemperatureMin: Double? = null
    @SerializedName("apparentTemperatureMinTime")
    @Expose
    var apparentTemperatureMinTime: Int? = null
    @SerializedName("apparentTemperatureMax")
    @Expose
    var apparentTemperatureMax: Double? = null
    @SerializedName("apparentTemperatureMaxTime")
    @Expose
    var apparentTemperatureMaxTime: Int? = null

    constructor(parcel: Parcel) : this() {
        time = parcel.readValue(Int::class.java.classLoader) as? Int
        summary = parcel.readString()
        icon = parcel.readString()
        sunriseTime = parcel.readValue(Int::class.java.classLoader) as? Int
        sunsetTime = parcel.readValue(Int::class.java.classLoader) as? Int
        moonPhase = parcel.readValue(Double::class.java.classLoader) as? Double
        precipIntensity = parcel.readValue(Double::class.java.classLoader) as? Double
        precipIntensityMax = parcel.readValue(Double::class.java.classLoader) as? Double
        precipIntensityMaxTime = parcel.readValue(Int::class.java.classLoader) as? Int
        precipProbability = parcel.readValue(Double::class.java.classLoader) as? Double
        precipType = parcel.readString()
        temperatureHigh = parcel.readValue(Double::class.java.classLoader) as? Double
        temperatureHighTime = parcel.readValue(Int::class.java.classLoader) as? Int
        temperatureLow = parcel.readValue(Double::class.java.classLoader) as? Double
        temperatureLowTime = parcel.readValue(Int::class.java.classLoader) as? Int
        apparentTemperatureHigh = parcel.readValue(Double::class.java.classLoader) as? Double
        apparentTemperatureHighTime = parcel.readValue(Int::class.java.classLoader) as? Int
        apparentTemperatureLow = parcel.readValue(Double::class.java.classLoader) as? Double
        apparentTemperatureLowTime = parcel.readValue(Int::class.java.classLoader) as? Int
        dewPoint = parcel.readValue(Double::class.java.classLoader) as? Double
        humidity = parcel.readValue(Double::class.java.classLoader) as? Double
        pressure = parcel.readValue(Double::class.java.classLoader) as? Double
        windSpeed = parcel.readValue(Double::class.java.classLoader) as? Double
        windGust = parcel.readValue(Double::class.java.classLoader) as? Double
        windGustTime = parcel.readValue(Int::class.java.classLoader) as? Int
        windBearing = parcel.readValue(Double::class.java.classLoader) as? Double
        cloudCover = parcel.readValue(Double::class.java.classLoader) as? Double
        uvIndex = parcel.readValue(Double::class.java.classLoader) as? Double
        uvIndexTime = parcel.readValue(Int::class.java.classLoader) as? Int
        visibility = parcel.readValue(Double::class.java.classLoader) as? Double
        ozone = parcel.readValue(Double::class.java.classLoader) as? Double
        temperatureMin = parcel.readValue(Double::class.java.classLoader) as? Double
        temperatureMinTime = parcel.readValue(Int::class.java.classLoader) as? Int
        temperatureMax = parcel.readValue(Double::class.java.classLoader) as? Double
        temperatureMaxTime = parcel.readValue(Int::class.java.classLoader) as? Int
        apparentTemperatureMin = parcel.readValue(Double::class.java.classLoader) as? Double
        apparentTemperatureMinTime = parcel.readValue(Int::class.java.classLoader) as? Int
        apparentTemperatureMax = parcel.readValue(Double::class.java.classLoader) as? Double
        apparentTemperatureMaxTime = parcel.readValue(Int::class.java.classLoader) as? Int
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(time)
        parcel.writeString(summary)
        parcel.writeString(icon)
        parcel.writeValue(sunriseTime)
        parcel.writeValue(sunsetTime)
        parcel.writeValue(moonPhase)
        parcel.writeValue(precipIntensity)
        parcel.writeValue(precipIntensityMax)
        parcel.writeValue(precipIntensityMaxTime)
        parcel.writeValue(precipProbability)
        parcel.writeString(precipType)
        parcel.writeValue(temperatureHigh)
        parcel.writeValue(temperatureHighTime)
        parcel.writeValue(temperatureLow)
        parcel.writeValue(temperatureLowTime)
        parcel.writeValue(apparentTemperatureHigh)
        parcel.writeValue(apparentTemperatureHighTime)
        parcel.writeValue(apparentTemperatureLow)
        parcel.writeValue(apparentTemperatureLowTime)
        parcel.writeValue(dewPoint)
        parcel.writeValue(humidity)
        parcel.writeValue(pressure)
        parcel.writeValue(windSpeed)
        parcel.writeValue(windGust)
        parcel.writeValue(windGustTime)
        parcel.writeValue(windBearing)
        parcel.writeValue(cloudCover)
        parcel.writeValue(uvIndex)
        parcel.writeValue(uvIndexTime)
        parcel.writeValue(visibility)
        parcel.writeValue(ozone)
        parcel.writeValue(temperatureMin)
        parcel.writeValue(temperatureMinTime)
        parcel.writeValue(temperatureMax)
        parcel.writeValue(temperatureMaxTime)
        parcel.writeValue(apparentTemperatureMin)
        parcel.writeValue(apparentTemperatureMinTime)
        parcel.writeValue(apparentTemperatureMax)
        parcel.writeValue(apparentTemperatureMaxTime)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Datum__> {
        override fun createFromParcel(parcel: Parcel): Datum__ {
            return Datum__(parcel)
        }

        override fun newArray(size: Int): Array<Datum__?> {
            return arrayOfNulls(size)
        }
    }

}
