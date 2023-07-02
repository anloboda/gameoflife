package game

import game.transition.OvercrowdingTransition
import game.transition.ReproductionTransition
import game.transition.SurvivalTransition
import game.transition.UnderpopulationTransition
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.withContext

class GameOfLife(size: Int, pattern: GamePattern) {
    private var grid: Grid = Grid(size, pattern)
    private val transitions =
        listOf(OvercrowdingTransition, ReproductionTransition, SurvivalTransition, UnderpopulationTransition)

    suspend fun nextGeneration() {
        withContext(Dispatchers.Default) {
            val updatedCells = grid.getCells()
                .mapIndexed { rowIndex, row ->
                    async { processRow(rowIndex, row) }
                }.awaitAll().toTypedArray()
            grid.setCells(updatedCells)
        }
    }

    fun getCells() = grid.getCells()

    fun reset(size: Int, pattern: GamePattern) {
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