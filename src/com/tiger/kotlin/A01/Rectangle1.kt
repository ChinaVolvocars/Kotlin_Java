package com.tiger.kotlin.A01

class Rectangle1 {
    var name: String = "Holmes, Sherlock"
    var street: String = "Baker"
    var city: String = "London"
    var state: String? = null
    var zip: String = "123456"

    override fun toString(): String {
        return "Rectangle1(name='$name', street='$street', city='$city', state=$state, zip='$zip')"
    }


}