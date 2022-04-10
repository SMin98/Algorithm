package BOJ.Dynamic_Programming

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val dp = Array(n + 1) { 1 }

    for (i in 1..n) {
        when (i) {
            1 -> dp[i] = 1
            2 -> dp[i] = 3
            else -> {
                dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007
            }
        }
    }

    print(dp[n])
}