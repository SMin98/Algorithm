package BOJ.Graph_Traversal

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

private lateinit var list: Array<IntArray>
private lateinit var visit: Array<BooleanArray>
private lateinit var queue: LinkedList<node>
private var max = 0
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (m, n) = br.readLine().split(" ").map { it.toInt() }
    list = Array(n) { IntArray(m) }
    visit = Array(n) { BooleanArray(m) }
    queue = LinkedList()

    for (i in 0 until n) {
        br.readLine().split(" ").map { it.toInt() }.forEachIndexed { j, a ->
            list[i][j] = a
            if (a == 1) {
                queue.add(node(i, j))
            }
        }
    }

    while (queue.isEmpty().not()) {
        val node = queue.poll()
        find(node.x, node.y, n, m)
    }

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (list[i][j] == 0) {
                print(-1)
                return
            }
        }
    }
    if (max == 0) print(max)
    else print(max - 1)

}

private fun find(x: Int, y: Int, n: Int, m: Int) {
    visit[x][y] = true
    val dx = intArrayOf(-1, 0, 1, 0)
    val dy = intArrayOf(0, -1, 0, 1)

    for (i in 0 until 4) {
        val cx = dx[i] + x
        val cy = dy[i] + y
        if (cx < 0 || cy < 0 || cx >= n || cy >= m) continue
        if (visit[cx][cy] || list[cx][cy] == -1||list[cx][cy] == 1) continue
        list[cx][cy] = list[x][y] + 1
        max = list[x][y] + 1
        queue.add(node(cx, cy))
        visit[cx][cy] = true
    }
}

private data class node(
    val x: Int,
    val y: Int
)