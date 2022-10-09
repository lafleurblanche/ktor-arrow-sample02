package net.konohana.sakuya.arrow.sample02.plugins

import io.ktor.http.HttpStatusCode
import io.ktor.server.application.Application
import io.ktor.server.application.call
import io.ktor.server.application.install
import io.ktor.server.plugins.statuspages.StatusPages
import io.ktor.server.response.respond
import io.ktor.server.response.respondText
import io.ktor.server.routing.get
import io.ktor.server.routing.routing
import net.konohana.sakuya.arrow.sample02.constant.ErrorMessageConst
import net.konohana.sakuya.arrow.sample02.exception.CodeMismatchException

fun Application.configureRouting() {
    install(StatusPages) {
        exception<CodeMismatchException> { call, _ ->
            call.respond(HttpStatusCode.BadRequest, mapOf("result" to ErrorMessageConst.ERROR_MSG_CODE_MISMATCH))
        }
    }

    routing {
        get("/") {
            call.respondText("Hello World!")
        }
    }
}
