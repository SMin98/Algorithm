package BOJ.Dynamic_Programming

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val list = mutableListOf<Double>()
    val dp = Array<Double>(n) { 0.0 }
    for (i in 1..n) {
        list.add(br.readLine().toDouble())
    }
    dp[0] = list[0]
    for (i in 1 until n) {
        val num = list[i] * dp[i - 1]
        if (num > list[i]) {
            dp[i] = num
        } else dp[i] = list[i]
    }

    print(String.format("%.3f", dp.maxOrNull()))
}