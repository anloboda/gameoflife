package game

enum class GamePattern(val configuration: Array<Array<Cell>>) {
    GLIDER(
        arrayOf(
            arrayOf(DeadCell, LiveCell, DeadCell),
            arrayOf(DeadCell, DeadCell, LiveCell),
            arrayOf(LiveCell, LiveCell, LiveCell)
        )
    )
}