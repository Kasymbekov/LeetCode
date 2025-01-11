import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.ArrayList
import java.util.Arrays
import java.util.Date
import java.util.HashMap
import java.util.Scanner
import kotlin.math.*

fun main() {
    println(containsNearbyDuplicate(intArrayOf(1, 2, 3, 1, 2, 3), 2)) // Case 3 - true
}

// Contains Duplicate ||
fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
    for (i in 0..<nums.lastIndex) {
        for (j in i + 1..nums.lastIndex) {
            if (nums[i] == nums[j] && abs(i - j) <= k) {
                return true
            }
            if (i == nums.size - 1 && j == nums.size - 1) {
                return false
            }
        }
    }
    return false
}

fun isValid(s: String): Boolean {
    val stack = ArrayDeque<Char>()
    val hashMap = hashMapOf<Char, Char>(
        ')' to '(', '}' to '{', ']' to '['
    )
    for (i in s) {
        if (hashMap.contains(i)) {
            if (stack.isNotEmpty() && stack.last() == hashMap[i]) {
                stack.removeLast()
            } else {
                return false
            }
        } else {
            stack.add(i)
        }
    }
    return stack.size == 0
}

fun isHappy(n: Int): Boolean {
    var string = n.toString()
    var sum = 0
    while (string != "1") {
        for (i in string.indices) {
            sum += string[i].digitToInt() * string[i].digitToInt()
            if (i == string.lastIndex) {
                string = sum.toString()
                sum = 0
            }
            if (string.toInt() == 1 || string.toInt() == 7) {
                return true
            }
        }
    }
    return true
}

fun singleNumber(nums: IntArray): Int {
    val arr = nums.sorted()
    var current = arr[0]
    var count = 0
    for (i in arr) {
        if (i == current) {
            count++
        } else {
            count--
        }
        if (count == 0) {
            return current
        }
        current = i
    }
    return current
}

data class Person(
    var name: String = "default",
    var age: Int = 7,
    var email: String = "example@gmail.com"
)

fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): String {
    val arr: MutableList<Int> = ArrayList()
    for (i in nums1.plus(nums2)) {
        if (i != 0) arr.add(i)
    }
    return arr.sorted().toString()
}

fun letterCombinations(digits: String): List<String> {
    var str = ""
    var hashMap: HashMap<Int, String> = HashMap<Int, String>()
    hashMap.put(2, "abc")
    hashMap.put(3, "def")
    hashMap.put(4, "ghi")
    hashMap.put(5, "jkl")
    hashMap.put(6, "mno")
    hashMap.put(7, "pqrs")
    hashMap.put(8, "tuv")
    hashMap.put(9, "wxyz")

    val index = if (hashMap.containsKey(7)) 3 else 2

    println("index: $index")

    var list = mutableListOf<String>()
    for (i in digits) {
        when (i.digitToInt()) {
            2 -> str += "abc"
            3 -> str += "def"
            4 -> str += "ghi"
        }
    }
    println(str)
    return listOf("test")
}

fun printFib(n: Int) {
    val arr = mutableListOf(0, 1)

    while (arr[arr.lastIndex] + arr[arr.lastIndex - 1] < n) {
        arr.add(arr[arr.lastIndex] + arr[arr.lastIndex - 1])
    }
    if (arr[arr.lastIndex] == n) arr.remove(arr[arr.lastIndex])
    println(arr)
}

fun addTwoNumbers(l1: List<Int>, l2: List<Int>): List<Int> {
    var list1 = ""
    var list2 = ""
    for (i in l1.indices) {
        list1 += l1[i].toString()
    }
    for (i in l2.indices) {
        list2 += l2[i].toString()
    }
    var result = (list1.toInt() + list2.toInt()).toString().reversed()
    var list: MutableList<Int> = arrayListOf()
    for (i in result) {
        list.add(i.digitToInt())
    }
    return list
}

fun lengthOfLastWord(s: String): Int {
    var str = ""
    val mutableList = mutableListOf<String>()
    for (i in s.indices) {
        if (s[i].isLetter()) {
            str += s[i]
            if (i == s.lastIndex) {
                mutableList.add(str)
            }
        } else {
            if (str.isNotEmpty()) {
                mutableList.add(str)
            }
            str = ""
        }

    }
    return mutableList[mutableList.lastIndex].length
}

fun searchInsert(nums: IntArray, target: Int): Int {
    var n = 0
    for (i in nums.indices) {
        if (nums[i] == target) return i
        if (nums[i] < target) n++
    }
    return n
}

fun getString(num: Int): String {
    when (num) {
        2 -> return "abc"
        3 -> return "def"
        4 -> return "ghi"
        5 -> return "jkl"
        6 -> return "mno"
        7 -> return "pqrs"
        8 -> return "tuv"
        9 -> return "wxyz"
    }
    return ""
}


// 100  10  12  15 --> 160
// 100  10  12  1 --> 100


fun plusOne(digits: IntArray): IntArray {
    var s = ""
    for (i in digits.indices) {
        s += if (i == digits.size - 1) {
            (digits[i] + 1).toString()
        } else {
            digits[i].toString()
        }
    }
//    var newArray = intArrayOf(*s.chars().toArray().toTypedArray())
//    for (i in 0..s.length){
//        newArray[i] = s[i].toInt()
//    }
//    if (digits[0] == 9) return intArrayOf(1, 0)
//    digits[digits.lastIndex] += 1
    println(listOf(s.chars()))
    return digits
}

fun mySqrt(x: Int): Int {
    return sqrt(x.toDouble()).toInt()
}

fun makePyramid(n: Int) {
    for (i in 1..n) {
        for (x in n downTo i) {
            print(" ")
        }
        for (y in 1..i) {
            print("$i ")
        }
        println()
    }
}

//Roman to Integer
// IV(4) IX(9) XL(40) XC(90) CD(400) CM(900)
fun romanToInt(s: String): Int {
    var result = 0
    var i = 0
    while (i < s.length) {
        when (s[i].toString()) {
            "I" -> {
                if (i != s.length - 1 && s[i + 1] == 'V') {
                    result += 4
                    i++
                } else if (i != s.length - 1 && s[i + 1] == 'X') {
                    result += 9
                    i++
                } else {
                    result += 1
                }
            }

            "V" -> result += 5
            "X" -> {
                if (i != s.length - 1 && s[i + 1] == 'L') {
                    result += 40
                    i++
                } else if (i != s.length - 1 && s[i + 1] == 'C') {
                    result += 90
                    i++
                } else {
                    result += 10
                }
            }

            "L" -> result += 50
            "C" -> {
                if (i != s.length - 1 && s[i + 1] == 'D') {
                    result += 400
                    i++
                } else if (i != s.length - 1 && s[i + 1] == 'M') {
                    result += 900
                    i++
                } else {
                    result += 100
                }
            }

            "D" -> result += 500
            "M" -> result += 1000
        }
        i++
    }
    return result
}

//fun checkRoman(i: Int, s: String, ch: Char){
//    if (i != s.length -1 && s[i + 1] == ch) {
//        result += 400
//        i++
//    } else if (i != s.length -1 && s[i + 1] == ch) {
//        result += 900
//        i++
//    } else {
//        result += 100
//    }
//}