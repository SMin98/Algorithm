package BOJ.Graph_Traversal

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.collections.ArrayList
import kotlin.math.max

private lateinit var list: Array<ArrayList<Int>>
private lateinit var cnt: IntArray
private lateinit var visit: BooleanArray

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringBuilder()

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    list = Array(n + 1) { ArrayList() }
    cnt = IntArray(n + 1)
    for (i in 1..m) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        list[a].add(b)
    }
    var max = 0
    for (i in 1..n) {
        visit = BooleanArray(list.size)
        find(i)
    }

    for (i in 1..n) {
        max = max(max, cnt[i])
    }

    for (i in 1..n) {
        if (max == cnt[i]) {
            st.append("$i ")
        }
    }
    print(st)
}

private fun find(i: Int) {
    visit[i] = true

    for (v in list[i]) {
        if (!visit[v]) {
            cnt[v] += 1
            find(v)
        }
    }
}
