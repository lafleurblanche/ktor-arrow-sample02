package net.konohana.sakuya.arrow.sample02

import io.ktor.server.application.Application
import net.konohana.sakuya.arrow.sample02.plugins.configureHTTP
import net.konohana.sakuya.arrow.sample02.plugins.configureRouting
import net.konohana.sakuya.arrow.sample02.plugins.configureSerialization


fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    configureSerialization()
    configureHTTP()
    configureRouting()
}
