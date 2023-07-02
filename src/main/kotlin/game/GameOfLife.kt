package game

import game.transition.OvercrowdingTransition
import game.transition.ReproductionTransition
import game.transition.SurvivalTransition
import game.transition.UnderpopulationTransition
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlin.system.measureTimeMillis

class GameOfLife(size: Int, pattern: GamePattern) {
    private var grid: Grid = Grid(size, pattern)
    private val transitions =
        listOf(OvercrowdingTransition(), ReproductionTransition(), SurvivalTransition(), UnderpopulationTransition())

    suspend fun nextGeneration() {
        val time = measureTimeMillis {
            val updatedCells =
                coroutineScope {
                    grid.getCells()
                        .mapIndexed { rowIndex, row ->
                            async { processRow(rowIndex, row) }
                        }.awaitAll().toTypedArray()
                }

            grid.setCells(updatedCells)
        }
        println(time)
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