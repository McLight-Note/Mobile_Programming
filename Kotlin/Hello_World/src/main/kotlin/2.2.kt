fun main(){
    val max = getMax1(15,3)
    println(max)
}
fun getMax1(a:Int,b:Int): Int{
//    val max = if(a>b) a else b
//    return max
//    if (a>b){
//        return a
//    } else {
//        return b
//    }
    return if (a > b) a else b
}