package BOJ.Tree

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    while (true) {
        val (n, k) = br.readLine().split(" ").map { it.toInt() }
        if (n == 0 && k == 0) return

        var index = 0
        val list = Array(n + 1) { 0 }
        val parent = Array(n + 1) { 0 }

        val a=br.readLine().split(" ").map { it.toInt() }
        for (i in 1..n){
            list[i]=a[i-1]
            if (a[i-1]==k) index=i
        }

        var answer = 0
        parent[0] = -1
        parent[1] = 0

        var idx = 1
        for (i in 2..n) {
            parent[i] = idx
            if (i < n && list[i] + 1 != list[i + 1]) idx += 1
        }
        for (i in 1..n) {
            if (parent[parent[i]] == parent[parent[index]] && parent[i] != parent[index]) {
                answer += 1
            }
        }
        println(answer)
    }
}