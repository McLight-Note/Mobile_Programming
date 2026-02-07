fun main(args: Array<String>) {
    sendMessage("Alexa")
}
fun sendMessage(name:String = "User",message:String = sendText()){
    println("$name - $message")
}
fun sendText(): String{
    return "Some text!"
}