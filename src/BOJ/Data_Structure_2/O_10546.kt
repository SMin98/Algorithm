package BOJ.Data_Structure_2

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val list = mutableMapOf<String, Int>()
    for (i in 0 until n) {
        val name = br.readLine()
        list[name] = list.getOrDefault(name, 0) + 1
    }
    for (i in 0 until n - 1) {
        val name = br.readLine()
        list[name] = list[name]!! - 1
    }

//    val loser = list.filterValues {
//        it == 1
//    }.keys

    var loser = ""
    for (i in list.keys) {
        if (list[i] == 1) {
            loser = i
        }
    }

    print(loser)
}