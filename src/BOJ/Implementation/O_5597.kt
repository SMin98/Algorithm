package BOJ.Implementation

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val list = Array(31) { i -> i }
    for (i in 0 until 28) {
        val n = br.readLine().toInt()
        list[n] = 0
    }

    list.forEach {
        if (it != 0) {
            println(it)
        }
    }
}