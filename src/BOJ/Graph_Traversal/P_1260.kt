package BOJ.Graph_Traversal

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

private val st = StringBuilder()
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, m, v) = br.readLine().split(" ").map { it.toInt() }
    var visit = Array(n + 1) { false }
    val list = Array(n + 1) { ArrayList<Int>(0) }
    for (i in 1..m) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        list[a].add(b)
        list[b].add(a)
    }
    list.forEach {
        it.sort()
    }
    dfs(list, v, visit)
    st.append("\n")
    visit = Array(n + 1) { false }
    bfs(list, v, visit)
    print(st)
}

fun dfs(list: Array<ArrayList<Int>>, v: Int, visit: Array<Boolean>) {
    st.append("$v ")
    visit[v] = true
    for (i in 0 until list[v].size) {
        if (!visit[list[v][i]]) {
            dfs(list, list[v][i], visit)
        }
    }
}

fun bfs(list: Array<ArrayList<Int>>, v: Int, visit: Array<Boolean>) {
    val queue = LinkedList<Int>()
    queue.add(v)
    st.append("$v ")
    visit[v] = true
    while (queue.isEmpty().not()) {
        val top = queue.pollFirst()
        list[top].forEach {
            if (!visit[it]) {
                queue.add(it)
                st.append("$it ")
                visit[it] = true
            }
        }
    }
}
