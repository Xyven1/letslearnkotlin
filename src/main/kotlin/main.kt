import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import io.javalin.Javalin


fun main() = runBlocking { // this: CoroutineScope
    val app = Javalin.create()
    app.get("/"){ ctx -> ctx.result("home")}

    launch{
        app.start(3000)
    }
    println("Hello") // main coroutine continues while a previous one is delayed
}
data class Message(var username:String, var password: String)