package net.konohana.sakuya.arrow.sample02.utils

import arrow.core.Either
import net.konohana.sakuya.arrow.sample02.constant.ErrorCodeConst
import net.konohana.sakuya.arrow.sample02.constant.FromStaCodePatternConst

open class Error {
    object NotANumber : Error()
    object NotACode : Error()
}

fun stringify(s:String): Either<Error, String> =
    if (!s.startsWith(FromStaCodePatternConst.CODE_PATTERN_CERISIER)) Either.Left(Error.NotACode)
    else if (s.length != 8) Either.Left(Error.NotACode)
    else Either.Right(s.substring(4,8))

fun check(s: String): String {
    println("check${s}")
    val res = when(val result = stringify(s)) {
        is Either.Right -> {
            result.value
        }
        is Either.Left -> when (result.value) {
            is Error.NotACode -> ErrorCodeConst.ERROR_101
            else -> ""
        }
    }
    println(res)
    return res
}

fun checkNumber(s: String): String {
    println("checkvalue${s}")
    val res2 = when(val result = parse(s)) {
        is Either.Left -> when (result.value) {
            is Error.NotANumber -> ErrorCodeConst.ERROR_102
            else -> ""
        }
        is Either.Right -> {
            result.value.toString()
        }
    }
    print(res2)
    return res2
}

fun parse(s:String): Either<Error, Int> =

    if (s.matches(Regex("-?[0-9]+"))) Either.Right(s.toInt())

    else Either.Left(Error.NotANumber)