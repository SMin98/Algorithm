package BOJ.Graph_Traversal

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.StringTokenizer

//이해가 안돼서 참고 https://velog.io/@paulus0617/boj5547
private lateinit var isOut: Array<BooleanArray>
private lateinit var list: Array<IntArray>
private val queue = LinkedList<Pair<Int, Int>>()

private val oddList =
    arrayOf(arrayOf(-1, 0), arrayOf(0, -1), arrayOf(1, 0), arrayOf(1, 1), arrayOf(0, 1), arrayOf(1, -1))
private val evenList =
    arrayOf(arrayOf(-1, -1), arrayOf(0, -1), arrayOf(1, 0), arrayOf(-1, 1), arrayOf(0, 1), arrayOf(-1, 0))

private var w = 0
private var h = 0

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())
    w = st.nextToken().toInt()
    h = st.nextToken().toInt()
    list = Array(h + 2) { IntArray(w + 2) }
    isOut = Array(h + 2) { BooleanArray(w + 2) }

    for (i in 1..h) {
        st = StringTokenizer(br.readLine())
        for (j in 1..w) {
            list[i][j] = st.nextToken().toInt()
        }
    }

    queue.offer(Pair(0, 0))
    isOut[0][0] = true

    while (queue.isEmpty().not()) {
        val cur = queue.poll()
        for (i in 0 until 6) {
            if (cur.second % 2 == 0) {
                check(evenList, cur, i)
            } else {
                check(oddList, cur, i)
            }
        }
    }
//private val oddList =
//    arrayOf(arrayOf(-1, 0), arrayOf(0, -1), arrayOf(1, 0), arrayOf(1, 1), arrayOf(0, 1), arrayOf(1, -1))
//private val evenList =
//    arrayOf(arrayOf(-1, -1), arrayOf(0, -1), arrayOf(1, 0), arrayOf(-1, 1), arrayOf(0, 1), arrayOf(-1, 0))
    var cnt = 0
    for (i in 1..h) {
        for (j in 1..w) {
            if (list[i][j] == 0) continue
            for (z in 0 until 6) {
                val nx: Int
                val ny: Int
                if (i % 2 == 0) {
                    nx = i + evenList[z][1]
                    ny = j + evenList[z][0]
                } else {
                    nx = i + oddList[z][1]
                    ny = j + oddList[z][0]
                }
                if (isOut[nx][ny]) cnt += 1
            }
        }
    }

    print(cnt)
}

private fun check(checkList: Array<Array<Int>>, cur: Pair<Int, Int>, i: Int) {
    val nx = cur.first + checkList[i][0]
    val ny = cur.second + checkList[i][1]
    if (nx < 0 || ny < 0 || nx >= w + 2 || ny >= h + 2) return
    if (list[ny][nx] != 0 || isOut[ny][nx]) return
    isOut[ny][nx] = true
    queue.offer(Pair(nx, ny))
}