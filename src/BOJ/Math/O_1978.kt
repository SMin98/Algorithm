package BOJ.Math

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    var cnt = 0
    val prime = Array(1001) { true }
    prime[0] = false
    prime[1] = false
    val n = br.readLine().toInt()
    val list = br.readLine().split(" ").map { it.toInt() }

    for (i in 2..1000)
        if (prime[i])
            for (j in 2 * i..1000 step i)
                prime[j] = false

    list.forEach {
        if (prime[it]) cnt += 1
    }

    print(cnt)
}