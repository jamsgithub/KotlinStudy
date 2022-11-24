package com.myself.test

/**
 * @Created by Jams
 * @Created time 2022/11/22 14:58
 * @dese todo
 * \n
 * @UpUser by Lenovo
 * @UpDate 2022/11/22 14:58
 * @dese todo
 */
fun main() {

    backingProperty()
//    allProperty()

//    nullType()

//    copy();




}

fun backingProperty() {
    val backingProperty = BackingProperty("zhangsan")
    println("幕后字段的值为：${backingProperty.name}")
    backingProperty.name = "lisi"
    println("幕后字段的值为：${backingProperty.name}")
    backingProperty.sex = "男"
}

fun allProperty() {
    val student = Student("zhangsan", 22, "nan")
//    var name:String =""
//    var age:Int = 0
//    var sex:String =""
    val (name, age, sex) = student
}


var nullStr : String? = null
fun nullType() {
    val nullType = NullType()

    /*if (nullStr != null) {
        println(nullStr.length) //这种nullStr会报错NUll
    }*/

    //UninitializedPropertyAccessException: lateinit property name has not been initialized
    /*if (nullType.name != null) {
        println(nullType.name)
    }*/
    //调整成
    if (nullType.isNameInit()) {
        println(nullType.name)
    }
}

/**
 * 幕后字段：
 *   定义：在kotlin中定义一个普通属性时，会为该属性生成一个field，getter，setter，其中field就被成为幕后字段
 *          (backing field)
 *   何时会生成幕后字段?
 *      对于val|var属性：
 *          kotlin 自动生成了setter|getter     产生幕后字段
 *          重写了setter|getter                不产生幕后字段
 *          重写了setter|getter 中使用了field   产生幕后字段
 *   幕后属性：
 *      使用private修饰的属性，就是幕后属性
 *
 *   延迟初始化属性lateinit
 *      kotlin要求所有属性必须由程序员显示初始化
 *          定义式初始化
 *          在构造器中赋值初始化
 *      所以例如Activity里面的控件，都要用lateinit修饰
 *
 *
 * lateinit限制规则：
 *  1. lateinit只能修饰var的属性
 *  2. lateinit修饰的属性不能有自定义的getter或者setter方法
 *  3. lateinit修饰的属性必须是非空类型
 *  4. lateinit修饰的属性不能是原生类型(java的8种基本类型)
 *  另外kotlin不会为属性执行默认初始化
 */
class BackingProperty(str : String) {
    private var _name = str //_name是字段
    var name : String  // name 是属性，不保存状态
    get() = _name
    set(value) {
        _name = value
    }
    lateinit var sex:String
}

data class Student(val name:String, val age:Int = 18, val sex:String)/* {
    operator fun component1():String = this.name
    operator fun component2():Int = this.age
    operator fun component3():String = this.sex
}*/

class NullType{
    lateinit var name:String
    lateinit var sex: String

    fun isNameInit():Boolean{
        return ::name.isInitialized
    }
}

fun copy() {
    var dest = arrayOfNulls<Number>(3)
    val src = arrayOf(1,2,3)

    println("dest's size: ${dest.size}")

    copyIn(dest, src)

    copyOut(dest,src)
}

// 逆变
fun <T> copyIn(dest:Array<in T>, src:Array<T>) {
    src.forEachIndexed { index, value ->
        println("index: $index, value: $value")
        dest[index] = value
    }
}

// 协变
fun <T> copyOut(dest:Array<T>, src:Array<out T>) {
    src.forEachIndexed { index, value ->
        dest[index] = value
    }
}