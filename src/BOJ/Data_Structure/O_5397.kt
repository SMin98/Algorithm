package BOJ.Data_Structure

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val t = br.readLine().toInt()
    for (i in 0 until t) {
        val list = br.readLine()
        val answer = LinkedList<Char>()
        var index = 0
        for (j in list.indices) {
            when (list[j]) {
                '<' -> if (index != 0) index--
                '>' -> if (index != answer.size) index++
                '-' -> if (index != 0 && answer.isNotEmpty()) answer.removeAt(--index)
                else -> answer.add(index++, list[j])
            }
        }

        val st = StringBuilder()
        for (c in answer) {
            st.append(c)
        }
        println(st)
    }
}