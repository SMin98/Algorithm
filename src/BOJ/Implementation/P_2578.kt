package BOJ.Implementation

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

private var cnt = 0
private lateinit var bingo: Array<IntArray>

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    bingo = Array(5) { IntArray(5) }
    //빙고 입력
    for (i in bingo.indices) {
        bingo[i] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    for (i in 0 until 5) {
        val st = StringTokenizer(br.readLine())
        for (t in 0 until 5) {
            val num = st.nextToken().toInt()
            //불린 값 0으로 대체
            for (j in 0 until 5) {
                for (z in 0 until 5) {
                    if (bingo[j][z] == num)
                        bingo[j][z] = 0
                }
            }
            //열체크
            rCheck()
            //행체크
            cCheck()
            //대각선 체크(왼쪽,오른쪽)
            leftCheck()
            rightCheck()

            if (cnt >= 3) {
                println(i * 5 + t + 1)
                return
            }
            cnt = 0
        }
    }
}

private fun rCheck() {
    for (j in 0 until 5) {
        var count = 0
        for (z in 0 until 5) {
            if (bingo[j][z] == 0) count += 1
        }
        if (count == 5) cnt += 1
    }
}

private fun cCheck() {
    for (j in 0 until 5) {
        var count = 0
        for (z in 0 until 5) {
            if (bingo[z][j] == 0) count += 1
        }
        if (count == 5) cnt += 1
    }
}

private fun leftCheck() {
    var count = 0
    for (i in 0 until 5) {
        if (bingo[i][i] == 0) count += 1
    }
    if (count == 5) cnt += 1
}

private fun rightCheck() {
    var count = 0
    for (i in 0 until 5) {
        if (bingo[i][4 - i] == 0) count += 1
    }
    if (count == 5) cnt += 1
}