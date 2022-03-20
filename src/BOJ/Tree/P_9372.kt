package BOJ.Tree

import java.io.BufferedReader
import java.io.InputStreamReader

//최소 신장/스패닝 트리
// 모두 연결 + 가중치 없음 -> 최소 방문 = 노드-1
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    for (i in 1..t) {
        val (n, m) = br.readLine().split(" ").map { it.toInt() }

        for (j in 1..m) {
            val (a, b) = br.readLine().split(" ")
        }

        println(n - 1)
    }
}