package BOJ.Binary_Search

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val list = br.readLine().split(" ").map { it.toInt() }.sorted()
    val m = br.readLine().toInt()

    var s = 0
    var e = list[n - 1]
    while (s <= e) {
        val mid = (s + e) / 2
        var sum = 0L
        list.forEach {
            sum += if (mid > it) it
            else mid
        }
        if (m < sum) e = mid-1
        else s = mid + 1
    }

    print(s-1)

}