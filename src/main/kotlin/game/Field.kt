package game

class Field(private val size: Int, pattern: GamePattern) {

    private var cells: Array<Array<Cell>> = initCells()

    init {
        setPattern(pattern)
    }

    fun getCells(): Array<Array<Cell>> = cells.copyOf()

    fun setCells(cells: Array<Array<Cell>>) {
        this.cells = cells
    }

    fun getNeighbors(row: Int, column: Int): List<Cell> {
        val neighbors = mutableListOf<Cell>()
        for (i in -1..1) {
            for (j in -1..1) {
                val neighborRow = row + i
                val neighborColumn = column + j
                if (isCurrentCell(i, j)) continue
                if (isCellInFieldBounds(neighborRow, neighborColumn)) {
                    neighbors.add(cells[neighborRow][neighborColumn])
                }
            }
        }
        return neighbors
    }

    private fun isCurrentCell(i: Int, j: Int) = i == 0 && j == 0

    private fun isCellInFieldBounds(neighborRow: Int, neighborColumn: Int) =
        neighborRow in 0 until size && neighborColumn in 0 until size

    private fun initCells(): Array<Array<Cell>> = Array(size) { Array(size) { DeadCell } }

    private fun setPattern(pattern: GamePattern) {
        val startRow = (size - pattern.configuration.size) / 2
        val startColumn = (size - pattern.configuration[0].size) / 2

        pattern.configuration.indices.forEach { i ->
            pattern.configuration[i].indices.forEach { j ->
                cells[startRow + i][startColumn + j] = pattern.configuration[i][j]
            }
        }
    }
}

