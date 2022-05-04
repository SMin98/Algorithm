package BOJ.Binary_Search

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val tree = br.readLine().split(" ").map { it.toInt() }.sorted()

    var s = 0
    var e = tree[n - 1]
    while (s < e) {
        val mid = (s + e) / 2
        var sum = 0L
        tree.forEach {
            if (it - mid > 0) sum += it - mid
        }
        if (m <= sum) s = mid + 1
        else e = mid
    }

    print(s - 1)
}

