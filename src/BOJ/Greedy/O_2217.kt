package BOJ.Greedy

class O_2217 {
}

fun main() {
    val n = Integer.valueOf(readLine())
    val list = arrayListOf<Int>()
    for (i in 1..n) {
        list.add(Integer.valueOf(readLine()))
    }

    list.sort()
    val size = list.size
    var max = list[size - 1]

    var index = 0
    for (i in size downTo 1) {
        if (list[index] * i > max) {
            max = list[index] * i
        }
        index++
    }

    println(max)
}