package BOJ.Greedy

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    var (n, k) = br.readLine().split(" ").map { it.toInt() }
    val list = ArrayList<Int>()
    for (i in 1..n) {
        list.add(br.readLine().toInt())
    }
    list.sortDescending()

    var answer = 0
    var index = 0

    while (k != 0) {
        if (k / list[index] > 0) {
            answer += k / list[index]
            k %= list[index]
        }
        index += 1
    }

    print(answer)
}