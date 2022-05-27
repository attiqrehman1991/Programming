package com.test.programming.array

import java.util.*
import kotlin.Comparator

fun main() {
    val files = arrayOf(
        "Spectrum_1b.txt",
        "Spectrum_1a1.txt",
        "Spectrum_9990.txt",
        "ABC_9990.txt",
        "Spectrum_14.txt",
        "Spectrum_19.txt",
        "Spectrum_1z.txt",
        "Spectrum_2.txt",
        "Spectrum_1000.txt",
        "Spectrum_7.txt",
        "Spectrum_999.txt",
        "DEF_999.txt",
        "Spectrum_9991.txt"
    )

    val sortedData = files.sortedWith(object : Comparator<String> {
        override fun compare(p0: String, p1: String): Int {
            val n1 = extractNumber(p0)
            val n2 = extractNumber(p1)
            return n1 - n2
        }

//        private fun extractNumber(name: String): Int {
//            val num = name.replace("\\D".toRegex(), "")
//            // return 0 if no digits found
//            return if (num.isEmpty()) 0 else Integer.parseInt(num)
//        }

        private fun extractNumber(name: String): Int {
            var i = 0
            i = try {
                val s = name.indexOf('_') + 1
                val e = name.lastIndexOf('.')
                val number = name.substring(s, e)
                number.toInt()
            } catch (e: Exception) {
                0 // if filename does not match the format
                // then default to 0
            }
            return i
        }

    })




    for (f in sortedData)
        println(f)
    val sorted =sortedData.sorted()
    for (f in sorted)
        println(f)

}
//
//fun sortByNumber(files: Array<String?>): Array<String> {
//
//
//    Arrays.sort(files, object : Comparator<String> {
//        fun compare(o1: String, o2: String): Int {
//            val n1 = extractNumber(o1)
//            val n2 = extractNumber(o2)
//            return n1 - n2
//        }
//
//        private fun extractNumber(name: String): Int {
//            var i = 0
//            i = try {
//                val s = name.indexOf('_') + 1
//                val e = name.lastIndexOf('.')
//                val number = name.substring(s, e)
//                number.toInt()
//            } catch (e: Exception) {
//                0 // if filename does not match the format
//                // then default to 0
//            }
//            return i
//        }
//    })
//    val output = arrayOfNulls<String>(files.size)
//    for (i in files.indices) {
//        output[i] = files[i]
//    }
//    return output
//}