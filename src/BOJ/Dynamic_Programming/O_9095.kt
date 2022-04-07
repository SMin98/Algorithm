package BOJ.Dynamic_Programming

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val t = br.readLine().toInt()
    val dp = Array(11) { 0 }
    dp[1] = 1
    dp[2] = 2
    dp[3] = 4
    for (i in 4 until dp.size) {
        dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3]
    }

    for (i in 1..t) {
        val n = br.readLine().toInt()
        println(dp[n])
    }
}