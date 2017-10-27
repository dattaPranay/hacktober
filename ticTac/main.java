package OOpr.park.ticTac;

import java.util.ArrayList;

/**
 * Created by Pranay on 9/9/2017.
 */
public class main {
    int turn =0;
    ticBoard tc=new ticBoard();



    private void giveMove(int turn){
        //get co ordinate

        while(!tc.checkValid());
        //checkwin();

    }
    public void gameEngine(){
        int count=0;
        while (true){
            giveMove(turn);
            turn=turn^1;
            count++;
            if(count==9) {break; }
        }
    }
}

abstract class board {
    protected  int sizeN;
    protected int sizeM;
    ArrayList<ArrayList<position>> pos;
    class position{
        int x,y,val;
    }

    public synchronized ArrayList<ArrayList<position>> getPos() {
        return pos;
    }

    public board(int sizeN, int sizeM) {
        this.sizeN = sizeN;
        this.sizeM = sizeM;
        pos=new ArrayList<>();
        // for i to n
        //   for j to m  array list fill //
        position pp=new position();
        pos.get(0).add(pp);
    }
}

class ticBoard extends board{
    public ticBoard() {
        super(3,3);
    }
     boolean checkValid(){
        int x; int y;
        ArrayList<ArrayList<position>> aa= getPos();
        //aa.get(x).get(y).val==-1; turn =1;
         //checkwin() dfs of bfs
         return true;
    }
}