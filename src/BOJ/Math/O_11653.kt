package BOJ.Math

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    var n = br.readLine().toInt()
    if (n == 1) {
        return
    }
    var i = 2
    while (i * i <= n) {
        if (n % i == 0) {
            bw.write("${i}\n")
            n /= i
        } else {
            i += 1
        }
    }
    bw.write("$n")
    bw.flush()
    bw.close()
}