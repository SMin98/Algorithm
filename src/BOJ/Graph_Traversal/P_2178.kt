package BOJ.Graph_Traversal

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

private lateinit var list: Array<IntArray>
private lateinit var visit: Array<BooleanArray>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    list = Array(n) { IntArray(m) }
    visit = Array(n) { BooleanArray(m) }
    for (i in 0 until n) {
        val str = br.readLine().toCharArray()
        for (j in 0 until m) {
            list[i][j] = str[j].code - 48
        }
    }

    visit[0][0] = true
    bfs(n, m)
    print(list[n - 1][m - 1])
}

private fun bfs(n: Int, m: Int) {
    val x = 0
    val y = 0
    val dx = intArrayOf(-1, 0, 1, 0)
    val dy = intArrayOf(0, -1, 0, 1)
    val queue = LinkedList<dot>()
    queue.add(dot(x, y))

    while (queue.isNotEmpty()) {
        val current = queue.pollFirst()
        for (i in 0 until 4) {
            val cx = current.x + dx[i]
            val cy = current.y + dy[i]

            if (cx < 0 || cy < 0 || cx >= n || cy >= m) continue
            if (visit[cx][cy] || list[cx][cy] == 0) continue

            queue.add(dot(cx, cy))
            list[cx][cy] = list[current.x][current.y] + 1
            visit[cx][cy] = true
        }
    }
}

private data class dot(
    val x: Int, val y: Int
)