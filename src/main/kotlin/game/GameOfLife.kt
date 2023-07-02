package game

import game.transition.OvercrowdingTransition
import game.transition.ReproductionTransition
import game.transition.SurvivalTransition
import game.transition.UnderpopulationTransition

class GameOfLife(
    private val size: Int,
    private val pattern: GamePattern
) {
    private var grid: Grid = Grid(size, pattern)
    private val transitions =
        listOf(OvercrowdingTransition(), ReproductionTransition(), SurvivalTransition(), UnderpopulationTransition())

    fun nextGeneration() {
        val updatedCells = grid.getCells()
            .mapIndexed { rowIndex, row ->
                processRow(rowIndex, row)
            }.toTypedArray()
        grid.setCells(updatedCells)
    }

    fun getCells() = grid.getCells()

    fun reset(pattern: GamePattern) {
        grid = Grid(size, pattern)
    }

    private fun processRow(rowIndex: Int, row: Array<Cell>) =
        row.mapIndexed { columnIndex, cell ->
            getNextGenerationCell(cell, rowIndex, columnIndex)
        }.toTypedArray()

    private fun getNextGenerationCell(cell: Cell, rowIndex: Int, columnIndex: Int): Cell {
        val transition = transitions.find {
            it.isApplicable(
                cell = cell,
                neighbors = grid.getNeighbors(rowIndex, columnIndex)
            )
        }
        return transition?.nextGeneration ?: cell
    }
}