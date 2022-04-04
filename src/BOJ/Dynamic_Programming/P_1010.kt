package BOJ.Dynamic_Programming

import java.io.BufferedReader
import java.io.InputStreamReader

private val list = Array(30) { IntArray(30) { 0 } }
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val t = br.readLine().toInt()
    for (i in 1..t) {
        val (n, m) = br.readLine().split(" ").map { it.toInt() }
        println(combi(m, n))
    }
}

private fun combi(m: Int, n: Int): Int {
    if (list[m][n] > 0) {
        return list[m][n]
    }

    if (m == n || n == 0) {
        list[m][n] = 1
        return 1
    }

    list[m][n] = combi(m - 1, n - 1) + combi(m - 1, n)
    return list[m][n]
}
