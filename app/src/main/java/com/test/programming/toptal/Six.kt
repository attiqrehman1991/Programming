package com.test.programming.toptal

import android.annotation.SuppressLint
import java.util.*
import kotlin.collections.HashSet

@SuppressLint("NewApi")
fun main() {
//    println( solve(intArrayOf(2, 1, 3), 2))
//            println(solve(intArrayOf(0, 4, 3, -1), 2))
//            println(solve(intArrayOf(2, 1, 4), 3))

    val T = arrayOf(
        "test1a",
        "test2",
        "test1c",
        "test1b",
         "test3"
    )

    val R = arrayOf(
        "Wrong Answer",
        "OK",
        "Runtime Error",
        "OK",
        "Time Limit Exceeded"
    )
//    println(solution1(T, R))
//    println( solution(T, R))

    println( solution(intArrayOf(7, 3, 7, 3, 1, 3, 4, 1)) )
    println( solution(intArrayOf(2, 1, 1, 3, 2, 1, 1, 3)) )
    println( solution(intArrayOf(7, 5, 2, 7, 2, 7, 4, 7)) )
}

fun solution(A: IntArray): Int {

    val set = HashSet<Int>()
    for(se in A) {
        set.add(se)
    }

    var startingIndex = 0
    var endingIndex = 0
    var visitedCounter = 0
    val locationVisitedCounter = IntArray(A.size)
    locationVisitedCounter[A[0] - 1] = 0
    for (i in 1 until A.size) {
        val locationIndex = A[i] - 1
        locationVisitedCounter[locationIndex]++
        if (A[i] == A[i - 1]) {
            continue
        }
        visitedCounter++
        endingIndex = i
        while (locationVisitedCounter[A[startingIndex] - 1] > 1 && visitedCounter == set.size) {
            locationVisitedCounter[A[startingIndex] - 1]--
            visitedCounter++
        }
    }
    return endingIndex - startingIndex
}
class Pair1(val a: Int, val b: Int) {
}
var inf = Int.MIN_VALUE
fun minimumDays(
    N: Int, D1: IntArray,
    D2: IntArray
): Int {
    // initialising ans to
    // least value possible
    var ans: Int = -inf

    val list = arrayListOf<Pair1>()

//    val list: ArrayList<Pair<Int, Int>>> = ArrayList<Pair>()
    for (i in 0 until N)
        list.add(Pair1(D1[i], D2[i]))

    // sort by first i.e D(i)
    Collections.sort(list, Comparator<Pair1> { p1, p2 -> p1.a - p2.b })

// Calculate the minimum possible days
    for (i in 0 until N) {
        ans = if (list[i].b >= ans) list[i].b else list[i].a
    }
    return ans
}

fun solut2ion(T: Array<String>, R: Array<String>): Int {
    return T.asSequence()
        .map { Regex("\\w+(\\d+)").find(it) }
        .filterNotNull()
        .map { it.destructured.component1().toInt() }
        .zip(R.asSequence().map { it == "OK" })
        .groupingBy { it.first }
        .fold(true) { acc, el -> acc && el.second }
        .let { map -> map.values.count { it } * 100 / map.size }
}

fun solution(T: Array<String>, R: Array<String>): Int {
    val resylt=  T.asSequence()
        .map { test ->
            val regex  = "\\w+(\\d+)"
            val matcher:Regex = Regex(regex)
            matcher.find(test)
        }
        .filterNotNull()
        .map { matcherResult:MatchResult ->
            val result = matcherResult.destructured
            val comp = result.component1()
            comp.toInt()
        }
        .zip(R. asSequence().map { res ->
            res == "OK" }
        )
        .groupingBy { pair:Pair<Int, Boolean> ->
            pair.first
        }
        .fold(true) { testResult:Boolean, pair:Pair<Int, Boolean> ->
            testResult && pair.second
        }
        .let { mapForValue:Map<Int, Boolean> ->
            mapForValue.values.count { result:Boolean ->
            result
                } * 100 / mapForValue.size
        }

    return resylt
}


//public fun solution(IntArray A):Int {
//
//    if (A.Length is 0 or 1) {
//        return A.Length;
//    }
//
//    var startingIndex = 0;
//    var endingIndex = 0;
//    var locationVisitedCounter = new int[A.Length];
//    locationVisitedCounter[A[0] - 1] = 1;
//
//    for (var i=1; i<A.Length; i++)
//    {
//        var locationIndex = A[i] - 1;
//
//        locationVisitedCounter[locationIndex]++;
//
//        if (A[i] == A[i - 1])
//        {
//            continue;
//        }
//
//        endingIndex=i;
//
//        while (locationVisitedCounter[A[startingIndex] - 1] > 1)
//        {
//            locationVisitedCounter[A[startingIndex] - 1]--;
//            startingIndex++;
//        }
//
//    }
//
//    return endingIndex - startingIndex + 1;
//}

fun solve(a: IntArray, S: Int): Int {
    val map: MutableMap<Int, Int> = HashMap()
    map[0] = 1
    var runningSum = 0
    var res = 0
    for((index, value) in a.withIndex()) {
        runningSum += value
        val key = runningSum - ((1 + index ) * S)
        res += mapValue(map, key)
        map[key] = mapValue(map, key) + 1
    }


    return res
}

private fun mapValue(map: MutableMap<Int, Int>, key: Int):Int {
    if(!map.containsKey(key))
        map[key] = 0
    return map[key]!!
}


//    public int solution(int[] A) {
//        float targetPolution = Arrays.stream(A).sum() / 2;
//        float filteredPolution = 0;
//        int totalFilters = 0;
//        A = A.OrderByDescending(c = > c).ToArray();
//        for (int i = 0; i < A.Length; i++) {
//            totalFilters++;
//            filteredPolution += (float) A[i] / 2;
//            if (filteredPolution >= targetPolution)
//                break;
//        }
//        return totalFilters;
//    }
//    int solve(int[] n) {
//        int count = 0;
//        int totalPollution = Arrays.stream(n).sum();
//        int halfPollution = totalPollution / 2; //I know I should have taken double but thought int wold work
//        long distinct = Arrays.stream(n).distinct().count();
//        if (distinct == 1l)
//            return n.length]
//        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
//        for (int a : n)
//            pq.add(a);
//        while (totalPollution >= halfPollution) {
//            int currnetPoll = pq.poll();
//            int halfVal = currentPoll / 2;
//            totalPollution -= halfVal;
//            count++;
//            pq.add(halfVal);
//
//        }
//        return count;
//    }
//    void peopleCars (int[] persons, int[] seats) {
//        int numberOfCars = 0;
//
//        int people = persons.reduce((previousValue, currentValue) => previousValue + currentValue, 0); //Calculate total number of persons
//
//        seats.sort((a,b) => {return b-a}); //Rearrange the total number of seats in each car in ascending order to fill the seats starting from the one that can take the most persons
//
//        while(people > 0) {
//            people -= seats[numberOfCars]; //subtract the numbers of seats of each car from the number of persons available. This will now leave us with the remaining people
//            numberOfCars += 1 //increment the number of cars to be used.
//        }
//        return numberOfCars
//    }