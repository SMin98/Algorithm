package BOJ.Dynamic_Programming

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    if (n%2==0){
        print("CY")
    }else{
        print("SK")
    }
}