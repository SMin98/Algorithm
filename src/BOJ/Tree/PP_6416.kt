package BOJ.Tree

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val list = HashMap<Int, Int>()
    var k = 1  //테스트 케이스
    var edge = 0 //간선 숫자

    while (true) {
        val st = StringTokenizer(br.readLine())

        while (st.hasMoreTokens()) {
            val a = st.nextToken().toInt()
            val b = st.nextToken().toInt()

            if (a == 0 && b == 0) {
                var root = 0
                var isTrue = true
                for ((_, value) in list) {
                    //들어오는 간선 없음 = 루트
                    if (value == 0) {
                        root += 1
                    }
                    //들어오는 간선 2개 이상 = 트리 아님
                    if (value > 1) {
                        isTrue = false
                        break
                    }
                }

                if (list.size == 0) {
                    println("Case $k is a tree.")
                } else if (isTrue && root == 1 && edge == list.size - 1) {
                    println("Case $k is a tree.")
                } else {
                    println("Case $k is not a tree.")
                }

                k += 1
                list.clear()
                edge = 0
                break
            }

            if (a == -1 && b == -1) return

            list[a] = list.getOrDefault(a, 0)
            list[b] = list.getOrDefault(b, 0) + 1
            edge++
        }
    }
}
