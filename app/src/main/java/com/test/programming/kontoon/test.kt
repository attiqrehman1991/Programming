package com.test.programming.kontoon

enum class Sport { HIKE, RUN, TOURING_BICYCLE, E_TOURING_BICYCLE }

data class Summary(val sport: Sport, val distance: Int)

fun main() {
    val sportStats = listOf(Summary(Sport.HIKE, 92),
        Summary(Sport.RUN, 77),
        Summary(Sport.TOURING_BICYCLE, 322),
        Summary(Sport.E_TOURING_BICYCLE, 656))

    // Write kotlin code to print the top sport by distance excluding eBikes.
    // println()

    sportStats
        .filterNot { summary ->
            summary.sport == Sport.E_TOURING_BICYCLE
        }
        .maxByOrNull { summary ->
            summary.distance
        }
        ?.let { summary ->
            println("${summary.sport} is printed top with distance ${summary.distance}")
        }
}