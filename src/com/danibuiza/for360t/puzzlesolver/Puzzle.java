package com.danibuiza.for360t.puzzlesolver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * This class abstract a puzzle of 6 parts
 * 
 * @author Daniel Gutierrez Diez
 */
public class Puzzle
{

    /**
     * parts of the puzzle
     */
    private PuzzlePiece  a1;
    private PuzzlePiece  b1;
    private PuzzlePiece  c1;
    private PuzzlePiece  d1;
    private PuzzlePiece  e1;
    private PuzzlePiece  f1;

    // list with all the points of the puzzle
    private List<String> rawLines;

    private String       name;

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public Puzzle()
    {
        PuzzlePiece a1 = new PuzzlePiece( "a" );
        PuzzlePiece b1 = new PuzzlePiece( "b" );
        PuzzlePiece c1 = new PuzzlePiece( "c" );
        PuzzlePiece d1 = new PuzzlePiece( "d" );
        PuzzlePiece e1 = new PuzzlePiece( "e" );
        PuzzlePiece f1 = new PuzzlePiece( "f" );
        this.addPieces( a1, b1, c1, d1, e1, f1 );
    }

    public Puzzle( String fileName )
    {
        this();
        setName( fileName );
    }

    public void addPieces( PuzzlePiece a, PuzzlePiece b, PuzzlePiece c, PuzzlePiece d, PuzzlePiece e, PuzzlePiece f )
    {
        this.a1 = a;
        this.b1 = b;
        this.c1 = c;
        this.d1 = d;
        this.e1 = e;
        this.f1 = f;
    }

    public PuzzlePiece[] getPieces()
    {
        return new PuzzlePiece[] { this.a1, this.b1, this.c1, this.d1, this.e1, this.f1 };
    }

    /**
     * Reads all the points of the file passed as parameter into the puzzle raw points
     * 
     * @param fileName
     * @throws IOException
     */
    public void readFile( String fileName ) throws IOException
    {
        InputStream puzzleInputStream = new FileInputStream( new File( fileName ) );
        BufferedReader puzzleReader = new BufferedReader( new InputStreamReader( puzzleInputStream ) );
        puzzleReader.lines().forEach( rawLine -> addPuzzleRawLine( rawLine ) );
        puzzleReader.close();

    }

    private void addPuzzleRawLine( String rawLine )
    {
        if( this.rawLines == null )
        {
            rawLines = new ArrayList<String>();
        }
        this.rawLines.add( rawLine );
    }

    public void drawPieces()
    {

        if( this.rawLines != null && this.a1 != null && this.b1 != null && this.c1 != null && this.d1 != null
            && this.e1 != null && this.f1 != null )
        {

            int lineNumber = 0;
            for( String line : this.rawLines )
            {

                if( line.length() == 15 )
                {
                    if( lineNumber < 5 )
                    {
                        this.a1.addRawPoints( lineNumber,
                                              line.charAt( 0 ),
                                              line.charAt( 1 ),
                                              line.charAt( 2 ),
                                              line.charAt( 3 ),
                                              line.charAt( 4 ) );
                        this.b1.addRawPoints( lineNumber,
                                              line.charAt( 5 ),
                                              line.charAt( 6 ),
                                              line.charAt( 7 ),
                                              line.charAt( 8 ),
                                              line.charAt( 9 ) );
                        this.c1.addRawPoints( lineNumber,
                                              line.charAt( 10 ),
                                              line.charAt( 11 ),
                                              line.charAt( 12 ),
                                              line.charAt( 13 ),
                                              line.charAt( 14 ) );
                    }
                    else
                    {
                        this.d1.addRawPoints( lineNumber - 5,
                                              line.charAt( 0 ),
                                              line.charAt( 1 ),
                                              line.charAt( 2 ),
                                              line.charAt( 3 ),
                                              line.charAt( 4 ) );

                        this.e1.addRawPoints( lineNumber - 5,
                                              line.charAt( 5 ),
                                              line.charAt( 6 ),
                                              line.charAt( 7 ),
                                              line.charAt( 8 ),
                                              line.charAt( 9 ) );
                        this.f1.addRawPoints( lineNumber - 5,
                                              line.charAt( 10 ),
                                              line.charAt( 11 ),
                                              line.charAt( 12 ),
                                              line.charAt( 13 ),
                                              line.charAt( 14 ) );

                    }
                }

                ++lineNumber;
            }

            this.a1.drawPoints();

            this.b1.drawPoints();

            this.c1.drawPoints();

            this.d1.drawPoints();

            this.e1.drawPoints();

            this.f1.drawPoints();
        }
    }

    /**
     * Sets the pieces to the passed array
     * 
     * @param pieces
     */
    public void setPieces( PuzzlePiece[] pieces )
    {
        if( pieces != null && pieces.length == 6 )
        {
            a1 = pieces[0];
            b1 = pieces[1];
            c1 = pieces[2];
            d1 = pieces[3];
            e1 = pieces[4];
            f1 = pieces[5];
        }
    }

    /**
     * Returns an array of pieces without the fixed one
     * 
     * @return PuzzlePiece[]
     */
    public PuzzlePiece[] getNotFixedPieces()
    {
        return new PuzzlePiece[] { this.b1, this.c1, this.d1, this.e1, this.f1 };
    }

    /**
     * Return the fixed piece
     * 
     * @return PuzzlePiece[]
     */
    public PuzzlePiece getFixedPiece()
    {
        return getPiece( 0 );
    }

    /**
     * Returns the piece in the position passed
     * 
     * @param i
     * @return
     */
    public PuzzlePiece getPiece( int position )
    {
        if( getPieces() != null && getPieces().length > position )
        {
            return getPieces()[position];
        }
        return null;
    }

}
