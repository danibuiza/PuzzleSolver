package com.danibuiza.for360t.puzzlesolver;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class PuzzleAllSolverTest
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
        List<PuzzlePiece[]> result = PuzzleAllSolver.getAllSolutions( puzzleUnsolved );

        assertNotNull( result );

        assertEquals( 192, result.size() );

    }

    @Test
    public void testSolveRotatedAllSolutions()
    {
        List<PuzzlePiece[]> result = PuzzleAllSolver.getAllSolutions( puzzleSolvedRotated );

        assertNotNull( result );

        assertEquals( 192, result.size() );

    }

    @Test
    public void testSolveAllSolutionsSolved()
    {
        List<PuzzlePiece[]> result = PuzzleAllSolver.getAllSolutions( puzzleSolved );

        assertNotNull( result );

        assertEquals( 192, result.size() );

    }

    @Test
    public void testSolveAllSolutionsNoSolution()
    {
        List<PuzzlePiece[]> result = PuzzleAllSolver.getAllSolutions( puzzleNoSolution );

        assertNotNull( result );

        assertEquals( 0, result.size() );

    }
}
