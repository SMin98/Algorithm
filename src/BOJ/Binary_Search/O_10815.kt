package BOJ.Binary_Search

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()

    val n = br.readLine().toInt()
    val nList = br.readLine().split(" ").map { it.toInt() }.sorted()
    val m = br.readLine().toInt()
    val mList = br.readLine().split(" ").map { it.toInt() }

    for (i in 0 until m) {
        var s = 0
        var e = n - 1
        while (s <= e) {
            val mid = (s + e) / 2
            if (nList[mid] == mList[i]) {
                sb.append("1 ")
                break
            }
            if (nList[mid] < mList[i]) {
                s = mid + 1
            } else if (nList[mid] > mList[i]) {
                e = mid - 1
            }
            if (s > e) {
                sb.append("0 ")
                break
            }
        }
    }

//    for (i in 0 until m) {
//        if (nList.contains(mList[i])) sb.append("1 ")
//        else sb.append("0 ")
//    }

    println(sb)
}