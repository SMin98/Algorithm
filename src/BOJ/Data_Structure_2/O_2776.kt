package BOJ.Data_Structure_2

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val t = br.readLine().toInt()
    for (i in 0 until t) {
        val n = br.readLine().toInt()
        val nList = br.readLine().split(" ").map { it.toInt() }.sorted()
        val m = br.readLine().toInt()
        val mList = br.readLine().split(" ").map { it.toInt() }

        for (j in mList) {
            if (find(nList, j)) bw.write("1 \n")
            else bw.write("0 \n")
        }
    }
    bw.flush()
    bw.close()
}

private fun find(nList: List<Int>, j: Int): Boolean {
    var s = 0
    var e = nList.size - 1

    if (j < nList[s] || nList[e] < j) return false
    if (nList[s] == j || nList[e] == j) return true

    while (s <= e) {
        val mid = (s + e) / 2
        if (nList[mid] == j) return true
        if (nList[mid] < j) s = mid + 1
        else e = mid - 1
    }

    return false
}