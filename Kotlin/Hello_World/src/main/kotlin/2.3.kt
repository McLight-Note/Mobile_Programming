fun main(){
    val max = getMax(15, 3, 100)
    println(max)
}
fun getMax(a:Int,b:Int) = if (a > b) a else b
fun getMax(a: Double, b: Double) = if (a > b) a else b
fun getMax(a:Int,b:Int, c: Int): Int {
    return if (a >= b && a >= c) {
        a
    } else if (a <= b && a <= c) {
        b
    } else {
        c
    }
}