package com.myself.kotlinstudy.bean

/**
 * @Created by Jams
 * @Created time 2022/11/24 15:57
 * @dese todo
 * \n
 * @UpUser by Lenovo
 * @UpDate 2022/11/24 15:57
 * @dese todo
 */
data class LoginBean(var admin:Boolean, var chapterTops:List<*>, var coinCount:Int, var collectIds:List<*>,
                     var email:String, var icon:String, var id:String, var nickname:String, var password:String,
                     var publicName:String, var token:String, var type:Int, var username:String)

//"admin": false,
//"chapterTops": [],
//"coinCount": 10,
//"collectIds": [],
//"email": "",
//"icon": "",
//"id": 38462,
//"nickname": "roger",
//"password": "",
//"publicName": "roger",
//"token": "",
//"type": 0,
//"username": "roger"
