package BOJ.Graph_Traversal

import java.io.BufferedReader
import java.io.InputStreamReader

private lateinit var list: Array<IntArray>
private lateinit var visit: Array<BooleanArray>
private var cnt = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    list = Array(n) { IntArray(n) }
    visit = Array(n) { BooleanArray(n) }
    val answer = ArrayList<Int>()

    for (i in 0 until n) {
        val str = br.readLine().toCharArray()
        for (j in 0 until n) {
            list[i][j] = str[j].code - 48
        }
    }

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (visit[i][j] || list[i][j] == 0) continue
            cnt = 1
            find(i, j, n)
            answer.add(cnt)
        }
    }

    println(answer.size)
    answer.sorted().forEach {
        println(it)
    }
}

private fun find(x: Int, y: Int, n: Int) {
    visit[x][y] = true
    val dx = intArrayOf(-1, 0, 1, 0)
    val dy = intArrayOf(0, -1, 0, 1)

    for (i in 0 until 4) {
        val cx = dx[i] + x
        val cy = dy[i] + y

        if (cx < 0 || cy < 0 || cx >= n || cy >= n) continue
        if (list[cx][cy] == 0 || visit[cx][cy]) continue
        find(cx, cy, n)
        cnt += 1
    }
}