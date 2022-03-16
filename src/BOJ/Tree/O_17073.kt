package BOJ.Tree

import java.io.BufferedReader
import java.io.InputStreamReader

//물양 /자식노드가 없는 노드
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, w) = br.readLine().split(" ").map { it.toInt() }
    val list = ArrayList<MutableList<Int>>()

    for (i in 0..n) {
        list.add(mutableListOf())
    }
    for (i in 1 until n) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        list[a].add(b)
        list[b].add(a)
    }
    var p = 0
    for (i in 2..n) {
        if (list[i].size == 1) {
            p += 1
        }
    }
    print(w / p.toDouble())
}