package com.danibuiza.for360t.puzzlesolver;

import java.util.ArrayList;
import java.util.List;

/**
 * This class produces all possible solutions for a given puzzle.
 * 
 * @author Daniel Gutierrez Diez
 */
public class PuzzleAllSolver
{

    // this makes this class non thread save
    static List<PuzzlePiece[]> solutions = null;

    /**
     * Returns all possible solutions for a puzzle stored in a {@link List}
     * 
     * @param puzzle
     * @return a list with all possible solutions, empty if nothing is found
     */
    public static List<PuzzlePiece[]> getAllSolutions( Puzzle puzzle )
    {
        // retrieve of all possible combination for the 6 parts of the puzzle (one piece is always
        // fixed -> 120 possible combinations)
        List<PuzzlePiece[]> combinations = PuzzleSolverCombinator.getAllCombinations( puzzle );

        solutions = new ArrayList<PuzzlePiece[]>();
        for( PuzzlePiece[] combination : combinations )
        {
            // for each combination a list of solutions is provided
            solve( copy( combination ) );

        }
        return solutions;
    }

    /**
     * Copies all pieces of the puzzle in a temporary array
     * 
     * @param combination
     * @return PuzzlePiece[]
     */
    private static PuzzlePiece[] copy( PuzzlePiece[] combination )
    {
        PuzzlePiece[] copy = new PuzzlePiece[6];

        int i = 0;
        for( PuzzlePiece piece : combination )
        {
            copy[i++] = new PuzzlePiece( piece );
        }
        return copy;
    }

    /**
     * Checks all possible rotations and turns for a given combination
     * 
     * @param combination
     */
    private static void solve( PuzzlePiece[] combination )
    {
        for( int t1 = 0; t1 < 2; ++t1 )
        {
            combination[1].turn();

            for( int i = 0; i < 4; i++ )
            {

                combination[1].rotate();
                for( int t2 = 0; t2 < 2; ++t2 )
                {
                    combination[2].turn();
                    for( int j = 0; j < 4; j++ )
                    {
                        combination[2].rotate();
                        for( int t3 = 0; t3 < 2; ++t3 )
                        {
                            combination[3].turn();
                            for( int k = 0; k < 4; k++ )
                            {
                                combination[3].rotate();
                                for( int t4 = 0; t4 < 2; ++t4 )
                                {
                                    combination[4].turn();
                                    for( int m = 0; m < 4; m++ )
                                    {
                                        combination[4].rotate();
                                        for( int t5 = 0; t5 < 2; ++t5 )
                                        {
                                            combination[5].turn();
                                            for( int n = 0; n < 4; n++ )
                                            {
                                                combination[5].rotate();
                                                check( combination );

                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * if the combination is valid, it is added to the list of results
     * 
     * @param combination
     */
    private static void check( PuzzlePiece[] combination )
    {

        if( PuzzleSolverValidator.isValid( combination, 5 ) )
        {
            solutions.add( combination );
        }

    }
}
