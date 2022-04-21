package BOJ.Two_Pointers

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val list = br.readLine().split(" ").map { it.toInt() }.sorted()

    var cnt = 0L //int 꽉참..;
    for (i in 0 until n - 2) {
        if (list[i] > 0) {
            break
        }
        var s = i + 1
        var e = n - 1
        while (s < e) {
            val sum = list[s] + list[e]+list[i]
            if (sum < 0) {
                s += 1
            } else if (sum == 0) {
                //여기서 조건을 달아줘야 함
                //인덱스가 같을 때 ex [0, 0, 0, 0, 0]
                if (list[s] == list[e]) {
                    cnt += ((e - s + 1) * (e - s)) / 2
                    break
                } else {  //인덱스가 다를때(연속된것 까지 세기 위함)
                    val start = list[s]
                    var st = 0
                    while (true) {
                        if (list[s] != start) break
                        else {
                            s += 1
                            st += 1
                        }
                    }
                    val end = list[e]
                    var en = 0
                    while (true) {
                        if (list[e] != end) break
                        else {
                            e -= 1
                            en += 1
                        }
                    }
                    cnt += st * en
                }
            } else {
                e -= 1
            }
        }
    }
    print(cnt)
}
