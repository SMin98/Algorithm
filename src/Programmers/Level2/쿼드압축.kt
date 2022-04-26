package Programmers.Level2

private var one = 0
private var zero = 0

fun main() {
    val test = arrayOf(
        intArrayOf(1, 1, 0, 0),
        intArrayOf(1, 0, 0, 0),
        intArrayOf(1, 0, 0, 1),
        intArrayOf(1, 1, 1, 1)
    )

    print(Solution().solution(test))
}

class Solution {
    fun solution(arr: Array<IntArray>): MutableList<Int> {
        val answer: MutableList<Int> = mutableListOf<Int>()

        val n = arr.size
        find(0, 0, n, arr)

        answer.add(zero)
        answer.add(one)

        return answer
    }
}

private fun find(x: Int, y: Int, n: Int, arr: Array<IntArray>) {
    if (check(x, y, n, arr) == 1) {
        one += 1
        return
    } else if (check(x, y, n, arr) == 0) {
        zero += 1
        return
    }

    val new = n / 2
    find(x, y, new, arr)
    find(x, y + new, new, arr)
    find(x + new, y, new, arr)
    find(x + new, y + new, new, arr)

}

private fun check(x: Int, y: Int, n: Int, arr: Array<IntArray>): Int {
    val num = arr[x][y]
    for (i in x until x + n) {
        for (j in y until y + n) {
            if (num != arr[i][j]) {
                return 2
            }
        }
    }
    return num
}