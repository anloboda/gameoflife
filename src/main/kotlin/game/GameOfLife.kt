package game

import game.rule.*

class GameOfLife(
    private val size: Int, private val pattern: GamePattern
) {
    private var field: Field = Field(size, pattern)
    private val rules: List<Rule> =
        listOf(OvercrowdingRule(), ReproductionRule(), UnderpopulationRule())

    fun nextGeneration() {
        val updatedCells = field.getCells().mapIndexed { rowIndex, row ->
            row.mapIndexed { columnIndex, cell ->
                val ruleToApply = rules.find {
                    it.isApplicable(
                        cell = cell,
                        neighbors = field.getNeighbors(rowIndex, columnIndex)
                    )
                }
                ruleToApply?.nextState ?: cell
            }.toTypedArray()
        }.toTypedArray()
        field.setCells(updatedCells)
    }

    fun getCells() = field.getCells()

    fun reset() {
        field = Field(size, pattern)
    }
}