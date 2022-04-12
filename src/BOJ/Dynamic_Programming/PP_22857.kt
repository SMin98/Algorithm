package BOJ.Dynamic_Programming

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Integer.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, k) = br.readLine().split(" ").map { it.toInt() }  //(8 2)
    val list = br.readLine().split(" ").map { it.toInt() } //(1 2 3 4 5 6 7 8)

    var s = 0
    var e = 0
    var odd = 0
    var even = 0

    if (list[0] % 2 != 0) odd += 1
    else even += 1

    var max = even

    while (e >= s) {
        if (odd > k) {
            if (list[s] % 2 == 0) even -= 1
            else odd -= 1
            s += 1
        } else {
            e += 1
            if (e >= n) break
            if (list[e] % 2 != 0) odd += 1
            else even += 1
            max = max(max, even)
        }
    }
    print(max)
}