package tech.abed_murad.ahoytask

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import tech.abed_murad.ahoytask.CONST.ATMOSPHERE
import tech.abed_murad.ahoytask.CONST.CLEAR
import tech.abed_murad.ahoytask.CONST.CLOUDS
import tech.abed_murad.ahoytask.CONST.DRIZZLE
import tech.abed_murad.ahoytask.CONST.EXTREME
import tech.abed_murad.ahoytask.CONST.RAIN
import tech.abed_murad.ahoytask.CONST.SNOW
import tech.abed_murad.ahoytask.CONST.THUNDERSTORM


fun AppCompatActivity.toast(message: CharSequence) =
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()


fun String.getImageIcon() = when (this) {
    THUNDERSTORM -> R.mipmap.ic_atmosphere
    DRIZZLE -> R.mipmap.ic_drizzle
    RAIN -> R.mipmap.ic_rain
    SNOW -> R.mipmap.ic_snow
    ATMOSPHERE -> R.mipmap.ic_atmosphere
    CLEAR -> R.mipmap.ic_clear
    CLOUDS -> R.mipmap.ic_cloudy
    EXTREME -> R.mipmap.ic_extreme
    else -> R.mipmap.ic_launcher
}
