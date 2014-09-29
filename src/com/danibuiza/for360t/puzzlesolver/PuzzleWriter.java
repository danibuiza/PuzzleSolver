package com.danibuiza.for360t.puzzlesolver;

import java.io.PrintStream;

/**
 * Class with printing mechanisms for puzzles
 * 
 * @author Daniel Gutierrez Diez
 */
public class PuzzleWriter
{

    /**
     * Prints a given combination of pieces using the stream passed as parameter in unfolded form
     * 
     * @param result
     * @param out
     */
    public static void printUnfoldedPuzzle( PuzzlePiece[] result, PrintStream out )
    {
        char[][] unfoldedResult = new char[20][15];
        for( int i = 0; i < 20; i++ )
        {
            for( int j = 0; j < 15; j++ )
            {
                unfoldedResult[i][j] = ' ';
                if( i < 5 )
                {
                    if( j < 5 )
                    {
                        unfoldedResult[i][j] = result[0].rawPoints[i][j];
                    }
                    else if( j < 10 )
                    {

                        unfoldedResult[i][j] = result[1].rawPoints[i][j - 5];
                    }
                    else if( j < 15 )
                    {
                        unfoldedResult[i][j] = result[2].rawPoints[i][j - 10];
                    }
                }
                else if( i < 10 )
                {
                    if( j < 10 && j > 4 )
                    {
                        unfoldedResult[i][j] = result[3].rawPoints[i - 5][j - 5];
                    }
                }
                else if( i < 15 )
                {
                    if( j < 10 && j > 4 )
                    {
                        unfoldedResult[i][j] = result[4].rawPoints[i - 10][j - 5];
                    }
                }
                else if( i < 20 )
                {
                    if( j < 10 && j > 4 )
                    {
                        unfoldedResult[i][j] = result[5].rawPoints[i - 15][j - 5];
                    }
                }
            }
        }

        for( int i = 0; i < 20; i++ )
        {
            StringBuffer buffer = new StringBuffer( "" );
            for( int j = 0; j < 15; j++ )
            {
                buffer.append( unfoldedResult[i][j] );
            }
            if(i==5 || i==10||i==15){
                out.println("");
            }
            out.println( buffer );
        }
    }
}
