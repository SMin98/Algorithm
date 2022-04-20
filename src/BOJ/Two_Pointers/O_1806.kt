package BOJ.Two_Pointers

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, s) = br.readLine().split(" ").map { it.toInt() }
    val list = br.readLine().split(" ").map { it.toInt() }

    var len = 100001
    var start = 0
    var end = 0
    var sum = 0
    while (true) {
        if (sum >= s) {
            sum -= list[start]
            len = min(len, end - start)
            start += 1
        } else if (end == n) {
            break
        } else {
            sum += list[end]
            end += 1
        }
    }
    if (len == 100001) {
        print(0)
    } else {
        print(len)
    }
}