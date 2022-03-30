package BOJ.Greedy

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val list = br.readLine().split(" ").map { it.toLong() }.toLongArray()
    list.sort()

    var max: Long = 0
    if (n % 2 == 0) {
        for (i in 0 until n / 2) {
            max = max(max, list[i] + list[n - 1 - i])
        }
    } else {
        max = list[n - 1]
        for (i in 0 until (n - 1) / 2) {
            max = max(max, list[i] + list[n - 2 - i])
        }
    }

    print(max)
}