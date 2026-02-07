fun main(args: Array<String>) {
    println(sum(3,4,5,6,2,3,4,5,1,))
}
fun sum(vararg numbers: Int) : Int{
    var result = 0
    for (number in numbers) {
        result += number
    }
    return result
}