import io.javalin.Javalin
import io.javalin.websocket.WsConfig
import kotlinx.coroutines.*

fun main() = runBlocking { // this: CoroutineScope
    val app = Javalin.create()
    app.get("/"){ ctx -> ctx.result("home")}
    app.ws("/api") {ws -> handleWs(ws)}
    launch{
        app.start(3000)
    }
    println("Hello") // main coroutine continues while a previous one is delayed
}

fun handleWs(ws: WsConfig) {
    ws.onConnect { session ->
        println("userConnected")
    }
}
