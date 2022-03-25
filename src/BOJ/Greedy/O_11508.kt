package BOJ.Greedy

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val list = ArrayList<Int>()

    var sum = 0

    for (i in 1..n) {
        list.add(br.readLine().toInt())
    }

    list.sortDescending()
    list.add(0, 0)
    for (i in 1..n) {
        if (i % 3 == 0) {
            continue
        }
        sum += list[i]
    }

    print(sum)
}