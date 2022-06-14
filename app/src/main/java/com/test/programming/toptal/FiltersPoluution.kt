package com.test.programming.toptal

import android.annotation.SuppressLint
import java.util.*

@SuppressLint("NewApi")
fun main() {

    var people = intArrayOf(1,4,1)
    var sumPoeple = people.sum()

    var cars = intArrayOf(1,5, 1)
    cars.sortDescending()

    var peopleInCar = 0
    while(sumPoeple > 0) {
        sumPoeple -= cars[peopleInCar++]
    }

    println(peopleInCar)

    var N = intArrayOf(3, 0, 5)
    polutionFilter(N)
    polutionFilter2(N)

    N = intArrayOf(5,19,8,1)
    polutionFilter(N)
    polutionFilter2(N)

    N = intArrayOf(10, 10)
    polutionFilter(N)
    polutionFilter2(N)


//    var total = N.sum()
//    count = 0
//    half = total / 2
//    val distinct = N.distinct()
//    if (distinct.size == 1) {
//        println( N.size )
//    }
//    pq = PriorityQueue(Collections.reverseOrder<Int>())
//    N.forEach {
//        pq.add(it)
//
//        while (total >= half) {
//            var currentPoll = pq.poll()/2
//            total -= half
//            count++
//            pq.add(half)
//        }
//    }
//    println( count )
//
//
//    var targetPolution = N.sum()
//    var filteredP = 0
//    count = 0
//    N.sortDescending()
//    N.forEach {
//        count++
//        filteredP += it/2
//        if(filteredP >= targetPolution) {
//            println( count )
//        }
//    }
//    println ( count )
}

private fun polutionFilter(N: IntArray) {
    var count = 0
    val totalLength = N.sum()
    val half = totalLength / 2
    var controlled = 0.0

    var pq = PriorityQueue(Collections.reverseOrder<Double>())
    N.forEach {
        pq.add(it.toDouble())
    }

    while (half > controlled) {
        count++
        val factory1 = pq.poll()?.div(2)
        controlled += factory1!!
        pq.add(factory1)
    }
    println(count)
}



private fun polutionFilter2(N: IntArray) {
    var count = 0
    val totalLength = N.sum()
    val half = totalLength / 2
    var controlled = 0.0
    N.sortDescending()

    while (half > controlled) {
        count++
        val factory1 = N[0].toDouble().div(2)
        controlled += factory1
        N[0]= factory1.toInt()
        N.sortDescending()
    }
    println(count)
}


//int solve(int[] n){
//    int count = 0;
//    int totalPollution = Arrays.stream(n).sum();
//    int halfPollution = totalPollution/2; //I know I should have taken double but thought int wold work
//    long distinct =  Arrays.stream(n).distinct)().count();
//    if(distinct == 1l)
//        return  n; // this is the corner case where all factories pollute equally i.e [10,10]
//    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
//    for(int a:n)
//    pq.add(a);
//    while(totalPollution >= halfPollution){
//        int currnetPoll = pq.poll();
//        int halfVal = currentPoll/2;
//        totalPollution -= halfVal;
//        count++;
//        pq.add(halfVal);
//
//    }
//    return count;
//}