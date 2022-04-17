package BOJ.Dynamic_Programming

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val time = Array(n + 1) { 0 }
    val price = Array(n + 1) { 0 }
    for (i in 1..n) {
        val (t, p) = br.readLine().split(" ").map { it.toInt() }
        time[i] = t
        price[i] = p
    }

    val dp = Array(n + 2) { 0 }
    for (i in 1..n) {
        val next = i + time[i]
        if (next <= n + 1) {
            dp[next] = max(dp[i] + price[i], dp[next])
        }
        dp[i + 1] = max(dp[i], dp[i + 1])
    }

    print(dp[n + 1])
}