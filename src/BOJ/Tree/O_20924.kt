package BOJ.Tree

import java.io.BufferedReader
import java.io.InputStreamReader

var max = 0
var len = 0
var lastindex = 0
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val (n, r) = br.readLine().split(" ").map { it.toInt() }
    val list = Array(n + 1) { ArrayList<Node2>() }
    val visit = Array(n + 1) { false }

    for (i in 1 until n) {
        val (a, b, d) = br.readLine().split(" ").map { it.toInt() }
        list[a].add(Node2(b, d))
        list[b].add(Node2(a, d))
    }

    if (list[r].size == 0) {
        print("0 0")
        return
    }

    if (list[r].size == 2) {
        lastindex = r
    } else {
        findTrunk(list, visit, r)
    }



    if (lastindex != 0) {
        findBranch(list, visit, lastindex, 0)
    }

    print("$len $max")
}

fun findTrunk(list: Array<ArrayList<Node2>>, visit: Array<Boolean>, index: Int) {

    visit[index] = true



    if (list[index].size > 2) {
        lastindex = index
        return
    }

    list[index].forEach {
        if (visit[it.node].not()) {
            len += it.dis
            findTrunk(list, visit, it.node)
        }
    }
}

fun findBranch(list: Array<ArrayList<Node2>>, visit: Array<Boolean>, index: Int, branch: Int) {

    visit[index] = true

    list[index].forEach {
        var sum = branch
        if (visit[it.node].not()) {
            sum += it.dis
            findBranch(list, visit, it.node, sum)
        }
    }

    if (max < branch) {
        max = branch
    }
}

class Node2(
    val node: Int,
    val dis: Int
)