package BOJ.Greedy

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt() //도시갯수
    val dis = br.readLine().split(" ").map { it.toLong() }
    val price = br.readLine().split(" ").map { it.toLong() }

    var currentPrice = price.first()
    var sum = currentPrice * dis.first()

    for (i in 1 until n - 1) {
        if (currentPrice > price[i]) {
            currentPrice = price[i]
        }
        sum += currentPrice * dis[i]
    }

    print(sum)
}