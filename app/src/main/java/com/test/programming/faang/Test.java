package com.test.programming.faang;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Test {

    public static void main(String[] args) {
        System.out.println("DDG");
    }

    public boolean canJum(int[] nums) {
        int lastGoodIndex = nums.length - 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastGoodIndex)
                lastGoodIndex = i;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());


        return lastGoodIndex == 0;
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

    public int solution(int[] A) {

//        if (A.length is 0 or 1) {
//            return A.Length;
//        }

        int startingIndex = 0;
        int endingIndex = 0;
        int[] locationVisitedCounter = new int[A.length];
        locationVisitedCounter[A[0] - 1] = 1;

        for (int i=1; i<A.length; i++)
        {
            int locationIndex = A[i] - 1;

            locationVisitedCounter[locationIndex]++;

            if (A[i] == A[i - 1])
            {
                continue;
            }

            endingIndex=i;

            while (locationVisitedCounter[A[startingIndex] - 1] > 1)
            {
                locationVisitedCounter[A[startingIndex] - 1]--;
                startingIndex++;
            }

        }

        return endingIndex - startingIndex + 1;
    }

//    public int solution(int[] A) {
//
//        if (A.Length is 0 or 1) {
//            return A.Length;
//        }
//
//        var startingIndex = 0;
//        var endingIndex = 0;
//        var locationVisitedCounter = new int[A.Length];
//        locationVisitedCounter[A[0] - 1] = 1;
//
//        for (var i=1; i<A.Length; i++)
//        {
//            var locationIndex = A[i] - 1;
//
//            locationVisitedCounter[locationIndex]++;
//
//            if (A[i] == A[i - 1])
//            {
//                continue;
//            }
//
//            endingIndex=i;
//
//            while (locationVisitedCounter[A[startingIndex] - 1] > 1)
//            {
//                locationVisitedCounter[A[startingIndex] - 1]--;
//                startingIndex++;
//            }
//
//        }
//
//        return endingIndex - startingIndex + 1;
//    }
}
