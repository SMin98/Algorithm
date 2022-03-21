package BOJ.Tree

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, q) = br.readLine().split(" ").map { it.toInt() }
    val visit = Array(n + 1) { false }
    for (i in 1..q) {
        val x = br.readLine().toInt()
        var num = x
        var answer = 0

        if (visit[num]) {
            answer = num
        }

        while (true) {

            if (num % 2 == 0) {
                num /= 2
            } else {
                num = (num - 1) / 2
            }

            if (num == 1) {
                visit[x] = true
                break
            }

            if (visit[num]) {
                answer = num
            }

        }

        println(answer)
    }
}