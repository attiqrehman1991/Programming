package com.test.programming.test

import android.annotation.SuppressLint
import java.util.*

fun main() {
    val phoneLog = """
        00:01:07,400-234-090
        00:05:01,701-080-080
        00:01:00,400-234-090
        """.trimIndent()
    println(totalCost(phoneLog))
}

@SuppressLint("NewApi")
fun totalCost(S: String): Int {

    //split the phoneLog into its individual rows
//    val logEntries = log.split("\\n".toRegex()).toTypedArray()

    // create a hashmap to store the phoneNumber and the total phone call duration for it
//    val phoneNumberDetails = HashMap<String, Int>()
//    for (record in logEntries) {
//        val details = record.split(",".toRegex()).toTypedArray()
//        val durationOfHours = Integer.valueOf(details[0].substring(0, 2)) * 3600
//        val durationOfMinutes = Integer.valueOf(details[0].substring(3, 5)) * 60
//        val durationOfSeconds = Integer.valueOf(details[0].substring(6, 8))
//        var totalDuration = durationOfHours + durationOfMinutes + durationOfSeconds
//
//        val lastTime = phoneNumberDetails.getOrDefault(details[1], 0)
//        phoneNumberDetails.put(details[1], totalDuration + lastTime)
//        // if we already have an entry for this phone number then add this total duration to the existing one else just add it
////        if (phoneNumberDetails.containsKey(details[1])) {
////            totalDuration += phoneNumberDetails[details[1]]!!
////            phoneNumberDetails[details[1]] = totalDuration
////        } else {
////            phoneNumberDetails[details[1]] = totalDuration
////        }
//    }

    val phoneCallLogs = S.split("\\n".toRegex()).toTypedArray()

    val phoneDetails = HashMap<String, Int>()
    phoneCallLogs.forEach {
        val time_phone_number_array = it.split(",".toRegex()).toTypedArray()
        val time_into_hr_min_ss = time_phone_number_array[0].split(":".toRegex()).toTypedArray()
        val totalTime = (time_into_hr_min_ss[0].toInt() * 60 * 60) +
                (time_into_hr_min_ss[1].toInt() * 60) +
                (time_into_hr_min_ss[2].toInt())

        val lastRecordedDuration = phoneDetails.getOrDefault(time_phone_number_array[1], 0)
        phoneDetails[time_phone_number_array[1]] = lastRecordedDuration + totalTime
    }

    var finalCost = 0
    phoneDetails.forEach { (_, value) ->
        val cost = costFunction(value)
        if(finalCost == 0)
            finalCost = cost
        else
            finalCost = Math.min(cost, finalCost)
    }
    return finalCost


//    var finalCost = 0
//    val topExpender = minHeap.poll()
//    finalCost = costFunction(topExpender, finalCost)
//    println("totalCose1 $finalCost")
//    return finalCost

    /* Finally we can evaluate the total cost of the phone bill.
		   Rules:
		   (i) For a phone call less than 5 minutes long charge 3 cents per second
		   (ii) For a phone call 5 minutes and longer charge 150 cents per started minute, so for a call of 5 minutes 2 seconds would be
		        charged as a 6 minute call i.e. 6 * 150 = 900 cents
		   (iii) All calls to the phone number with the longest total call duration are free. In the event that two phone numbers have the same total call duration use the one
		*/

//    var totalCost = 0
//    for ((key, value) in phoneNumberDetails.entries) {
//        if (key == maxPhoneNumber) continue
//        if (value > 300) {
//            totalCost += value / 60 * 150
//            if (value % 60 != 0) totalCost += 150
//        } else {
//            totalCost += value * 3
//        }
//    }
//    return totalCost
}

private fun costFunction(
    value:Int
): Int {
    var finalCost = 0
    if (value > 5 * 60) {
        finalCost += value / 60 * 150
        if (value % 60 != 0) finalCost += 150
    } else {
        finalCost += value * 3
    }
    return finalCost
}