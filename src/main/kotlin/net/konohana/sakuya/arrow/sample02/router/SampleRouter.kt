package net.konohana.sakuya.arrow.sample02.router

import io.ktor.server.routing.Route
import net.konohana.sakuya.arrow.sample02.controller.sampleController

fun Route.sampleRouter() {
    sampleController()
}
