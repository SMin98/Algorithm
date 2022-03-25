package BOJ.Greedy

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val list = ArrayList<Int>()
    var sum: Long = 0

    for (i in 1..n) {
        list.add(br.readLine().toInt())
    }

    list.sortDescending()
    for (i in 0 until n) {
        val num = list[i] - i
        if (num > 0) {
            sum += num
        }
    }

    print(sum)
}