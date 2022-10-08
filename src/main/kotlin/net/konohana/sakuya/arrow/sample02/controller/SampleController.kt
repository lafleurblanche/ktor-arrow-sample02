package net.konohana.sakuya.arrow.sample02.controller

import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get
import io.ktor.server.routing.route
import net.konohana.sakuya.arrow.sample02.utils.check

fun Route.sampleController() {
    route("sample") {
        get("/{data}") {
            val data = call.parameters["data"] ?: "FRCE0000"
            println(data)
            val res = check(data)
            println(res)
            call.respond(mapOf("result" to res))
        }
    }
}
