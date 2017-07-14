package com.example.mario.deleteme

import java.io.Serializable

/**
 * Created by mario on 13/07/17.
 */
data class Person(var name : String,var age : Int) : Serializable{
    override fun toString(): String {
        return "$name - $age"
    }
}