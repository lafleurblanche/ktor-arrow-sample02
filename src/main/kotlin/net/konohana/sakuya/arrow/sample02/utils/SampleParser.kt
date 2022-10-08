package net.konohana.sakuya.arrow.sample02.utils

import arrow.core.Either

open class Error {
    object NotANumber : Error()
    object NotACode : Error()
}

fun stringify(s:String): Either<Error, String> =
    if (!s.startsWith("FRCE")) Either.Left(Error.NotACode)
    else if (s.length != 8) Either.Left(Error.NotACode)
    else Either.Right(s.substring(4,8))

fun check(s: String): String {
    println("check${s}")
    val res = when(val result = stringify(s)) {
        is Either.Right -> {
            result.value
        }
        is Either.Left -> when (result.value) {
            is Error.NotACode -> "コードでない"
            else -> ""
        }
    }
    println(res)
    return res
}



fun parse(s:String): Either<Error, Int> =

    if (s.matches(Regex("-?[0-9]+"))) Either.Right(s.toInt())

    else Either.Left(Error.NotANumber)