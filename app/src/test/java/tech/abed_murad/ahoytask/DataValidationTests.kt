/*
 * Copyright (c) 2019 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 * distribute, sublicense, create a derivative work, and/or sell copies of the
 * Software in any work that is designed, intended, or marketed for pedagogical or
 * instructional purposes related to programming, coding, application development,
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works,
 * or sale is expressly withheld.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package tech.abed_murad.ahoytask

import org.junit.Assert
import org.junit.Test
import tech.abed_murad.ahoytask.util.*

class DataValidationTests {

    @Test
    fun whenConvertingTimeStampToString_ShouldReturnCorrectDateAsString() {
        val timeStamp:Long = 1612154102

        val dataAsString = timeStamp.getDay()

        Assert.assertEquals("getDay() Returned Should Be string Date", "01 February", dataAsString)

    }

    @Test
    fun whenConvertingTimeStampToTime_ShouldReturnCorrectTimeAsString() {
        val timeStamp:Long = 1612154102

        val timeAsString = timeStamp.getTime()

        Assert.assertEquals("getTime() Returned Should Be string time", "6:35 AM", timeAsString)

    }


    @Test
    fun whenConvertingToFahrenheit_ShouldReturnCorrectValue() {
        val centigrade:Double = 17.94

        val weatherInFahrenheit = centigrade.convertToFahrenheit().round(2)

        Assert.assertEquals("convertToFahrenheit() Returned Should Be Correct and rounded to two digits", 64.29, weatherInFahrenheit , 0.0)

    }


}