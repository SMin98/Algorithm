package BOJ.Math

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val list = br.readLine().split(" ").map { it.toInt() }

    var max1 = 1
    var max2 = 1
    var check = false
    list.forEach {
        if (it % 2 == 1) {
            max1 *= it
            if (check.not()) {
                check = true
            }
        }
        max2 *= it
    }
    if (check) print(max1) else print(max2)

}