package BOJ.Data_Structure

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.Stack

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    var cnt = 0
    for (i in 0 until n) {
        val list = br.readLine().toCharArray()
        val stack = Stack<Char>()
        list.forEach {
            if (it == 'A') {
                if (stack.isNotEmpty() && stack.peek() == 'A') {
                    stack.pop()
                } else stack.push(it)
            } else if (it == 'B') {
                if (stack.isNotEmpty() && stack.peek() == 'B') {
                    stack.pop()
                } else stack.push(it)
            }
        }

        if (stack.isEmpty()) {
            cnt += 1
        }
    }

    print(cnt)

}