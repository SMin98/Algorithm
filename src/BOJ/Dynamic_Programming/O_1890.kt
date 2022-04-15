package BOJ.Dynamic_Programming

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val list = Array(n) { List(n) { 0L } }
    val dp = Array(n) { Array(n) { 0L } }
    for (i in 0 until n) {
        list[i] = br.readLine().split(" ").map { it.toLong() }
    }

    dp[0][0] = 1
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (dp[i][j] == 0L || (i == n - 1 && j == n - 1)) continue

            val value = list[i][j]
            if (value + i < n) dp[(value + i).toInt()][j] += dp[i][j]
            if (value + j < n) dp[i][(value + j).toInt()] += dp[i][j]
        }
    }

    print(dp[n - 1][n - 1])
}