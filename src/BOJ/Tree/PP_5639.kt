package BOJ.Tree

import java.io.BufferedReader
import java.io.InputStreamReader

val tree = mutableListOf<Int>()

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    for (i in 0..10000) {
        val read = br.readLine() ?: break
        tree.add(read.toInt())
    }

    post(0, tree.size - 1)
}

fun post(start: Int, end: Int) {
    if (start > end) {
        return
    }

    var mid = start + 1
    while (mid <= end && tree[start] > tree[mid]) {
        mid++
    }
    post(start + 1, mid - 1)
    post(mid, end)
    println(tree[start])
}
