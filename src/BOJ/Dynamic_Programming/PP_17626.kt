package BOJ.Dynamic_Programming

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val dp = Array(n + 1) { 0 }
    dp[0] = 0
    dp[1] = 1

    for (i in 2..n) {
        var min = Integer.MAX_VALUE
        for (j in 1..i) {
            if (j * j > i) {
                break
            }
            min = kotlin.math.min(min, dp[i - j * j])
        }
        dp[i] = min + 1
    }

    print(dp[n])
}