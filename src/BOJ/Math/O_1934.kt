package BOJ.Math

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val bf = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val t = bf.readLine().toInt()
    for (i in 1..t) {
        val (a, b) = bf.readLine().split(" ").map { it.toInt() }
        bw.write("${(a * b / gcd1(a, b))}" + "\n")
    }

    bw.flush()
    bw.close()
}

fun gcd1(a: Int, b: Int): Int = if (b != 0) gcd(b, a % b) else a
