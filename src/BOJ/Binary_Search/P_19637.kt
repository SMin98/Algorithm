package BOJ.Binary_Search

import java.io.BufferedReader
import java.io.InputStreamReader

private var n = 0
private var m = 0
private lateinit var list: ArrayList<Pair<String, Int>>
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val st = StringBuilder()

    val nm = br.readLine().split(" ").map { it.toInt() }
    n = nm[0]
    m = nm[1]
    list = ArrayList(n)
    for (i in 0 until n) {
        val (a, b) = br.readLine().split(" ")
        list.add(Pair(a, b.toInt()))
    }
    for (i in 0 until m) {
        val p = br.readLine().toInt()
        st.append(search(p) + "\n")
    }

    print(st)
}

private fun search(power: Int): String {
    var s = 0
    var e = n - 1
    while (s <= e) {
        val mid = (s + e) / 2
        if (power <= list[mid].second) e = mid - 1
        else s = mid + 1
    }

    return list[e+1].first
}