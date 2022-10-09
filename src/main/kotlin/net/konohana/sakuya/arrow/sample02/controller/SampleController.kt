package net.konohana.sakuya.arrow.sample02.controller

import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.route
import net.konohana.sakuya.arrow.sample02.constant.ErrorCodeConst
import net.konohana.sakuya.arrow.sample02.exception.CodeMismatchException
import net.konohana.sakuya.arrow.sample02.utils.check

fun Route.sampleController() {
    route("sample") {
        get("/{data}") {
            val data = call.parameters["data"] ?: "FRCE0000"
            println(data)
            val rst = check(data)
            println(rst)
            if (rst == ErrorCodeConst.ERROR_101) {
                throw CodeMismatchException("コード形式誤り")
            }
            call.respond(mapOf("result" to rst))
        }
    }
}