package BOJ.Tree

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Stack

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val t = br.readLine().toInt() //테스트 케이스
    for (i in 1..t) {

        val n = br.readLine().toInt() //노드 수
        val list = Array(n + 1) { 0 }

        for (j in 1 until n) {
            val (a, b) = br.readLine().split(" ").map { it.toInt() }
            //부모-값 , 자식-인덱스
            list[b] = a
        }

        var (q, w) = br.readLine().split(" ").map { it.toInt() } //공통조상

        val a = Stack<Int>()
        val b = Stack<Int>()
        a.push(q)
        b.push(w)

        while (list[q] != 0) {
            a.push(list[q])
            q = list[q]
        }
        while (list[w] != 0) {
            b.push(list[w])
            w = list[w]
        }

        var first: Int
        var second: Int
        var answer = 0
        while (true) {
            if (a.isEmpty() || b.isEmpty()) {
                break
            }
            first = a.pop()
            second = b.pop()
            if (first != second) {
                break
            }
            answer = first
        }

        println(answer)
    }
}