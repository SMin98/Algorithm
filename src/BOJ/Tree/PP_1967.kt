package BOJ.Tree

import java.io.BufferedReader
import java.io.InputStreamReader

var end = 0
var distance = 0
//1. root1 에서 가장 먼 노드,거리 저장
//2. 저장된 노드를 root로 만들어 다시 최대 거리 계산

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()

    var visit = BooleanArray(n + 1) { false }
    val tree = Array(n + 1) { ArrayList<Node>() }

    for (i in 0 until n - 1) {
        val (a, b, c) = br.readLine().split(" ").map { it.toInt() }
        tree[a].add(Node(b, c))
        tree[b].add(Node(a, c))
    }
    //root = 1
    dfs(tree, visit, 1, 0)
    //visit 초기화
    visit = BooleanArray(n + 1) { false }
    //root = end
    dfs(tree, visit, end, 0)
    print(distance)
}

fun dfs(tree: Array<java.util.ArrayList<Node>>, visit: BooleanArray, start: Int, dis: Int) {
    visit[start] = true

    if (distance < dis) {
        distance = dis
        end = start
    }

    for (i in tree[start].indices) {
        val next = tree[start][i].node
        val nextDis = dis + tree[start][i].dis
        if (visit[next]) continue
        dfs(tree, visit, next, nextDis)
    }
}

class Node(
    val node: Int,
    val dis: Int
)