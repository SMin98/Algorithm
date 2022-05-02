package BOJ.Binary_Search

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.pow

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toLong()
    var start: Long = 0
    var end = n
    var min = Long.MAX_VALUE

    while (start <= end) {
        val mid = (start + end) / 2
        val result = mid.toDouble().pow(2.0).toLong()

        if (result >= n) {
            min = mid
            end = mid - 1
        } else start = mid + 1
    }

    println(min)
}