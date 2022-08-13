package model

abstract class Item(val name: String, val quantity: Int, val imported: Boolean){

}

class Book(name: String, quantity: Int, imported:Boolean) : Item(name,quantity,imported) {

}

class Food(name: String, quantity: Int, imported: Boolean) : Item(name,quantity,imported) {

}

class Other(name: String, quantity: Int, imported: Boolean) : Item(name,quantity,imported){

}

class Medical(name: String, quantity: Int, imported: Boolean): Item(name, quantity,imported) {

}