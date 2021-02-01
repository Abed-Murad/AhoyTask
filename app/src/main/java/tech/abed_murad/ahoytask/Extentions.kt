package tech.abed_murad.ahoytask

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import tech.abed_murad.ahoytask.CONST.ATMOSPHERE
import tech.abed_murad.ahoytask.CONST.CLEAR
import tech.abed_murad.ahoytask.CONST.CLOUDS
import tech.abed_murad.ahoytask.CONST.DRIZZLE
import tech.abed_murad.ahoytask.CONST.EXTREME
import tech.abed_murad.ahoytask.CONST.RAIN
import tech.abed_murad.ahoytask.CONST.SNOW
import tech.abed_murad.ahoytask.CONST.THUNDERSTORM
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.round


fun Context.toast(message: CharSequence) =
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()


fun String.getWeatherIcon() = when (this) {
    THUNDERSTORM -> R.mipmap.ic_atmosphere
    DRIZZLE -> R.mipmap.ic_drizzle
    RAIN -> R.mipmap.ic_rain
    SNOW -> R.mipmap.ic_snow
    ATMOSPHERE -> R.mipmap.ic_atmosphere
    CLEAR -> R.drawable.ic_sun
    CLOUDS -> R.mipmap.ic_cloudy
    EXTREME -> R.mipmap.ic_extreme
    else -> R.mipmap.ic_launcher
}


@SuppressLint("SimpleDateFormat")
fun Long.getDay(): String {
    return Date((this * 1000)).toDateStandard()
}

fun Long.getTime(): String {
    return Date((this * 1000)).toTimeStandardIn12HoursWithoutSeconds()
}

fun Date?.toDateStandard(): String {
    val pattern = "dd MMMM"
    return dateAsString(this, pattern)
}

fun Date?.toTimeStandardIn12HoursWithoutSeconds(): String {
    val pattern = "h:mm a"
    return dateAsString(this, pattern)
}


private fun dateAsString(date: Date?, pattern: String): String {
    val simpleDateFormat = SimpleDateFormat(pattern, Locale.getDefault())
    if (date != null)
        return simpleDateFormat.format(date)
    else
        throw NullPointerException("Date can't be null")
}


fun Double.convertToFahrenheit() = this * 9.0f / 5.0f + 32.0f

fun Double.round(decimals: Int): Double {
    var multiplier = 1.0
    repeat(decimals) { multiplier *= 10 }
    return round(this * multiplier) / multiplier
}
