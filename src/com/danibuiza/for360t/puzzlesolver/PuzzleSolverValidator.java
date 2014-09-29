package com.danibuiza.for360t.puzzlesolver;

/**
 * This class contains methods for validating a combination of puzzle pieces until a given position
 * 
 * @author Daniel Gutierrez Diez
 */
public class PuzzleSolverValidator
{

    /**
     * Validates the pieces until the index passed as parameter.
     * 
     * @param pieces
     * @param index
     * @return boolean true is is valid, false otherwise
     */
    public static boolean isValid( PuzzlePiece[] pieces, int index )
    {
        return isValidAB( pieces, index ) && isValidBC( pieces, index ) && isValidBD( pieces, index )
            && isValidDE( pieces, index ) && isValidEF( pieces, index ) && isValidFB( pieces, index )
            && isValidCD( pieces, index ) && isValidCF( pieces, index ) && isValidEC( pieces, index )
            && isValidAE( pieces, index ) && isValidAD( pieces, index ) && isValidAF( pieces, index );
    }

    private static boolean isValidAF( PuzzlePiece[] pieces, int index )
    {

        if( index >= 5 )
        {
            char[] pointsA = pieces[0].getPoints( 0, 1, 2, 3, 4 );
            char[] pointsF = pieces[5].getPoints( 0, 15, 14, 13, 12 );

            return isValidArista( pointsA, pointsF );
        }
        return true;

    }

    private static boolean isValidAD( PuzzlePiece[] pieces, int index )
    {
        if( index >= 3 )
        {

            char[] pointsA = pieces[0].getPoints( 12, 11, 10, 9, 8 );
            char[] pointsD = pieces[3].getPoints( 12, 13, 14, 15, 0 );

            return isValidArista( pointsA, pointsD );
        }
        return true;

    }

    private static boolean isValidAE( PuzzlePiece[] pieces, int index )
    {
        if( index >= 4 )
        {
            char[] pointsA = pieces[0].getPoints( 0, 15, 14, 13, 12 );
            char[] pointsE = pieces[4].getPoints( 12, 13, 14, 15, 0 );

            return isValidArista( pointsA, pointsE );
        }
        return true;

    }

    private static boolean isValidEC( PuzzlePiece[] pieces, int index )
    {
        if( index >= 4 )
        {
            char[] pointsE = pieces[4].getPoints( 8, 7, 6, 5, 4 );
            char[] pointsC = pieces[2].getPoints( 4, 5, 6, 7, 8 );

            return isValidArista( pointsE, pointsC );
        }
        return true;

    }

    private static boolean isValidFB( PuzzlePiece[] pieces, int index )
    {
        if( index >= 5 )
        {
            char[] pointsF = pieces[5].getPoints( 12, 11, 10, 9, 8 );
            char[] pointsB = pieces[1].getPoints( 0, 1, 2, 3, 4 );

            return isValidArista( pointsF, pointsB );
        }
        return true;

    }

    private static boolean isValidCD( PuzzlePiece[] pieces, int index )
    {
        if( index >= 3 )
        {
            char[] pointsC = pieces[2].getPoints( 12, 11, 10, 9, 8 );
            char[] pointsD = pieces[3].getPoints( 4, 5, 6, 7, 8 );

            return isValidArista( pointsC, pointsD );
        }
        return true;

    }

    private static boolean isValidCF( PuzzlePiece[] pieces, int index )
    {

        if( index >= 5 )
        {
            char[] pointsC = pieces[2].getPoints( 4, 3, 2, 1, 0 );
            char[] pointsF = pieces[5].getPoints( 4, 5, 6, 7, 8 );

            return isValidArista( pointsC, pointsF );
        }
        return true;

    }

    private static boolean isValidAB( PuzzlePiece[] pieces, int index )
    {
        if( index >= 1 )
        {
            char[] pointsA = pieces[0].getPoints( 4, 5, 6, 7, 8 );
            char[] pointsB = pieces[1].getPoints( 0, 15, 14, 13, 12 );

            return isValidArista( pointsA, pointsB );
        }
        return true;

    }

    private static boolean isValidBC( PuzzlePiece[] pieces, int index )
    {

        if( index >= 2 )
        {
            char[] pointsB = pieces[1].getPoints( 4, 5, 6, 7, 8 );
            char[] pointsC = pieces[2].getPoints( 0, 15, 14, 13, 12 );

            return isValidArista( pointsB, pointsC );
        }
        return true;

    }

    private static boolean isValidBD( PuzzlePiece[] pieces, int index )
    {

        if( index >= 3 )
        {
            char[] pointsB = pieces[1].getPoints( 12, 11, 10, 9, 8 );
            char[] pointsD = pieces[3].getPoints( 0, 1, 2, 3, 4 );

            return isValidArista( pointsB, pointsD );
        }
        return true;

    }

    private static boolean isValidDE( PuzzlePiece[] pieces, int index )
    {
        if( index >= 4 )
        {
            char[] pointsD = pieces[3].getPoints( 12, 11, 10, 9, 8 );
            char[] pointsE = pieces[4].getPoints( 0, 1, 2, 3, 4 );

            return isValidArista( pointsD, pointsE );
        }
        return true;

    }

    private static boolean isValidEF( PuzzlePiece[] pieces, int index )
    {
        if( index >= 5 )
        {
            char[] pointsE = pieces[4].getPoints( 12, 11, 10, 9, 8 );
            char[] pointsF = pieces[5].getPoints( 0, 1, 2, 3, 4 );

            return isValidArista( pointsE, pointsF );
        }
        return true;

    }

    private static boolean isValidArista( char[] pointsA, char[] pointsB )
    {
        if( pointsA.length == pointsB.length )
        {
            int sum = 0;
            String sumA = "";
            String sumB = "";

            for( int i = 0; i < pointsA.length; ++i )
            {
                // we assume that the pieces are validated previously
                if( pointsA[i] == 'o' && pointsB[i] == 'o' )
                {
                    return false;
                }
                if( i != 0 && i != 4 )
                {
                    if( pointsA[i] == ' ' && pointsB[i] == ' ' )
                    {
                        return false;
                    }
                }
                sumA += pointsA[i];
                sumB += pointsB[i];
                sum++;
            }
            if( sum == 5 && !"ooooo".equals( sumA ) && !"ooooo".equals( sumB ) && !"     ".equals( sumB )
                && !"     ".equals( sumA ) )
            {
                return true;
            }

        }

        return false;
    }
}
