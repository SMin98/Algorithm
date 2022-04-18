package BOJ.Two_Pointers

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, x) = br.readLine().split(" ").map { it.toInt() }
    val list = br.readLine().split(" ").map { it.toInt() }
    val sum = Array(n) { 0 }
    sum[0] = list[0]
    for (i in 1 until n) {
        sum[i] = sum[i - 1] + list[i]
    }

    var max = sum[x-1]
    var day = 1
    for (i in x until n) {
        if (max < sum[i] - sum[i - x]) {
            max = sum[i] - sum[i - x]
            day = 1
        } else if (max == sum[i] - sum[i - x]) {
            day += 1
        }
    }

    if (max == 0) {
        print("SAD")
    } else {
        println(max)
        println(day)
    }
}