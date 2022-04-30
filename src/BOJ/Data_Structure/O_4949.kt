package BOJ.Data_Structure

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.Stack

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    while (true) {
        val s = Stack<Char>()
        val line = br.readLine().toCharArray()
        if (line[0] == '.') break

        var isBalance = true
        for (i in line) {
            if (i == '(' || i == '[') s.add(i)
            else if (i == ')') {
                if (s.isNotEmpty() && s.peek() == '(') {
                    s.pop()
                } else {
                    isBalance = false
                    break
                }
            } else if (i == ']') {
                if (s.isNotEmpty() && s.peek() == '[') {
                    s.pop()
                } else {
                    isBalance = false
                    break
                }
            }
        }

        if (s.isNotEmpty()) {
            isBalance = false
        }

        when (isBalance) {
            true -> bw.write("yes \n")
            false -> bw.write("no \n")
        }
    }

    bw.flush()
    bw.close()
}