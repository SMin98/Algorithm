package BOJ.Two_Pointers

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val list = br.readLine().split(" ").map { it.toInt() }
    val a = Array(100001) { 0 }
    a[list[0]] += 1
    var len = 0
    var s = 0
    var e = 1
    while (e < n) {
        a[list[e]] += 1
        while (a[list[e]] > k) {
            a[list[s]] -= 1
            s += 1
        }
        len = max(len, e - s + 1)
        e += 1
    }
    print(len)
}