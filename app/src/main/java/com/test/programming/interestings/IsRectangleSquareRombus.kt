package interestings

import kotlin.math.absoluteValue
import kotlin.math.sqrt

fun main() {
    // Square Points
//    val givenPoint1 = Point(10.0, 20.0)
//    val givenPoint2 = Point(20.0, 20.0)
//    val givenPoint3 = Point(10.0, 10.0)
//    val givenPoint4 = Point(20.0, 10.0)

    // Rectangle Points
    val givenPoint1 = Point(8.0, 20.0)
    val givenPoint2 = Point(16.0, 34.0)
    val givenPoint3 = Point(47.0, 16.0)
    val givenPoint4 = Point(39.0, 2.0)

    // Rombus Points
//    val givenPoint1 = Point(8.0, 0.0)
//    val givenPoint2 = Point(0.0, 6.0)
//    val givenPoint3 = Point(-8.0, 0.0)
//    val givenPoint4 = Point(0.0, -6.0)

    val diagonal1 = distanceBetweenPoints(givenPoint1, givenPoint4)
    val diagonal2 = distanceBetweenPoints(givenPoint2, givenPoint3)

    val diagonal12 = distanceBetweenPoints(givenPoint1, givenPoint2)
    val diagonal23 = distanceBetweenPoints(givenPoint2, givenPoint3)
    val diagonal34 = distanceBetweenPoints(givenPoint3, givenPoint4)
    val diagonal41 = distanceBetweenPoints(givenPoint4, givenPoint1)

    val slop1 = slopBetweenPoints(givenPoint1, givenPoint4)
    val slop2 = slopBetweenPoints(givenPoint2, givenPoint3)

    if (slop1 == slop2 && (diagonal12 == diagonal23) && (diagonal23 == diagonal34) && (diagonal34 == diagonal41) && (diagonal41 == diagonal12))
        println("It's Rombus")
    else if (diagonal1 == diagonal2 && slop1 == (slop2 * -1))
        println("It's Square")
    else if (diagonal1 == diagonal2 && slop1 == slop2)
        println("It's Rectanlge")
    else
        println("It's nothing")
}

fun distanceBetweenPoints(p1: Point, p2: Point): Double {
    val x2 = (p1.x - p2.x) * (p1.x - p2.x)
    val y2 = (p1.y - p2.y) * (p1.y - p2.y)
    return sqrt(x2 + y2)
}

fun slopBetweenPoints(p1: Point, p2: Point): Double {
    val y = p1.y - p2.y
    val x = p1.x - p2.x
    return y / x
}

class Point(var x: Double, var y: Double)