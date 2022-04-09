package BOJ.Dynamic_Programming

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    //마지막 발판을 밟기 위해
    //경우의수 2개 -> 전발판, 전전발판 -> 최댓값

    val n = br.readLine().toInt()
    val dp = Array(n + 1) { 0 }
    val stair = Array(n + 1) { 0 }
    for (i in 1..n) {
        stair[i] = br.readLine().toInt()
    }

    for (i in 1..n) {
        when (i) {
            1 -> dp[1] = stair[1]
            2 -> dp[2] = stair[1] + stair[2]
            3 -> dp[3] = max(stair[1] + stair[3], stair[2] + stair[3])
            else -> {
                dp[i] = max(dp[i - 3] + stair[i - 1] + stair[i], dp[i - 2] + stair[i])
            }
        }
    }

    print(dp[n])
}