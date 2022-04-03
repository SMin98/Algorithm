package BOJ.Dynamic_Programming

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val list = Array<Long>(n + 1) { 0 }
    list[1] = 1

    for (i in 2..n) {
        list[i] = list[i - 1] + list[i - 2]
    }
    print(list[n])
}