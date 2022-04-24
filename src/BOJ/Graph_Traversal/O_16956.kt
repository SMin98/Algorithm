package BOJ.Graph_Traversal

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (r, c) = br.readLine().split(" ").map { it.toInt() }
    val list = Array(r) { CharArray(c) }
    for (i in 0 until r) {
        list[i] = br.readLine().toCharArray()
    }

    list.forEachIndexed { index, chars ->
        chars.forEachIndexed { idx, c ->
            if (c == '.') {
                list[index][idx] = 'D'
            }
        }
    }

    val dx = intArrayOf(-1, 0, 1, 0)
    val dy = intArrayOf(0, -1, 0, 1)
    for (i in 0 until r) {
        for (j in 0 until c) {
            if (list[i][j] == 'W') {
                for (z in 0 until 4) {
                    val cx = i + dx[z]
                    val cy = j + dy[z]
                    if (cx < 0 || cy < 0 || cx >= r || cy >= c) continue
                    if (list[cx][cy] == 'S') {
                        print(0)
                        return
                    }
                }
            }
        }
    }
    println(1)
    list.forEach {
        println(it)
    }

}