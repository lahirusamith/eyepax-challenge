package com.eyepax.codechallenge;

import java.util.Random;

public class ColorGrid {
    private int cols;
    private int rows;
    public char[] colors;
    private Node[][] grid;

    public ColorGrid(int rows, int cols, char[] colors) {
        this.rows = rows;
        this.cols = cols;
        this.colors = colors;

        Random random = new Random();
        grid = new Node[this.rows][this.cols];
        for(int i = 0; i < this.rows; i++) {
            for(int j = 0; j < this.cols; j++) {
                grid[i][j] = new Node(i, j, colors[random.nextInt(colors.length)]);
            }
        }
    }

    public int getCols() {
        return cols;
    }

    public void setCols(int cols) {
        this.cols = cols;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public char[] getColors() {
        return colors;
    }

    public void setColors(char[] colors) {
        this.colors = colors;
    }

    public Node[][] getGrid() {
        return grid;
    }

    public void setGrid(Node[][] grid) {
        this.grid = grid;
    }
}
