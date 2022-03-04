package BOJ.Math

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

class O_2609 {
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val str = StringTokenizer(readLine())
    val a = Integer.valueOf(str.nextToken())
    val b = Integer.valueOf(str.nextToken())

    println("${gcd(a, b)}")
    println("${a * b / gcd(a, b)}")
}

fun gcd(a: Int, b: Int): Int = if (b != 0) gcd(b, a % b) else a