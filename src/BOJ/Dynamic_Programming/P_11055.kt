package BOJ.Dynamic_Programming

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val list = br.readLine().split(" ").map { it.toInt() }
    val dp = Array(n) { 0 }
    var max = list.first()

    for (i in 0 until n) {
        dp[i] = list[i]
        for (j in 0 until i) {
            if (list[i] > list[j] && dp[i] < dp[j] + list[i]) {
                dp[i] = dp[j] + list[i]
            }
        }
        if (max < dp[i]) max = dp[i]
    }

    print(max)
}