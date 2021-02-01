package tech.abed_murad.ahoytask.local.model

import com.chibatching.kotpref.KotprefModel

object GlobalUserInfo : KotprefModel() {
    var lat : String by stringPref("")
    var lon : String by stringPref("")
    var temperatureUnit by stringPref("metric")
    var forecast_days_count by stringPref("17")
    var api_key by stringPref("c9da7f4769c845195c654aa2c0d3f16b")
    var currentDayTimeStamp by longPref(0)
}