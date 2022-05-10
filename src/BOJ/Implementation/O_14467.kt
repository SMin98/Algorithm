package BOJ.Implementation

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    var cnt = 0
    val list = Array<Int?>(n + 1) { null }
    for (i in 0 until n) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }

        if (list[a] != null && list[a] != b) {
            cnt += 1
        }
        list[a] = b
    }

    print(cnt)
}