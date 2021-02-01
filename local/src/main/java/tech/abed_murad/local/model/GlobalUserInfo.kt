package tech.abed_murad.local.model

import com.chibatching.kotpref.KotprefModel
import tech.abed_murad.domain.BuildConfig

object GlobalUserInfo : KotprefModel() {
    var lat: String by stringPref("")
    var lon: String by stringPref("")
    var temperatureUnit: String by stringPref("imperial")
    var forecast_days_count by stringPref("17")
    var api_key by stringPref(BuildConfig.API_KEY)
    var currentDayTimeStamp by longPref(0)
}