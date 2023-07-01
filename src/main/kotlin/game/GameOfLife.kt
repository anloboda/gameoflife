package game

import game.transition.OvercrowdingTransition
import game.transition.ReproductionTransition
import game.transition.SurvivalTransition
import game.transition.Transition
import game.transition.UnderpopulationTransition

class GameOfLife(
    private val size: Int,
    private val pattern: GamePattern
) {
    private var grid: Grid = Grid(size, pattern)
    private val rules: List<Transition> =
        listOf(OvercrowdingTransition(), ReproductionTransition(), SurvivalTransition(), UnderpopulationTransition())

    fun nextGeneration() {
        val updatedCells = grid.getCells().mapIndexed { rowIndex, row ->
            row.mapIndexed { columnIndex, cell ->
                val rule = rules.find {
                    it.isApplicable(
                        cell = cell,
                        neighbors = grid.getNeighbors(rowIndex, columnIndex)
                    )
                }
                rule?.nextState ?: cell
            }.toTypedArray()
        }.toTypedArray()
        grid.setCells(updatedCells)
    }

    fun getCells() = grid.getCells()

    fun reset() {
        grid = Grid(size, pattern)
    }
}