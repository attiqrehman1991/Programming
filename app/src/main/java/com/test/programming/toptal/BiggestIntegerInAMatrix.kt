package com.test.programming.toptal

import java.util.*

fun main() {
	val nums =
		arrayOf(
			intArrayOf(9, 1, 1, 0, 7),
			intArrayOf(1, 0, 2, 1, 0),
			intArrayOf(1, 9, 1, 1, 0))
	println(solve(nums))
}

var res = 0
var dirs = arrayOf(intArrayOf(0, 1), intArrayOf(0, -1), intArrayOf(1, 0), intArrayOf(-1, 0))

private fun solve(nums: Array<IntArray>): Int {
	val lst: MutableList<IntArray> = ArrayList()
	var max = -1
	for (i in nums.indices) {
		for (j in 0 until nums[0].size) {
			if (nums[i][j] > max) {
				max = nums[i][j]
				lst.clear()
				lst.add(intArrayOf(i, j))
			} else if (nums[i][j] == max) {
				lst.add(intArrayOf(i, j))
			}
		}
	}
	for (l in lst) {
		val visited = Array(nums.size) {
			BooleanArray(
				nums[0].size
			)
		}
		dfs(nums, 0, visited, l[0], l[1], 4)
	}
	return res
}

private fun dfs(
	nums: Array<IntArray>,
	n: Int,
	visited: Array<BooleanArray>,
	i: Int,
	j: Int,
	k: Int
) {
	if (i < 0 || i >= nums.size || j < 0 || j >= nums[0].size || visited[i][j]) {
		return
	}
	if (k == 0) {
		res = Math.max(res, n)
		return
	}
	visited[i][j] = true
	for (d in dirs) {
		val ni = i + d[0]
		val nj = j + d[1]
		if (isValid(n)) dfs(nums, n * 10 + nums[i][j], visited, ni, nj, k - 1)
	}
	visited[i][j] = false
}

private fun isValid(n: Int): Boolean {
	val stkN: Stack<Int> = Stack()
	val stkG: Stack<Int> = Stack()
	var cN = n
	var cRes = res
	while (cN > 0) {
		stkN.push(cN % 10)
		cN /= 10
	}
	while (cRes > 0) {
		stkG.push(cRes % 10)
		cRes /= 10
	}
	if (stkN.isEmpty() || stkN.isEmpty()) return true
	while (!stkN.isEmpty() || stkG.isEmpty()) {
		if (stkG.isEmpty()) return true
		if (stkN.pop() < stkG.pop()) return false
	}
	return true
}