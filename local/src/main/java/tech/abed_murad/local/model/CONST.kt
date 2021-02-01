package tech.abed_murad.local.model

import tech.abed_murad.domain.BuildConfig

object CONST {
    // Weather icon options
    var THUNDERSTORM = "Thunderstorm"
    var DRIZZLE = "Drizzle"
    var RAIN = "Rain"
    var SNOW = "Snow"
    var ATMOSPHERE = "Atmosphere"
    var CLEAR = "Clear"
    var CLOUDS = "Clouds"
    var EXTREME = "Extreme"


    // Urls
    const val URL_OPEN_WEATHER = BuildConfig.SERVER_URL


    // Arguments
    const val KEY_DAY_WEATHER = "dayWeatherArg"

    // Temperature Units.
    const val KEY_METRIC = "metric"
    const val KEY_IMPERIAL = "imperial"



}

