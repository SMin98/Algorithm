package BOJ.Two_Pointers

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Integer.max

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, d, k, c) = br.readLine().split(" ").map { it.toInt() }
    val list = Array(n) { 0 }
    for (i in 0 until n) {
        list[i] = br.readLine().toInt()
    }

    val count = Array(d + 1) { 0 }
    count[c] += 1
    var cnt = 1

    for (i in 0 until k) {
        count[list[i]] += 1
        if (count[list[i]] == 1) {
            cnt += 1
        }
    }
    var max = cnt

    for (i in 1 until n) {
        count[list[i - 1]] -= 1
        if (count[list[i - 1]] == 0) {
            cnt -= 1
        }
        if ((i + k - 1) >= n) {
            count[list[i + k - 1 - n]] += 1
            if (count[list[i + k - 1 - n]] == 1) {
                cnt += 1
            }
        } else {
            count[list[i + k - 1]] += 1
            if (count[list[i + k - 1]] == 1) {
                cnt += 1
            }
        }

        max = max(max, cnt)
    }

    print(max)
}