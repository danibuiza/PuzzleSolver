package com.danibuiza.for360t.puzzlesolver;

import java.io.IOException;
import java.util.List;

/**
 * Class with main program for solving the puzzle and returning all possible solutions
 * 
 * @author Daniel Gutierrez Diez
 */
public class PuzzleSolverAllSolutionsMain
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

        List<PuzzlePiece[]> solutions = PuzzleAllSolver.getAllSolutions( puzzle );

        System.out.println( solutions.size() );

    }

}
