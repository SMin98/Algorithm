package BOJ.Dynamic_Programming

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Integer.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val dp = Array(n + 1) { 0 }

    for (i in 2..n) {
        dp[i] = dp[i - 1] + 1

        if (i % 3 == 0) {
            dp[i] = min(dp[i], dp[i / 3] + 1)
        }
        if (i % 2 == 0) {
            dp[i] = min(dp[i], dp[i / 2] + 1)
        }
    }
    print(dp[n])
}
