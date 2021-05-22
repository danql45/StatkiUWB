package com.example.statkiuwb;

import java.util.ArrayList;

public class Solver {

    int[][] board;
    ArrayList<ArrayList<Object>> emptyBoxIndex;

    int selected_row;
    int selected_column;


    Solver(){
        selected_row = -1;
        selected_column = -1;

        board = new int[10][10];
        for(int r = 0; r < 10; r++){
            for(int c = 0; c < 10; c++){
                board[r][c] = 0;
            }
        }

        emptyBoxIndex = new ArrayList<>();
    }

    private void getEmptyBoxIndexes(){
        for(int r = 0; r < 10; r++){
            for(int c = 0; c < 10; c++){
                if(this.board[r][c] == 0){
                    this.emptyBoxIndex.add(new ArrayList<>());
                    this.emptyBoxIndex.get(this.emptyBoxIndex.size()-1).add(r);
                    this.emptyBoxIndex.get(this.emptyBoxIndex.size()-1).add(c);
                }
            }
        }
    }

    private void setNumberPos(int num){
        if(this.selected_row != -1 && this.selected_column != -1){
            if(this.board[this.selected_row][this.selected_column] == num){
                this.board[this.selected_row][this.selected_column] = 0;
            }
            else {
                this.board[this.selected_row][this.selected_column] = num;
            }
        }
    }

    public int[][] getBoard(){
        return this.board;
    }

    public int getSelected_row(){
        return selected_row;
    }

    public int getSelected_column(){
        return selected_column;
    }

    public void setSelected_row(int r){
        selected_row = r;
    }

    public void setSelected_column(int c){
        selected_column = c;
    }
}
