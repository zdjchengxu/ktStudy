package indi.zdj.kotlinstudy.entity

class TestInitEntity {

    init {
        var tiger = Animal("tiger")
        var bird = Animal("bird","female")
        var lion = Animal("lion","male","狮子")

        var tigerHigher =  AnimalHigher("tigher")
        var birdHigher = AnimalHigher("bird","female")
        var lionHigher = AnimalHigher("lion","male","狮子")



    }

}