package BOJ.Implementation

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val n = br.readLine().toInt()
    val find = br.readLine().toInt()
    var x = 0
    var y = 0

    val list = Array(n) { Array(n) { 0 } }
    var a = n / 2
    var b = n / 2
    var level = 1
    var cnt = 1

    while (true) {
        // ⬆
        for (i in 0 until level) {
            list[a][b] = cnt++
            a--
        }
        if (cnt - 1 == n * n) break
        // ➡
        for (i in 0 until level) {
            list[a][b] = cnt++
            b++
        }
        level++
        // ⬇
        for (i in 0 until level) {
            list[a][b] = cnt++
            a++
        }
        // ⬅
        for (i in 0 until level) {
            list[a][b] = cnt++
            b--
        }
        level++
    }

    list.forEachIndexed { i, r ->
        r.forEachIndexed { j, it ->
            sb.append("$it ")
            if (it == find) {
                x = i + 1
                y = j + 1
            }
        }
        sb.append("\n")
    }

    print(sb)
    print("$x $y")
}