package com.example.project;

import java.util.ArrayList; // Bringing in functionality of a stack program w/o writing onesuch
import java.util.Scanner;
import java.io.IOException;
import java.io.IOexception; // When dealing with input/output this is necessary
import java.io.InputStreamReader; // this is how we "read"

public class Cube {
   
    static boolean proceed = true;

    static ArrayList <String> solutionStack = new ArrayList<>();

    static void solve(){
        for(int i = solutionStack.size()-1; i>=0; i--){  //counter is size of ArrayList less one, for anything greater than zero it decrements
            System.out.print(solutionStack.get(i)+" ");  //prints data which the method "gets" at index i from ArrayList
            solutionStack.remove(i); //also removes that data at i from ArrayList 
        }

    }

    static String[][] Face = { // a single Rubik's face structured in 2-d array
        {"0","1","2"},
        {"3","4","5"},
        {"6","7","8"} };

    static String[][][] cube = { 
        {
        {"0r","1r","2r"}, //row is array [0][0][etc]
        {"3r","4r","5r"},
        {"6r","7r","8r"}
        },
        {
        {"0b","1b","2b"}, //row is array [1][0][etc]
        {"3b","4b","5b"},
        {"6b","7b","8b"}
        },
        {
        {"0o","1o","2o"}, //row is array [2][0][etc]
        {"3o","4o","5o"},
        {"6o","7o","8o"}
        },
        {
        {"0g","1g","2g"}, //row is array [3][0][etc]
        {"3g","4g","5g"},
        {"6g","7g","8g"}
        },
        {
        {"0y","1y","2y"}, //row is array [4][0][etc]
        {"3y","4y","5y"},
        {"6y","7y","8y"}
        },
        {
        {"0w","1w","2w"}, //row is array [5][0][etc]
        {"3w","4w","5w"},
        {"6w","7w","8w"}
        }
};


static void showFace(String[][] face){ // shows a single face of the cube
    for(int i=0; i<3; i++){
        for(int j=0; j<3; j++){
           System.out.print(face[i][j]); // consider a for loop that "rotates" the face, from array entries.
    }
    System.out.println();
    }
}   

public void showCube(){  // for "cube" my 3-d array
    for(int i=0; i<6; i++){
        for(int j=0; j<3; j++){
            for(int k=0; k<3; k++){
                System.out.print(cube[i][j][k]);   
            }
            System.out.println();
        }
        System.out.println();
    }
}

static void swapRow(String[] row1, String[] row2){
    String[] tempRow = new String[3];
    for(int k=0; k<3; k++){
        tempRow[k] = row1[k];
        row1[k] = row2[k];
        row2[k] = tempRow[k];  // pass by value (?)
    }
}
static void rotateEdges(String[] edg1, String[] edg2, String[] edg3, String[] edg4){
    String[] tempEdg = new String [3];

    //cube[edg1[0]][edg1[3]] = copy[edg4[0]][edg4[3]];  -- adapted from Quickstart video

    for(int k=0; k<3; k++){
        tempEdg[k] = edg1[k];
        edg1[k] = edg2[k];
        edg2[k] = edg3[k];
        edg3[k] = edg4[k];
        edg4[k] = tempEdg[k]; 
    }
}

static String[][] rotateFace(String[][] someFace, boolean clock){
    
    String[][] tempFace = new String[3][3];

    for(int i=0; i<3; i++) {
        for(int j=0; j<3; j++){
        tempFace [i][j] = someFace[i][j];
        }
    }

    if(clock == true){
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
                   
    } else if(clock == false){
       
            for(int i=0; i<3; i++){
                for(int j=0; j<3; j++){
                    someFace[i][j] = tempFace[j][i];
                    if (i%2==0) {someFace[i][j] = someFace[0][j];} 
                }
            }
            for(int k=0; k<3; k++){
                someFace[0][k] = tempFace[k][2];
            }
        
    }
        return someFace;

}

    static boolean move(String[][][] Cube, String input){ //this was my code currently being adapted to a 3D array for the cube

        String[] edg1 = new String[4]; // started with this, but not sure of i need these after using rotateEdges
        String[] edg2 = new String[4]; //
        String[] edg3 = new String[4]; //
        String[] edg4 = new String[4]; //

        boolean clockwise = true;
        boolean counterclockwise = false;

        switch(input.toLowerCase()){
            case "u": //this is rotating the top
            solutionStack.add("u'");
            rotateFace(cube[2], clockwise);
            rotateEdges(cube[1][0], cube[4][0], cube[3][0], cube[5][0]);
            break;

            case "d":

                solutionStack.add("d'");
                rotateEdges(cube[1][0], cube[4][0], cube[3][0], cube[5][0]); // complete indices
            //
            break;

            case "r":

                solutionStack.add("r'");
            //
            break;

            case "l":

                solutionStack.add("l'");
            //
            break;

            case "f":

                solutionStack.add("f'");
            //
            break;

            case "b":

                solutionStack.add("b'");
            //
            break;

            case "u'": //this is rotating the top counterclockwise
            solutionStack.add("u");
            rotateFace(cube[2], counterclockwise);
            rotateEdges(cube[1][0], cube[4][0], cube[3][0], cube[5][0]);
            break;

            case "d'":
                solutionStack.add("d'");
                rotateEdges(cube[1][0], cube[4][0], cube[3][0], cube[5][0]);  // complete indices
            //
            break;

            case "r'":

                solutionStack.add("r'");
            //
            break;

            case "l'":

                solutionStack.add("l'");
            //
            break;

            case "f'":

                solutionStack.add("f'");
            //
            break;

            case "b'":

                solutionStack.add("b'");
            //

            case "q":
            proceed = false;

            break;

            default:

        }
        
        return proceed;
    }

    
     public static void main(String[] args) throws IOException {
        
        Scanner userInput = new Scanner(System.in);
        // OR : BufferedReader reader = new Buffered Reader(new InputStreamReader(System.in));

        Cube RubiksCube = new Cube();  // What is going on here? (The class becomes an object?)

        System.out.println("");
        System.out.println("Would you like to solve a Rubik's Cube?");
        System.out.println("If yes, please type: y");
        System.out.print("Otherwise, please type: n");
        System.out.println("");

        while(true){
            String entry = userInput.nextLine();
            if(entry.equals("y")){
                System.out.println("");
                
                System.out.println("BEHOLD! Rubik's Cube:");
                RubiksCube.showCube(); // This is the absolute first time i've seen something like this.
                
                System.out.println("");

                System.out.print("Welcome, please type the following commands");
                System.out.println(" to manipulate your Rubik's Cube:");
                    System.out.println("u  : rotate top face clockwise");
                    System.out.println("u' : rotate top face counterclockwise");
                    System.out.println("d  : rotate bottom face clockwise");
                    System.out.println("d' : rotate top face counterclockwise");
            }
            else if(entry.equals("n")){
                System.out.println("Have a lovely afternoon. Goodbye.");
            }
            break;
        }

        System.out.println("");
        
    
        boolean argsCheck = false;
        int argsRunningIndex = 0;

        if (args.length > 0){ // This function will check if there are args
            argsCheck = true;
        }

        boolean proceed = true;


        // etc. 
        System.out.println("To Be Continued...");

        while(proceed){
            String input; // where we collect input from user

            if(!argsCheck){ // This function will run if there are no args
                input = userInput.nextLine(); // OR reader.readLine();
                   
            }else{
                if(argsRunningIndex == args.length){ // This means: we've reached the end of the arguments. 
                    argsCheck = false; // makes it stop running in "args mode"
                    input = "s"; // "s" is for "solve"
                }else{
                    input = args[argsRunningIndex]; // !!! I need a much more explicit and broad explanation of this code!!!
                    argsRunningIndex++; // is this part of the code is "prioritizing" scanner/reader input?
                }
            }

            move(cube, input);  //this is not working, as i intened it to work in this while loop.  
                                //does the method need to return a boolean proceed as false? (tried doesn't work)
        }
        
            solve();


    //    boolean clockwise = true;
    //    boolean counterclockwise = false;
    //         System.out.println();
        
        // showCube(cube);
        // showFace(cube[0]);
        // rotateFace(cube[0], clockwise);
        //     System.out.println();
        // showFace(cube[0]);

        // rotateFace(cube[0], counterclockwise);
        //     System.out.println();


        // This is just testing the rotateEdges methodu with certain values.
        rotateEdges(cube[1][0], cube[4][0], cube[3][0], cube[5][0]);
            showFace(cube[0]); //bottom
            System.out.println();
            showFace(cube[1]);
            System.out.println();
            showFace(cube[5]);
            System.out.println();
            showFace(cube[3]);
            System.out.println();
            showFace(cube[4]);
            System.out.println();
            showFace(cube[2]); //top

        // swapRow(Face[0], Face[2]);
        // show(Face);


        userInput.close();

    }

}

    


