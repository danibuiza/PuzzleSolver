package com.danibuiza.for360t.puzzlesolver;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class PuzzlePieceTest
{

    private Puzzle puzzle;

    @Before
    public void setUp() throws IOException
    {
        String fileName = "tests/puzzles/puzzleUnsolved.txt";

        puzzle = new Puzzle();
        puzzle.readFile( fileName );
        puzzle.drawPieces();
    }

    @Test
    public void testRotate()
    {
        PuzzlePiece a = puzzle.getPiece( 0 );
        PuzzlePiece b = puzzle.getPiece( 1 );

        char a0 = a.points[0];
        char a15 = a.points[15];
        char a9 = a.points[9];

        char b0 = b.points[0];
        char b15 = b.points[15];
        char b9 = b.points[9];

        a.rotate();
        b.rotate();

        char a0rot = a.points[4];
        char a15rot = a.points[3];
        char a9rot = a.points[13];

        char b0rot = b.points[4];
        char b15rot = b.points[3];
        char b9rot = b.points[13];

        assertTrue( a0 == a0rot );
        assertTrue( a15 == a15rot );
        assertTrue( b0 == b0rot );
        assertTrue( b15 == b15rot );
        assertTrue( a9 == a9rot );
        assertTrue( b9 == b9rot );

        a.rotate();
        b.rotate();

        a.rotate();
        b.rotate();

        a.rotate();
        b.rotate();

        char a0rot4 = a.points[0];
        char a15rot4 = a.points[15];

        char b0rot4 = b.points[0];
        char b15rot4 = b.points[15];

        char a9rot4 = a.points[9];
        char b9rot4 = b.points[9];

        assertTrue( a0 == a0rot4 );
        assertTrue( a15 == a15rot4 );
        assertTrue( b0 == b0rot4 );
        assertTrue( b15 == b15rot4 );

        assertTrue( a9 == a9rot4 );
        assertTrue( b9 == b9rot4 );

    }

}
