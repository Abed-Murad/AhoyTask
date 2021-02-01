package tech.abed_murad.ahoytask

import org.junit.Assert
import org.junit.Test
import tech.abed_murad.ahoytask.util.getWeatherIcon

class GeneralTests {

    @Test
    fun whenRequestIcon_shouldReturnCorrectIcon() {

        val weatherStatus = "Snow"

        val icon = weatherStatus.getWeatherIcon()

        Assert.assertEquals("Icon Returned Should Be ic_snow", R.mipmap.ic_snow, icon)

    }


}