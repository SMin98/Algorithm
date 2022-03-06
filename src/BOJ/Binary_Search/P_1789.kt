package BOJ.Binary_Search

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    // 1 ~ n까지 합 = n * (n+1) /2
    val s = readLine().toLong()
    print(binary(s, 1, s))
}

fun binary(s: Long, start: Long, end: Long): Long {
    val mid = (start + end) / 2
    val sum = (mid * (mid + 1)) / 2

    if (start > end) {
        return mid
    }

    return if (sum > s) {
        (binary(s, start, mid - 1))
    } else {
        (binary(s, mid + 1, end))
    }
}

