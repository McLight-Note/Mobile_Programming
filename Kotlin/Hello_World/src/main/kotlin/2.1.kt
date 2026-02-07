fun main() {
    // first part
//    val num1 = -5
//    val num2 = 0
//    val text = if (num1 > 0 || num2 > 0) "This is text 1" else "This is text 2"
//    println("$text")

    // second part NULL
//    var text: String? = null
//
//    val text2: Any = text ?: "Some text"
//    println(text2)
//
//    var text3: String = text ?: "The variable is null."
//    println(text3)

    // Third Part Functions
    sayHello("John", 25)

    val hasInternetConnection = false
    if (hasInternetConnection) {
        getData("Some data")
    } else {
      showMessage()
    }

}
fun sayHello(name:String, age:Int){
    var number=age
    number=14
    println("Hello, $name" + "$age")
}
fun getData(data:String){
    println("Your data is $data")
}
fun showMessage(){
    println("There is no Internet Connection")
}