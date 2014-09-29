package com.danibuiza.for360t.puzzlesolver;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class PuzzleSolverValidatorTest
{

    private Puzzle puzzleUnsolved;
    private Puzzle puzzleSolved;
    private Puzzle puzzleNoSolution;
    private Puzzle puzzleSolvedRotated;

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
    public void testIsValidRotatedOnePiece()
    {
        PuzzlePiece[] pieces = new PuzzlePiece[] { puzzleSolvedRotated.getPiece( 0 ),
                puzzleSolvedRotated.getPiece( 1 ), puzzleSolvedRotated.getPiece( 2 ),
                puzzleSolvedRotated.getPiece( 3 ), puzzleSolvedRotated.getPiece( 4 ), puzzleSolvedRotated.getPiece( 5 ) };
        assertFalse( PuzzleSolverValidator.isValid( pieces, 5 ) );

        puzzleSolvedRotated.getPiece( 5 ).rotate();

        assertFalse( PuzzleSolverValidator.isValid( pieces, 5 ) );

        puzzleSolvedRotated.getPiece( 5 ).rotate();

        assertFalse( PuzzleSolverValidator.isValid( pieces, 5 ) );

        puzzleSolvedRotated.getPiece( 5 ).rotate();

        assertTrue( PuzzleSolverValidator.isValid( pieces, 5 ) );

    }

    @Test
    public void testIsValidNoSol()
    {
        PuzzlePiece[] pieces = new PuzzlePiece[] { puzzleNoSolution.getPiece( 0 ), puzzleNoSolution.getPiece( 1 ) };
        assertFalse( PuzzleSolverValidator.isValid( pieces, 1 ) );
    }

    @Test
    public void testIsValid1()
    {
        PuzzlePiece[] pieces = new PuzzlePiece[] { puzzleUnsolved.getPiece( 0 ), puzzleUnsolved.getPiece( 1 ) };
        assertTrue( PuzzleSolverValidator.isValid( pieces, 1 ) );
    }

    @Test
    public void testIsValid2()
    {
        PuzzlePiece[] pieces = new PuzzlePiece[] { puzzleUnsolved.getPiece( 0 ), puzzleUnsolved.getPiece( 1 ),
                puzzleUnsolved.getPiece( 2 ) };
        assertTrue( PuzzleSolverValidator.isValid( pieces, 2 ) );
    }

    @Test
    public void testIsValid3()
    {
        PuzzlePiece[] pieces = new PuzzlePiece[] { puzzleUnsolved.getPiece( 0 ), puzzleUnsolved.getPiece( 1 ),
                puzzleUnsolved.getPiece( 2 ), puzzleUnsolved.getPiece( 3 ) };
        assertFalse( PuzzleSolverValidator.isValid( pieces, 3 ) );
    }

    @Test
    public void testIsValid5()
    {
        PuzzlePiece[] pieces = new PuzzlePiece[] { puzzleUnsolved.getPiece( 0 ), puzzleUnsolved.getPiece( 5 ),
                puzzleUnsolved.getPiece( 2 ), puzzleUnsolved.getPiece( 4 ), puzzleUnsolved.getPiece( 1 ),
                puzzleUnsolved.getPiece( 3 ) };
        assertFalse( PuzzleSolverValidator.isValid( pieces, 5 ) );

        puzzleUnsolved.getPiece( 4 ).rotate();
        puzzleUnsolved.getPiece( 4 ).rotate();
        puzzleUnsolved.getPiece( 2 ).rotate();
        puzzleUnsolved.getPiece( 5 ).rotate();
        puzzleUnsolved.getPiece( 5 ).rotate();
        puzzleUnsolved.getPiece( 5 ).rotate();

        puzzleUnsolved.getPiece( 5 ).turn();
        puzzleUnsolved.getPiece( 4 ).turn();

        assertTrue( PuzzleSolverValidator.isValid( pieces, 5 ) );
    }

    @Test
    public void testIsValid11()
    {
        PuzzlePiece[] pieces = new PuzzlePiece[] { puzzleSolved.getPiece( 0 ), puzzleSolved.getPiece( 1 ) };

        assertTrue( PuzzleSolverValidator.isValid( pieces, 1 ) );
    }

    @Test
    public void testIsValid21()
    {
        PuzzlePiece[] pieces = new PuzzlePiece[] { puzzleSolved.getPiece( 0 ), puzzleSolved.getPiece( 1 ),
                puzzleSolved.getPiece( 2 ) };
        assertTrue( PuzzleSolverValidator.isValid( pieces, 2 ) );

    }

    @Test
    public void testIsValid31()
    {
        PuzzlePiece[] pieces = new PuzzlePiece[] { puzzleSolved.getPiece( 0 ), puzzleSolved.getPiece( 1 ),
                puzzleSolved.getPiece( 2 ), puzzleSolved.getPiece( 3 ) };
        assertTrue( PuzzleSolverValidator.isValid( pieces, 3 ) );
    }

    @Test
    public void testIsValid41()
    {
        PuzzlePiece[] pieces = new PuzzlePiece[] { puzzleSolved.getPiece( 0 ), puzzleSolved.getPiece( 1 ),
                puzzleSolved.getPiece( 2 ), puzzleSolved.getPiece( 3 ), puzzleSolved.getPiece( 4 ) };
        assertTrue( PuzzleSolverValidator.isValid( pieces, 4 ) );
    }

    @Test
    public void testIsValid51()
    {
        PuzzlePiece[] pieces = new PuzzlePiece[] { puzzleSolved.getPiece( 0 ), puzzleSolved.getPiece( 1 ),
                puzzleSolved.getPiece( 2 ), puzzleSolved.getPiece( 3 ), puzzleSolved.getPiece( 4 ),
                puzzleSolved.getPiece( 5 ) };

        assertTrue( PuzzleSolverValidator.isValid( pieces, 5 ) );
    }
}
