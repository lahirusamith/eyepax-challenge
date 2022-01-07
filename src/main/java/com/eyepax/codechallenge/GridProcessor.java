package com.eyepax.codechallenge;

public class GridProcessor {
    private final int rows;
    private final int cols;
    private final boolean[][] visited;
    private final boolean[][] result;
    private int nodeCount;
    private int maxCount = 0;

    public GridProcessor(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        visited = new boolean[rows][cols];
        result = new boolean[rows][cols];
    }

    private void clearVisitedArray() {
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                visited[i][j] = false;
    }

    private boolean isTraversalPossible(int x, int y, Node node, Node[][] grid) {
        if (x < rows  && y < cols && x >= 0 && y >= 0) {
            if (!visited[x][y] && grid[x][y].getColor() == node.getColor()) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private void resetResult(Node node, Node[][] grid) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (visited[i][j] && grid[i][j].getColor() == node.getColor())
                    result[i][j] = visited[i][j];
                else
                    result[i][j] = false;
            }
        }
    }

    private void SearchNodeInterconnections(Node node, Node adjacentNode, int currentRow, int currentCol, Node[][] grid) {
        if (node.getColor() != adjacentNode.getColor()) {
            return;
        }

        visited[currentRow][currentCol] = true;
        nodeCount++;

        //traversal possible for left, right, up and down only.
        //therefore, movement metrics are as follows.
        int[] horizontalMove = { 0, 0, 1, -1 };
        int[] verticalMove = { 1, -1, 0, 0 };

        for (int u = 0; u < 4; u++) {
            if ((isTraversalPossible(currentRow + verticalMove[u],
                    currentCol + horizontalMove[u], node, grid))) {
                SearchNodeInterconnections(node, adjacentNode, currentRow + verticalMove[u],
                        currentCol + horizontalMove[u], grid);
            }
        }
    }

    public void printLargestConnectingBlock(Node[][] grid) {
        int currentMax = Integer.MIN_VALUE;
        for (int currentRow = 0; currentRow < rows; currentRow++) {
            for (int currentCol = 0; currentCol < cols; currentCol++) {
                clearVisitedArray();
                nodeCount = 0;

                // checking node to the right
                if (currentCol + 1 < cols)
                    SearchNodeInterconnections(grid[currentRow][currentCol], grid[currentRow][currentCol + 1],
                            currentRow, currentCol, grid);

                // updating result
                if (nodeCount >= currentMax) {
                    currentMax = nodeCount;
                    resetResult(grid[currentRow][currentCol], grid);
                }
                clearVisitedArray();
                nodeCount = 0;

                // checking node downwards
                if (currentRow + 1 < rows)
                    SearchNodeInterconnections(grid[currentRow][currentCol], grid[currentRow + 1][currentCol],
                            currentRow, currentCol, grid);

                // updating result
                if (nodeCount >= currentMax) {
                    currentMax = nodeCount;
                    resetResult(grid[currentRow][currentCol], grid);
                }
            }
        }
        maxCount = currentMax;
    }

    public boolean[][] getResult() {
        return result;
    }

    public int getMaxCount() {
        return maxCount;
    }
}

