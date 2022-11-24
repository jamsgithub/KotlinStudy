package com.myself.test

/**
 * @Created by Jams
 * @Created time 2022/11/17 14:50
 * @dese todo
 * \n
 * @UpUser by Lenovo
 * @UpDate 2022/11/17 14:50
 * @dese todo
 */
data class User(var name:String, val age:Int, val linkMap:LinkedHashMap<String, ArrayList<Person>>)/* {
    private var name: String? = null
    private var age = 0

    fun getName(): String? {
        return name
    }

    fun setName(name: String?) {
        this.name = name
    }

    fun getAge(): Int {
        return age
    }

    fun setAge(age: Int) {
        this.age = age
    }
}*/