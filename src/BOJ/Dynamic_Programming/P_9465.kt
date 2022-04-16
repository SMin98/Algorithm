package BOJ.Dynamic_Programming

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val t = br.readLine().toInt()
    for (i in 1..t) {
        val n = br.readLine().toInt()
        val list = Array(2) { List(n) { 0 } }
        val dp = Array(2) { Array(n + 1) { 0 } }
        for (j in 0 until 2) {
            list[j] = br.readLine().split(" ").map { it.toInt() }
        }

        dp[0][0] = 0
        dp[1][0] = 0
        dp[0][1] = list[0][0]
        dp[1][1] = list[1][0]
        for (j in 2 .. n) {
            dp[0][j] = max(dp[1][j - 2], dp[1][j - 1]) + list[0][j - 1]
            dp[1][j] = max(dp[0][j - 2], dp[0][j - 1]) + list[1][j - 1]
        }

        println(max(dp[0][n], dp[1][n]))
    }
}