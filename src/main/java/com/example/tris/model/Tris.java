package com.example.tris.model;

import com.example.tris.TrisApplication;

import java.util.Arrays;

public class Tris {
    private char[][] matrix;
    private int count;
    private int id;
    private int[] preview = new int[2];

    public Tris(int id) {
        this.id = id;
        matrix = new char[3][3];
        for (char[] c : matrix)
            Arrays.fill(c, '-');
        count = 0;
        preview[0] = -1;
        preview[1] = -1;
    }

    public String setMove(int posI, int posJ) {
        posI--;
        posJ--;
        char x = count % 2 == 0 ? 'X' : 'O';
        if (posI > 2 || posI < 0 || posJ > 2 || posJ < 0 )
              return "Posizione errata!";

        if (matrix[posI][posJ] != '-')
            return "La casella selezionata non e' vuota";
        matrix[posI][posJ] = x;
        preview[0] = posI;
        preview[1] = posJ;
        count++;
        //if (count >= 5)
            return check() + "";
        //return "success";
    }

    private String check() {
        //check orizzontale
        for (int i = 0; i < matrix.length; i++) {
            char c1 = matrix[i][0];
            char c2 = matrix[i][1];
            char c3 = matrix[i][2];
            if (c1 != '-' && c1 == c2 && c1 == c3)
                return "Vincitore: " + c1;
        }
        //check verticale
        for (int i = 0; i < 3; i++) {
            char c1 = matrix[0][i];
            char c2 = matrix[1][i];
            char c3 = matrix[2][i];
            if (c1 != '-' && c1 == c2 && c1 == c3)
                return "Vincitore: " + c1;
        }

        //check diagonale
        char[] c = new char[6];
        for (int i = 0; i < 3; i++)
            c[i] = matrix[i][i];
        for (int i = 0; i <3; i++)
            c[i+3] = matrix[i][2 - i];
        if (c[1] != '-' &&
                ((c[1] == c[0] && c[1] == c[2]) ||
                        c[1] == c[3] && c[3] == c[5]))
            return "Vincitore: " + c[1];

        if (count == 9)
            return "Nessun Vincitore";
        return "success";
    }

    public String goBack() {
        if (preview[0] != -1 && preview[1] != -1) {
            matrix[preview[0]][preview[1]] = '-';
            return "success";
        }
        return "failed";
    }

    public char[][] getMatrix() {
        return matrix;
    }

    public int getCount() {
        return count;
    }

    public String reset() {
        matrix = new char[3][3];
        for (char[] c : matrix)
            Arrays.fill(c, '-');
        count = 0;
        return "success";
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Tris{" +
                "matrix=" + Arrays.toString(matrix) +
                '}';
    }
}
