package com.example.appbongda
class DataTranDau {
    var dataTeam1: String? = null
    var dataTeam2: String? = null
    var dataMota: String? = null
    var dataImage: String? = null
    var dataImage2: String? = null
    constructor(dataTeam1: String?, dataTeam2: String?, dataMota: String?, dataImage: String?,dataImage2: String?){
        this.dataTeam1 = dataTeam1
        this.dataTeam2 = dataTeam2
        this.dataMota = dataMota
        this.dataImage = dataImage
        this.dataImage2 = dataImage2
    }
    constructor()
    {}
}