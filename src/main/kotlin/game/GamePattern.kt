package game

sealed class GamePattern(val configuration: Array<Array<Cell>>) {
    object GILDER : GamePattern(
        arrayOf(
            arrayOf(DeadCell, LiveCell, DeadCell),
            arrayOf(DeadCell, DeadCell, LiveCell),
            arrayOf(LiveCell, LiveCell, LiveCell)
        )
    )

    object REPEATABLE : GamePattern(
        arrayOf(
            arrayOf(DeadCell, LiveCell, DeadCell),
            arrayOf(DeadCell, LiveCell, DeadCell),
            arrayOf(DeadCell, LiveCell, DeadCell)
        )
    )

    object STABLE : GamePattern(
        arrayOf(
            arrayOf(LiveCell, LiveCell),
            arrayOf(LiveCell, LiveCell)
        )
    )

    object DISAPPEARING : GamePattern(
        arrayOf(
            arrayOf(LiveCell, DeadCell, DeadCell),
            arrayOf(DeadCell, LiveCell, DeadCell),
            arrayOf(DeadCell, DeadCell, LiveCell)
        )
    )
}