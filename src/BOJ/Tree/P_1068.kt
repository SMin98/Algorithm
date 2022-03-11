package BOJ.Tree

import java.io.BufferedReader
import java.io.InputStreamReader

val list = ArrayList<MutableList<Int>?>()

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val parent = br.readLine().split(" ")
    val remove = br.readLine().toInt()
    var answer = 0

    for (i in 0 until n) {
        list.add(mutableListOf())
    }

    for (i in 0 until n) {
        if (parent[i].toInt() == -1) {
            continue
        }
        list[parent[i].toInt()]?.add(i)
    }

    removeIndex(remove)

    for (i in 0 until n) {
        if (list[i]?.contains(remove) == true) {
            list[i]!!.remove(remove)
        }
    }

    for (i in 0 until n) {
        if (list[i]?.size == 0) {
            answer++
        }
    }

    println(answer)
}

fun removeIndex(remove: Int) {
    list[remove]!!.forEach {
        if (list[it]!!.size != 0) {
            removeIndex(it)
        } else {
            list[it] = null
        }
    }
    list[remove] = null
}