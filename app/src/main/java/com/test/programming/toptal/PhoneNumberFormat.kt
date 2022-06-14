package com.test.programming.toptal

fun main() {
    var input ="1-23-45 6"
    println( phoneNumberFormat(input) )

    input ="123 4-567"
    println( phoneNumberFormat(input) )

    input ="123 4-5678"
    println( phoneNumberFormat(input) )

    input ="00-44 48 5555 8361"
    println( phoneNumberFormat(input) )

    input ="0 - 22 1985--324"
    println( phoneNumberFormat(input) )

    input ="555372654"
    println( phoneNumberFormat(input) )
}

fun phoneNumberFormat(input:String) : String {
    val reformatString = StringBuffer("")
    var length = input.length

    for(i in 0 until length) {
        if(input[i].isDigit())
            reformatString.append(input[i])
    }
    length = reformatString.length

    when {
        length <=3 -> return reformatString.toString()
        length == 4 -> return reformatString.insert(2, '-').toString()
        else -> {
            var i = 3
            while (i < reformatString.length) {
                reformatString.insert(i, '-')
                i++
                val remainLength = (reformatString.length - i)
                i += when {
                    remainLength <= 3 -> {
                        remainLength
                    }
                    remainLength == 4 -> {
                        2
                    }
                    else -> {
                        3
                    }
                }
            }
        }
    }
    return reformatString.toString()
}