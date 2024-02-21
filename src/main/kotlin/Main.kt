fun main(args: Array<String>) {
    romanToInt("IV")
}

fun romanToInt(s: String): Int {
    // IV(4) IX(9) XL(40) XC(90) CD(400) CM(900)
    var result = 0
    var i = 0
    while (i < s.length) {
        when (s[i].toString()) {
//            "IV" -> result += 4
//            "IX" -> result += 9
//            "XL" -> result += 40
//            "XC" -> result += 90
//            "CD" -> result += 400
//            "CM" -> result += 900
            "I" -> {
                if (i != s.length -1 && s[i + 1] == 'V') {
                    result += 4
                    i++
                } else if (s[i + 1] == 'X') {
                    result += 9
                    i++
                } else {
                    result += 1
                }
            }
            "V" -> result += 5
            "X" -> {
                if (s[i + 1] == 'L') {
                    result += 40
                    i++
                } else if (s[i + 1] == 'C') {
                    result += 90
                    i++
                } else {
                    result += 10
                }
            }

            "L" -> result += 50
            "C" -> {
                if (s[i + 1] == 'D') {
                    result += 400
                    i++
                } else if (s[i + 1] == 'M') {
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