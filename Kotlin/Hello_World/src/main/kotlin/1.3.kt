fun main(){
    val x = 5.0f
    var y = 3
    val result: Float = x + y
    println("$result")
    println("x + y = ${x + y}")
    println("x - y = ${x - y}")
    println("x * y = ${x * y}")
    println("x / y = ${x / y}")
    y = 0
    println("y++ = ${y++}")
    println("y-- = ${y--}")

    val isActive = true
    if(isActive){
        println("Is active")}
    else if(x > 3){
        println("x > 3")
    }
    else{
        println("Is not active")
    }

    val myNumber = 100
    if(myNumber < 150){
        println("Less then 150")
    }else if(myNumber >= 150){
        println("More then 150")
    }else{
        println("All conditions are failed")
    }
}