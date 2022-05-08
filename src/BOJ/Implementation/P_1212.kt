package BOJ.Implementation

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
//    8진수 자리 하나 -> 2진수 자리 3개
//    8진수 314 -> 011 001 100 (2진수)
//    8진수 45 -> 100 101 (2진수)
    val br = BufferedReader(InputStreamReader(System.`in`))
    val sb = StringBuilder()
    val binary = arrayOf("000", "001", "010", "011", "100", "101", "110", "111")

    val n = br.readLine().toCharArray()
    for (i in n.indices) {
        val cur: Int = n[i] - '0'
        if (i == 0 && cur < 4) {
            if (cur < 2) { //0,1인 경우 앞의 두자리('00') 잘라주기
                sb.append(binary[cur].substring(2))
            } else { // 2,3인 경우 앞의 한 자리 ('0') 잘라주기
                sb.append(binary[cur].substring(1))
            }
        } else {
            sb.append(binary[cur])
        }
    }

    println(sb)
}