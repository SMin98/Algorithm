package BOJ.Greedy

class O_1343 {
}

fun main() {
    var str: String? = readLine()
    str = str?.replace("XXXX", "AAAA")
    str = str?.replace("XX", "BB")

    if (str!!.contains("X")) {
        str = "-1"
    }
    print(str)
}