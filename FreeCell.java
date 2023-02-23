import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Collections;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;

/**
 * Driver class for the Freecell game.
 *
 * @author Dan DiTursi
 * @version 4 February 2023
 */
public class FreeCell
{

    static int count = 0;
    public FreeCell() {}

    public static ArrayList<Action> solve(GameState gs){

        ArrayList<Action> output = new ArrayList<Action>();

        //here we implement A*

        PriorityQueue<GameState> pq = new PriorityQueue<GameState>(10000, new Comparator<GameState>(){
                    public int compare(GameState s1, GameState s2){
                        //this is the comparator statement
                        if((s1.actions.size() + s1.h()) >=
                        (s2.actions.size() + s2.h())) return 1;

                        return -1;

                    }
                });

        pq.add(gs);
        GameState curr;
        GameState next;
        ArrayList<Action> neighborMoves;
 

        while(!pq.isEmpty()){
            curr = pq.poll();
            count++;
 

            if(curr.isWin()){
                output = curr.actions;
                break;
            }

            //next we must generate each neighbor
            neighborMoves = curr.getLegalActions();

            for(Action a: neighborMoves){

                //this is slightly different than the pseudocode given as our nextState function in this implimentation, adds the action a into the result's Action ArrayList
                //hence this will add the move count automatically

                next = curr.nextState(a);

                if(!pq.contains(next)){
                    pq.offer(next);
                }
             
            }
        }

        return output;

    }

    /*
     * args[0] - Input type,if random gamestate then = 0, if loading game state from file, then = 1
     * args[1] - If args[0] = 1, then here the string for the file name is taken and passed to the GameState constructor
     */

    public static void main(String args[]) {

        int inputType = Integer.parseInt(args[0]);
        String filename = null;

        GameState initial = null;

        if(inputType == 1){
            filename = args[1];
            try {
                initial = new GameState(filename);
            } catch (FileNotFoundException fnfe) {
                System.err.println("File name or path not found");

                System.exit(1);
            }

        } else {
            initial = new GameState();

        }
        System.out.println("Initial Game State: ");

        System.out.println(initial);

        long start = System.currentTimeMillis();

        ArrayList<Action> solution = solve(initial);
        long end = System.currentTimeMillis();

        // for(Action a: solution){
        // System.out.println(a.toDisplayString());
        // }

        System.out.println(solution);
        System.out.println("Game States/Nodes checked: "+ count);
        System.out.println("Moves in Solution: " + solution.size());
        System.out.println("Time Elapsed: " + ((end - start) / 1000.0 ));
        
        System.out.println("Verifying Win");
        for(Action a: solution){
            initial.executeAction(a);
        }
        System.out.println(initial);
    }
}

