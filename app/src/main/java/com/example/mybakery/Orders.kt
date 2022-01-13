package com.example.mybakery

class Orders {

    var id : Int = 0
    var flavour : String = ""
    var color : String = ""
    var size : Int = 0

    constructor(flavour:String,color:String,size:Int){
         this.flavour=flavour
        this.color=color
        this.size=size
    }

}