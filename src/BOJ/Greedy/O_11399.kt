package BOJ.Greedy

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val list = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    var sum = 0

    list.sort()
    var size = list.size
    for (i in 0 until n) {
        sum += list[i] * size
        size -= 1
    }

    print(sum)
}