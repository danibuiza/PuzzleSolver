package com.danibuiza.for360t.puzzlesolver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

public class PuzzleSolverCombinatorTest
{

    @Test
    public void testOneSolutions()
    {
        PuzzlePiece[] pieces = new PuzzlePiece[] { new PuzzlePiece( "b" ), new PuzzlePiece( "c" ),
                new PuzzlePiece( "d" ), new PuzzlePiece( "e" ), new PuzzlePiece( "e" ) };

        Puzzle puzzle = new Puzzle();
        puzzle.setPieces( pieces );

        List<PuzzlePiece[]> results = PuzzleSolverCombinator.getAllCombinations( puzzle );

        assertNotNull( results );
        assertEquals( 120, results.size() );

        List<PuzzlePiece[]> resultsNull = PuzzleSolverCombinator.getAllCombinations( null );

        assertNotNull( resultsNull );
        assertEquals( 0, resultsNull.size() );

    }
}
