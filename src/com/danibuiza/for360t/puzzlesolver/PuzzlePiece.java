package com.danibuiza.for360t.puzzlesolver;

/**
 * This class abstracts a puzzle piece and contains methods to handle it
 * 
 * @author Daniel Gutierrez Diez
 */
public class PuzzlePiece
{

    private String name;

    // array that contains the interesting points of a piece, the ones in the corners and aristas
    char[]         points    = new char[16];

    // all points of a piece
    char[][]       rawPoints = new char[5][5];

    /**
     * Copy constructor
     * 
     * @param piece
     */
    public PuzzlePiece( PuzzlePiece piece )
    {
        if( piece != null )
        {
            name = piece.name;
            for( int i = 0; i < piece.rawPoints.length; i++ )
            {
                for( int j = 0; j < piece.rawPoints[i].length; j++ )
                {
                    rawPoints[i][j] = piece.rawPoints[i][j];
                }
            }
            for( int j = 0; j < 16; j++ )
            {
                points[j] = piece.points[j];
            }
        }
    }

    public PuzzlePiece( String name )
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    /**
     * Returns an array of char with the points of the passed positions
     * 
     * @param i
     * @param j
     * @param k
     * @param l
     * @param m
     * @return char[]
     */
    public char[] getPoints( int i, int j, int k, int l, int m )
    {
        if( points != null && points.length > j && points.length > i && points.length > k && points.length > l
            && points.length > m )
        {

            return new char[] { points[i], points[j], points[k], points[l], points[m] };

        }
        return null;
    }

    public void addRawPoints( int lineNumber, char charAt1, char charAt2, char charAt3, char charAt4, char charAt5 )
    {
        this.rawPoints[lineNumber] = new char[] { charAt1, charAt2, charAt3, charAt4, charAt5 };

    }

    /**
     * Draw the points of the corners and aristas using the raw points for input
     */
    public void drawPoints()
    {
        this.points[0] = this.rawPoints[0][0];
        this.points[1] = this.rawPoints[0][1];
        this.points[2] = this.rawPoints[0][2];
        this.points[3] = this.rawPoints[0][3];
        this.points[4] = this.rawPoints[0][4];
        this.points[5] = this.rawPoints[1][4];
        this.points[6] = this.rawPoints[2][4];
        this.points[7] = this.rawPoints[3][4];
        this.points[8] = this.rawPoints[4][4];
        this.points[9] = this.rawPoints[4][3];
        this.points[10] = this.rawPoints[4][2];
        this.points[11] = this.rawPoints[4][1];
        this.points[12] = this.rawPoints[4][0];
        this.points[13] = this.rawPoints[3][0];
        this.points[14] = this.rawPoints[2][0];
        this.points[15] = this.rawPoints[1][0];

    }

    /**
     * debugging purposes
     */
    public void print()
    {
        for( int i = 0; i < 5; i++ )
        {
            System.out.println( this.rawPoints[i][0] + "" + this.rawPoints[i][1] + "" + this.rawPoints[i][2] + ""
                + this.rawPoints[i][3] + "" + this.rawPoints[i][4] );
        }
        System.out.println( "" );

    }

    /**
     * Rotates a piece 45°, 4 rotations leaves the piece in the original position
     */
    public void rotate()
    {
        char[] temp = new char[16];
        for( int k = 0; k < 16; ++k )
        {
            temp[k] = this.points[k];
        }
        for( int k = 0; k < 16; ++k )
        {
            if( k + 4 < 16 )
            {
                this.points[k] = temp[k + 4];
            }
            else
            {
                this.points[k] = temp[k - 12];
            }
        }
        reDrawRawPoints();

    }

    /**
     * Turns a piece in the other side, 2 turns leaves the piece in the original position
     */
    public void turn()
    {
        char[] temp = new char[16];
        for( int k = 0; k < 16; ++k )
        {
            temp[k] = this.points[k];
        }

        this.points[0] = temp[4];
        this.points[1] = temp[3];
        this.points[2] = temp[2];
        this.points[3] = temp[3];
        this.points[4] = temp[0];
        this.points[5] = temp[15];
        this.points[6] = temp[14];
        this.points[7] = temp[13];
        this.points[8] = temp[12];
        this.points[9] = temp[11];
        this.points[10] = temp[10];
        this.points[11] = temp[9];
        this.points[12] = temp[8];
        this.points[13] = temp[7];
        this.points[14] = temp[6];
        this.points[15] = temp[5];

        reDrawRawPoints();

    }

    /**
     * Redraw the raw points of the piece using as base the points, this should be used after any
     * rotation
     */
    private void reDrawRawPoints()
    {
        this.rawPoints[0][0] = this.points[0];
        this.rawPoints[0][1] = this.points[1];
        this.rawPoints[0][2] = this.points[2];
        this.rawPoints[0][3] = this.points[3];
        this.rawPoints[0][4] = this.points[4];
        this.rawPoints[1][4] = this.points[5];
        this.rawPoints[2][4] = this.points[6];
        this.rawPoints[3][4] = this.points[7];
        this.rawPoints[4][4] = this.points[8];
        this.rawPoints[4][3] = this.points[9];
        this.rawPoints[4][2] = this.points[10];
        this.rawPoints[4][1] = this.points[11];
        this.rawPoints[4][0] = this.points[12];
        this.rawPoints[3][0] = this.points[13];
        this.rawPoints[2][0] = this.points[14];
        this.rawPoints[1][0] = this.points[15];

    }

}
