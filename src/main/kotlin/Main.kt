import kotlin.collections.HashMap

fun main() {
    println(converter(69969))
}

fun converter(number:Int): String? {
    if(number.toString().length == 5){
        return fiveDigits(number.toString())
    }
    if(number.toString().length == 4){
        return fourDigits(number.toString())
    }
    if(number.toString().length == 3){
        return threeDigits(number.toString())
    }
    if(number.toString().length < 3){
        return twoDigits(number.toString())
    }

    return "Error!"
}

fun twoDigits(number:String): String? {
    val numbersBasic = HashMap<Int, String>()
    numbersBasic.putAll(arrayOf(
        Pair(0, "zero"),
        Pair(1, "one"),
        Pair(2, "two"),
        Pair(3, "three"),
        Pair(4, "four"),
        Pair(5, "five"),
        Pair(6, "six"),
        Pair(7, "seven"),
        Pair(8, "eight"),
        Pair(9, "nine"),
        Pair(10, "ten"),
        Pair(11, "eleven"),
        Pair(12, "twelve"),
        Pair(13, "thirteen"),
        Pair(14, "fourteen"),
        Pair(15, "fifteen"),
        Pair(16, "sixteen"),
        Pair(17, "seventeen"),
        Pair(18, "eighteen"),
        Pair(19, "nineteen"),
        Pair(20, "twenty"),
        Pair(30, "thirty"),
        Pair(40, "forty"),
        Pair(50, "fifty"),
        Pair(60, "sixty"),
        Pair(70, "seventy"),
        Pair(80, "eighty"),
        Pair(90, "ninety"),
    ))

    if(number.length < 3){
        if(numbersBasic.containsKey(number.toInt())){
            return numbersBasic[number.toInt()]
        }else{
            if (number[0] == '0' && number.length == 2){
                return numbersBasic[Integer.parseInt(number[1].toString())]
            }
            if(number.last() == '0'){
                return numbersBasic[Integer.parseInt("${number[0]}0")]
            }

            if(number.length == 1){
                return numbersBasic[number.toInt()]
            }

            return numbersBasic[Integer.parseInt("${number[0]}0")] + " " + numbersBasic[number.last().digitToInt()]
        }
    }

    return "red"
}

fun threeDigits(number:String): String? {
    val numbersBasic = HashMap<Int, String>()
    numbersBasic[100] = "hundred"

    if(number.length == 3){
        return if (number[0] == '0' && number[1] == '0') {
            twoDigits(number[2].toString())
        } else if (number[0] == '0') {
            twoDigits(number[1].toString() + number[2].toString())
        } else if(number[1] == '0' && number[2] == '0'){
                twoDigits(number[0].toString()) + " " + numbersBasic[100]
        } else{
            twoDigits(number[0].toString()) + " " + numbersBasic[100] + " and " + twoDigits(number.substring(1, 3))
        }
    }

    return "red"
}

fun fourDigits(number:String):String{
    val numbersBasic = HashMap<Int, String>()
    numbersBasic[1000] = "thousand"

    if(number.length == 4){
        return if(number[1] == '0' && number[2] == '0' && number[3] == '0'){
            twoDigits(number[0].toString()) + " " + numbersBasic[1000]
        } else if(number[1] == '0'){
            twoDigits(number[0].toString()) + " " + numbersBasic[1000] + " and " + twoDigits(number.substring(2, 4))
        } else{
            twoDigits(number[0].toString()) + " " + numbersBasic[1000] + " " + threeDigits(number.substring(1, 4))
        }
    }

    return "red"
}

fun fiveDigits(number:String):String{
    val numbersBasic = HashMap<Int, String>()
    numbersBasic[1000] = "thousand"

    if(number.length == 5){
        return if(number[1] == '0' && number[2] == '0' && number[3] == '0' && number[4] == '0'){
            twoDigits((number[0].toString() + number[1].toString())) + " " + numbersBasic[1000]
        }
        else if(number[0] == '0' && number[1] == '0'){
            return twoDigits(number[0].toString() + number[1].toString()) + " " + numbersBasic[1000]
        }
        else if(number[1] == '0' && number[2] == '0' && number[3] == '0'){
            return twoDigits(number[0].toString() + number[1].toString()) + " " + numbersBasic[1000] + " and " + twoDigits(number[4].toString())
        }
        else if(number[2] == '0' && number[3] == '0' && number[4] == '0'){
            return twoDigits(number[0].toString() + number[1].toString()) + " " + numbersBasic[1000]
        }
        else if(number[1] == '0' && number[2] == '0'){
            twoDigits(number[0].toString() + number[1].toString()) + " " + numbersBasic[1000] + " " + threeDigits(number.substring(2, 5))
        } else if(number[3] == '0' && number[2] == '0'){
            twoDigits(number[0].toString() + number[1].toString()) + " " + numbersBasic[1000] + " and " + twoDigits(number.substring(4))
        }else{
            twoDigits(number[0].toString() + number[1]) + " " + numbersBasic[1000] + " " + threeDigits(number.substring(2, 5))
        }
    }
    return "red"
}