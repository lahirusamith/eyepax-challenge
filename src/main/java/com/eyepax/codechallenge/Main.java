package com.eyepax.codechallenge;

public class Main {
    public static void main(String[] args) {
        int rows = 3;
        int cols = 5;
        char[] colors = new char[]{'R', 'B', 'G', 'P', 'K'};

        //initialize the color grid
        ColorGrid colorGrid = new ColorGrid(rows, cols, colors);

        //print the initialized color grid.
        System.out.println("\n=> Initial color grid <=\n");
        for(int i = 0; i < colorGrid.getRows(); i++) {
            for(int j = 0; j < colorGrid.getCols(); j++) {
                System.out.print(colorGrid.getGrid()[i][j].getColor() + " ");
            }
            System.out.println("");
        }

        //process the grid
        GridProcessor gridProcessor = new GridProcessor(colorGrid.getRows(), colorGrid.getCols());
        gridProcessor.printLargestConnectingBlock(colorGrid.getGrid());

        //print the processed color grid with results
        System.out.println("\n The largest connected node count is: " + gridProcessor.getMaxCount());

        System.out.println("\n=> processed color grid <=\n");
        for(int i = 0; i < colorGrid.getRows(); i++) {
            for(int j = 0; j < colorGrid.getCols(); j++) {
                if (gridProcessor.getResult()[i][j]) {
                    System.out.print(colorGrid.getGrid()[i][j].getColor() + " ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println("");
        }
    }
}
