package BOJ.Dynamic_Programming

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val list = br.readLine().split(" ").map { it.toInt() }
    val dp = Array(n + 1) { 1 }

    for (i in 0 until n) {
        for (j in 0 until i) {
            if (list[i] > list[j]) {
                dp[i] = max(dp[i], dp[j] + 1)
            }
        }
    }

    print(dp.maxOrNull())
}