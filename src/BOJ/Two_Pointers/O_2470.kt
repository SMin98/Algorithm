package BOJ.Two_Pointers

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val list = br.readLine().split(" ").map { it.toInt() }.sorted()

    var s = 0
    var e = n - 1
    var save = Pair(0, 0)
    var num = Integer.MAX_VALUE
    while (s < e) {
        val sum = list[s] + list[e]
        if (abs(sum) < num) {
            num = abs(sum)
            save = Pair(list[s], list[e])
            if (sum == 0) {
                break
            }
        }
        if (sum < 0) {
            s += 1
        } else {
            e -= 1
        }
    }
    print("${save.first} ${save.second}")
}