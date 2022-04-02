package BOJ.Dynamic_Programming

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    var n = br.readLine().toInt()

    var answer = 0
    while (n > 0) {
        if (n % 5 != 0) {
            n -= 3
            answer += 1
        } else {
            answer += n / 5
            break
        }
    }

    if (n < 0) {
        print(-1)
    } else {
        print(answer)
    }
}