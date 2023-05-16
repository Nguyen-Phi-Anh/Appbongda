package com.example.appbongda

class DataClb {
    var dataName: String? = null
    var dataDesc: String? = null
    var dataTournament: String? = null
    var dataImage: String? = null
    var dataImage2: String? = null
    constructor(dataName: String?, dataDesc: String?, dataTournament: String?, dataImage: String?,dataImage2: String?){
        this.dataName = dataName
        this.dataDesc = dataDesc
        this.dataTournament = dataTournament
        this.dataImage = dataImage
        this.dataImage2 = dataImage2
    }
    constructor()
    {}
}