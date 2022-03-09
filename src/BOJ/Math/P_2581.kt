package BOJ.Math

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val m = br.readLine().toInt()
    val n = br.readLine().toInt()

    val list = MutableList<Int>(n + 1) { i -> i }
    list[0] = 0
    list[1] = 0

    //####에라토스테네스의 체
    for (i in 2..n) {
        if (list[i] == 0) {
            continue
        }

        for (j in 2 * i..n step i) {
            list[j] = 0
        }
    }

    var sum = 0
    var min = 0

    for (z in m..n) {
        if (list[z] > 0) {
            sum += z
            if (min == 0) {
                min = z
            }
        }
    }

    if (sum == 0) {
        print(-1)
    } else {
        println(sum)
        println(min)
    }
}