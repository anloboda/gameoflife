package game

sealed class Cell
object LiveCell : Cell()
object DeadCell : Cell()

fun Cell.isAlive() = this is LiveCell
fun Cell.isDead() = this is DeadCell