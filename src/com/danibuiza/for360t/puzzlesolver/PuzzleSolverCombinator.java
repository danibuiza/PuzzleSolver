package com.danibuiza.for360t.puzzlesolver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * This class produces all possible combination for a given puzzle, that is all possible
 * combinations of pieces, for a puzzle with 6 parts, these are 120 combinations, assuming that one
 * the pieces has to remain fixed in the same position
 * 
 * @author Daniel Gutierrez Diez
 */
public class PuzzleSolverCombinator
{

    /**
     * Returns all possible combinations for the given puzzle stored in a {@link List}
     * 
     * @param puzzle
     * @return List<PuzzlePiece[]>
     */
    public static List<PuzzlePiece[]> getAllCombinations( Puzzle puzzle )
    {
        List<PuzzlePiece[]> combinations = new ArrayList<PuzzlePiece[]>();

        if( puzzle != null && puzzle.getPieces() != null && puzzle.getFixedPiece() != null )
        {
            combine( puzzle.getFixedPiece(), null, puzzle.getNotFixedPieces(), combinations );
        }
        return combinations;
    }

    /**
     * returns all combinations using recursion
     * 
     * @param piece
     * @param prefix
     * @param suffix
     * @param results
     * @return PuzzlePiece[]
     */
    private static PuzzlePiece[] combine( PuzzlePiece piece, PuzzlePiece[] prefix, PuzzlePiece[] suffix,
            List<PuzzlePiece[]> results )
    {
        if( suffix != null && results != null )
        {

            int n = suffix.length;
            if( n == 0 )
            {
                int i = 0;
                PuzzlePiece[] resultsPieces = new PuzzlePiece[prefix.length + 1];
                resultsPieces[i++] = piece;
                for( PuzzlePiece prefixPiece : prefix )
                {

                    resultsPieces[i++] = prefixPiece;
                }

                results.add( resultsPieces );
            }
            else
            {
                for( int i = 0; i < n; i++ )
                {
                    combine( piece, addElement( prefix, suffix, i ), deleteElement( suffix, i ), results );
                }

            }

        }
        return null;
    }

    private static PuzzlePiece[] addElement( PuzzlePiece[] prefix, PuzzlePiece[] suffix, int pos )
    {
        PuzzlePiece[] result = null;
        if( suffix != null && suffix.length > pos )
        {
            PuzzlePiece element = suffix[pos];

            if( prefix == null )
            {
                result = new PuzzlePiece[] { element };
            }
            else
            {
                List<PuzzlePiece> list = new LinkedList<PuzzlePiece>( Arrays.asList( prefix ) );
                list.add( element );

                result = new PuzzlePiece[list.size()];
                int i = 0;
                for( Object member : list )
                {
                    result[i++] = (PuzzlePiece)member;
                }

            }
        }

        return result;
    }

    private static PuzzlePiece[] deleteElement( PuzzlePiece[] suffix, int pos )
    {
        PuzzlePiece[] result = null;
        if( suffix != null && suffix.length > 0 )
        {
            result = new PuzzlePiece[suffix.length - 1];
            for( int i = 0, j = 0; i < suffix.length; ++i )
            {
                if( i != pos )
                {
                    result[j++] = suffix[i];
                }
            }
        }

        return result;
    }

}
