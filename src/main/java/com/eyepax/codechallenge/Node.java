package com.eyepax.codechallenge;

public class Node {
    private int position_x;
    private int position_y;
    private char color;

    public Node(int position_x, int position_y, char color) {
        this.position_x = position_x;
        this.position_y = position_y;
        this.color = color;
    }

    public char getColor() {
        return color;
    }

    public void setColor(char color) {
        this.color = color;
    }

    public int getPosition_x() {
        return position_x;
    }

    public void setPosition_x(int position_x) {
        this.position_x = position_x;
    }

    public int getPosition_y() {
        return position_y;
    }

    public void setPosition_y(int position_y) {
        this.position_y = position_y;
    }
}