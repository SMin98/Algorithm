package BOJ.Graph_Traversal

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import kotlin.math.max

//벽 3개 모든 경우의 수 -> 안전구역 max
private lateinit var list: Array<IntArray>
private lateinit var copyList: Array<IntArray>
private var safeCnt = 0
private var n = 0
private var m = 0
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val nm = br.readLine().split(" ").map { it.toInt() }
    n = nm[0]
    m = nm[1]
    list = Array(n) { IntArray(m) }
    copyList = Array(n) { IntArray(m) }
    for (i in 0 until n) {
        list[i] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }
    bfs(0)
    print(safeCnt)
}

//순서대로 3개 벽 세우기
private fun bfs(wall: Int) {
    if (wall == 3) {
        dfs()
        return
    }

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (list[i][j] == 0) {
                list[i][j] = 1
                bfs(wall + 1)
                list[i][j] = 0
            }
        }
    }
}

//3개 벽 세우고 -> 전염
private fun dfs() {
    for (i in 0 until n) {
        copyList[i] = list[i].copyOf()
    }

    val queue = LinkedList<Pair<Int, Int>>()
    val dx = intArrayOf(-1, 0, 1, 0)
    val dy = intArrayOf(0, -1, 0, 1)

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (copyList[i][j] == 2) {
                queue.add(Pair(i, j))
            }
        }
    }

    while (queue.isEmpty().not()) {
        val cur = queue.poll()
        for (z in 0 until 4) {
            val cx = cur.first + dx[z]
            val cy = cur.second + dy[z]

            if (cx < 0 || cy < 0 || cx >= n || cy >= m) continue
            if (copyList[cx][cy] == 0) {
                copyList[cx][cy] = 2
                queue.add(Pair(cx, cy))
            }
        }
    }
    safe()
}

//전염 -> 안전구역 갯수
private fun safe() {
    var safe = 0
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (copyList[i][j] == 0) {
                safe += 1
            }
        }
    }
    safeCnt = max(safeCnt, safe)
}