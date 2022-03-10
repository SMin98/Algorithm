package BOJ.Tree

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.pow

val answer = ArrayList<MutableList<String>>()

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val k = br.readLine().toInt()
    val list = br.readLine().split(" ")

    for (i in 0 until k) {
        answer.add(mutableListOf())
    }

    findNum(0, list.size - 1, 0, k, list)

    for (i in 0 until k) {
        for (j in 0 until answer[i].size)
            bw.write(answer[i][j] + " ")
        bw.write("\n")
    }

    bw.flush()
    bw.close()
}

fun findNum(start: Int, end: Int, floor: Int, k: Int, list: List<String>) {
    if (floor == k) {
        return
    }

    val mid = (start + end) / 2
    answer[floor].add(list[mid])

    findNum(start, mid - 1, floor + 1, k, list)
    findNum(mid + 1, end, floor + 1, k, list)
}

