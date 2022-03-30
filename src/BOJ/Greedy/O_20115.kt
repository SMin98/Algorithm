package BOJ.Greedy

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val amount = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    amount.sortDescending()

    var sum: Double = 0.0
    for (i in 1 until amount.size) {
        sum += amount[i]
    }

    print(amount[0] + sum / 2)
}