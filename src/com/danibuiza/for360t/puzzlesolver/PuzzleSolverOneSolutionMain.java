package com.danibuiza.for360t.puzzlesolver;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Class with main program for solving the puzzle and returning the first found solution
 * 
 * @author Daniel Gutierrez Diez
 */
public class PuzzleSolverOneSolutionMain
{

    static String blue_fileName   = "input/blue_puzzleUnsolved.txt";
    static String lila_fileName   = "input/lila_puzzleUnsolved.txt";
    static String red_fileName    = "input/red_puzzleUnsolved.txt";
    static String yellow_fileName = "input/yellow_puzzleUnsolved.txt";

    public static void main( String[] args ) throws IOException
    {

        solvePuzzle( blue_fileName );
        solvePuzzle( lila_fileName );
        solvePuzzle( red_fileName );
        solvePuzzle( yellow_fileName );

    }

    private static void solvePuzzle( String fileName ) throws IOException
    {
        Puzzle puzzle = new Puzzle( fileName );
        puzzle.readFile( fileName );
        puzzle.drawPieces();

        PuzzlePiece[] solution = PuzzleQuickSolver.getSolution( puzzle );

        if( solution != null )
        {
            PrintStream out = new PrintStream( new File( fileName + ".out" ) );
            printOutputToFile( puzzle, solution, out );
        }
    }

    private static void printOutputToFile( Puzzle puzzle, PuzzlePiece[] solution, PrintStream out )
    {
        out.println( "Solution for puzzle " + puzzle.getName() );
        PuzzleWriter.printUnfoldedPuzzle( solution, out );
    }
}
