package com.danibuiza.for360t.puzzlesolver;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class PuzzleQuickSolverTest
{

    private Puzzle puzzleUnsolved;
    private Puzzle puzzleSolved;
    private Puzzle puzzleSolvedRotated;
    private Puzzle puzzleNoSolution;

    @Before
    public void setUp() throws IOException
    {
        String fileName = "tests/puzzles/puzzleUnsolved.txt";

        puzzleUnsolved = new Puzzle();
        puzzleUnsolved.readFile( fileName );
        puzzleUnsolved.drawPieces();

        String fileName2 = "tests/puzzles/puzzleSolved.txt";

        puzzleSolved = new Puzzle();
        puzzleSolved.readFile( fileName2 );
        puzzleSolved.drawPieces();

        String fileName3 = "tests/puzzles/puzzleNoSolution.txt";

        puzzleNoSolution = new Puzzle();
        puzzleNoSolution.readFile( fileName3 );
        puzzleNoSolution.drawPieces();

        String fileName4 = "tests/puzzles/PuzzleUnSolved2.txt";

        puzzleSolvedRotated = new Puzzle();
        puzzleSolvedRotated.readFile( fileName4 );
        puzzleSolvedRotated.drawPieces();
    }

    @Test
    public void testSolveAllSolutions()
    {
        PuzzlePiece[] result = PuzzleQuickSolver.getSolution( puzzleUnsolved );

        assertNotNull( result );

    }

    @Test
    public void testSolveRotatedAllSolutions()
    {
        PuzzlePiece[] result = PuzzleQuickSolver.getSolution( puzzleSolvedRotated );

        assertNotNull( result );

    }

    @Test
    public void testSolveAllSolutionsSolved()
    {
        PuzzlePiece[] result = PuzzleQuickSolver.getSolution( puzzleSolved );

        assertNotNull( result );

    }

    @Test
    public void testSolveAllSolutionsNoSolution()
    {
        PuzzlePiece[] result = PuzzleQuickSolver.getSolution( puzzleNoSolution );

        assertNull( result );

    }
}
