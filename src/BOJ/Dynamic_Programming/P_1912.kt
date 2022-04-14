package BOJ.Dynamic_Programming

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Integer.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val list = br.readLine().split(" ").map { it.toInt() }
    val dp = Array(n) { 0 }
    dp[0] = list[0]

    for (i in 1 until n) {
        dp[i] = max(list[i], list[i] + dp[i - 1])
    }
    print(dp.maxOrNull())
}