package tech.abed_murad.local

import com.chibatching.kotpref.KotprefModel

object GlobalUserInfo : KotprefModel() {
    var lat: String by stringPref("")
    var lon: String by stringPref("")
    var temperatureUnit: String by stringPref("imperial")
    var forecast_days_count by stringPref("17") // Number of days to forecast.
    var api_key by stringPref(BuildConfig.API_KEY)
    var currentDayTimeStamp by longPref(0) // used as a flag for updating the weather data.
}