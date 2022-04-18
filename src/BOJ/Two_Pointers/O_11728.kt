package BOJ.Two_Pointers

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val a = br.readLine().split(" ").map { it.toInt() }
    val b = br.readLine().split(" ").map { it.toInt() }

    var i = 0
    var j = 0
    while (i < n && j < m) {
        if (a[i] < b[j]) {
            sb.append("${a[i]} ")
            i += 1
        } else {
            sb.append("${b[j]} ")
            j += 1
        }
    }
    while (i < n) {
        sb.append("${a[i]} ")
        i += 1
    }
    while (j < m) {
        sb.append("${b[j]} ")
        j += 1
    }
    print(sb)
}