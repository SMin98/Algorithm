package BOJ.Tree

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    // 단절선이 아닌 경우가 없네...?
    //트리는 사이클이 없기 때문에...
    val br = BufferedReader(InputStreamReader(System.`in`))

    val list = ArrayList<MutableList<Int>>()

    val n = br.readLine().toInt()
    //초기화
    for (i in 0..n) {
        list.add(mutableListOf())
    }
    for (i in 1 until n) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        list[a].add(b)
        list[b].add(a)
    }
    val q = br.readLine().toInt()
    for (i in 1..q) {
        val (t, k) = br.readLine().split(" ").map { it.toInt() }
        if (t == 1) {
            //단절점
            if (list[k].size == 1) {
                println("no")
            } else {
                println("yes")
            }
        } else {
            //단절선
            println("yes")
        }
    }
}