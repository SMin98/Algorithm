package BOJ.Dynamic_Programming

import java.io.BufferedReader
import java.io.InputStreamReader
import java.math.BigInteger

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val dp = Array(101) { Array(101) { BigInteger.ONE } }

    for (i in 2..100) {
        for (j in 1..i) {
            if (i == j) {
                dp[i][j] = BigInteger.ONE
            } else {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]
            }

        }
    }

    print(dp[n][m])
}