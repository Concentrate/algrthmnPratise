package KotlinPratise

/**
 * Created by liudeyu on 2017/5/26.
 */
fun main(args:Array<String>){
    var mArray= listOf("ab",1,"score")
    if(mArray.size !in 0..mArray.lastIndex){
        println("size not is the lastIndex")
    }
    for (tmp in mArray){
        println(tmp)
    }
    var fruits=listOf("apple","orange","banana","ada","ana")
    fruits.filter { it.startsWith("a") }.sortedBy { it }
            .map { it.toUpperCase() }.forEach { print(it+" ") }

}