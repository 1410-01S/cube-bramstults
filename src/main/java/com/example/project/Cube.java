package com.example.project;

import java.util.ArrayList;
import java.util.Scanner;

public class Cube {
    
    enum Moves {
        UP,
        DOWN,
        RIGHT,
        LEFT,
        BACK,
        FRONT
    }

    enum Colors {
        BLUE,
        RED,
        YELLOW,
        GREEN,
        WHITE,
        ORANGE
    }
   
    static boolean proceed = true;
    static ArrayList <String> solutionStack = new ArrayList<>();


    static void solve(){
        for(int i = solutionStack.size()-1; i>=0; i--){
            System.out.print(solutionStack.get(i)+" ");
            solutionStack.remove(i);
        }

    }

    // static Color[][][] cube2{
    //     {
    //         {Color.BLUE,Color.BLUE,Color.BLUE},
    //         {Color.BLUE,Color.BLUE,Color.BLUE},
    //         {Color.BLUE,Color.BLUE,Color.BLUE}
    //         },
    // }

    //do a good job planning : function first manner --> build methods first

    static String[][] Face = { //"Face" is only showing one face right now
        {"0","1","2"},
        {"3","4","5"},
        {"6","7","8"}
    
    };

    static String[][][] cube = {
        {
        {"0r","1r","2r"},
        {"3r","4r","5r"},
        {"6","7","8"}
        },
        {
        {"0","1","2"},
        {"3","4","5"},
        {"6","7","8"}
        },
        {
        {"0","1","2"},
        {"3","4","5"},
        {"6","7","8"}
        },
        {
        {"0","1","2"},
        {"3","4","5"},
        {"6","7","8"}
        },
        {
        {"0","1","2"},
        {"3","4","5"},
        {"6","7","8"}
        },
};

    static void move(String[][][] Cube, String input){
        switch(input.toLowerCase()){
            case "u":
                solutionStack.add("u'");
            // code block
            break;

            case "d":
            //
            break;

            case "r":
            //
            break;

            case "l":
            //
            break;

            case "f":
            //
            break;

            case "b":
            //

            case "q":
            proceed = false;

            break;

            default:
        }
    }

    static void show(String[][] face){ //right now "show" is only showing a single face of the cube
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
               System.out.print(face[i][j]);  //think about how a for loop that "rotates" the face could benefit from array entries.
        
        }
        System.out.println();

        }
    }   

    static void swapRow(String[] row1, String[] row2){ //pass in one-dimensional array of strings
        String[] tempRow = new String [3];
        for(int k=0; k<3; k++){
            tempRow[k] = row1[k];
        }
        row1 = row2;
        row2 = tempRow;
    }

    static String[][] rotateFace(String[][] someFace, boolean clockwise){
        String[][] tempFace = new String[3][3];

        for(int i=0; i<3; i++) {
            for(int j=0; j<3; j++){
            tempFace [i][j] = someFace[i][j];
            }
        }
        

        if(clockwise){
            //order is Face[y][x] or Face[row][column]

            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    someFace[i][j] = tempFace[j][i];
                    if (j%2==0) {someFace[i][j] = someFace[i][0];}  
                }
                for(int k=0; k<3; k++){
                    someFace[k][0] = tempFace[2][k];
                    }
            }

            /**
            Face[0][0] = tempFace[2][0];
            Face[0][1] = tempFace[1][0];
            Face[0][2] = tempFace[0][0];

            Face[1][0] = tempFace[2][1];
            Face[1][1] = tempFace[1][1];
            Face[1][2] = tempFace[0][1];

            Face[2][0] = tempFace[2][2];
            Face[2][1] = tempFace[1][2];
            Face[2][2] = tempFace[0][2];
            */

            

        }else if(!clockwise){
            
        }

    return someFace;

    }


     public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        while(proceed){
            move(cube, input.next());
        }

        solve();

       boolean clockwise = true;
       boolean counterclockwise = false;
            System.out.println();

        show(Face);
        rotateFace(Face, clockwise);
            System.out.println();
        show(Face);
             System.out.println();

        //swapRow(Face[0], Face[2]);
        show(Face);
        
    }

}

    


