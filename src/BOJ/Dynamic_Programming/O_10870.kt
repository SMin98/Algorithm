package BOJ.Dynamic_Programming

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()

    print(fibo(n))
}

fun fibo(n: Int): Int = when (n) {
    0 -> 0
    1 -> 1
    else -> fibo(n - 1) + fibo(n - 2)
}
