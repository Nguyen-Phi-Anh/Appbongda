package com.example.appbongda
class DataClass {
    var dataName: String? = null
    var dataDesc: String? = null
    var dataPosition: String? = null
    var dataImage: String? = null
    var dataImage2: String? = null
    constructor(dataName: String?, dataDesc: String?, dataPosition: String?, dataImage: String?,dataImage2: String?){
        this.dataName = dataName
        this.dataDesc = dataDesc
        this.dataPosition = dataPosition
        this.dataImage = dataImage
        this.dataImage2 = dataImage2
    }
    constructor()
    {}
}