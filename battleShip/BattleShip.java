package OOpr.park.battleShip;

import java.util.*;

/** 
 * Created by Pranay on 9/9/2017.
 */
public class BattleShip {
    public static void main(String[] args) {  
        PriorityQueue pr=new PriorityQueue(10,Collections.reverseOrder());

        Scanner sc=new Scanner(System.in);
        System.out.println("enter board size m and n");
        int m=sc.nextInt(); int n=sc.nextInt();    // this m,n is the board size , user give this value via Scanner
        int numberOfShip=3;  // number of ships
        int []ar={1,2,3};    // length of each ships
        BattleShip btl=new BattleShip();
        btl.gameEngine(m,n,numberOfShip,ar);  // start the game
    }
    public void gameEngine(int m,int n , int mubberOfShip,int ar[]){ /// gameEngine is the main engine which runs the game
        user user1=new user(n,m,mubberOfShip,ar,0);     // initialization of users
        user user2=new user(n,m,mubberOfShip,ar,1);
        int turn=0;       // turn 0 for user1 and turn 1 for user2
        while(true){
            int won=0;
            if(turn==0) {

                int temp=userMove(user1);
                // temp=1 means hit .... temp=2 mean ship down and temp=0 means no hit
                if (temp==2) {
                    user1.ships--;
                    won =checkWon(user1);
                }
            }
            else {
                int temp=userMove(user2);
                // temp=1 means hit .... temp=2 mean ship down and temp=0 means no hit
                if (temp==2)  {user2.ships--; won =checkWon(user1); }
            }
            if (won==2) {
                System.out.println("User"+turn+" won the game" );
                break;
            }
            turn =turn^1;
        }
    }
    protected int checkWon(user users){if (users.ships<=0) return 2; return 0; }
    protected int userMove(user users){
        int x,y;
        x=y=0;
        /// user will give these co-ordinate and we will check 1st its valid or not
        // while (isValid(x,y));
        if(users.bt.page[x][y].s!=null){
            ship ss=users.bt.page[x][y].s;
            if(ss.aa==false) return 0;
            else {
                return ss.hit(x,y);
            }

        }
        return 0;
    }

}

abstract class board{
    int n,m;   // board size

    pos[][]page;  // pos is the element of the board


    class pos{    // pos element contain co-ordinate and if their is any ship pointing on this co-ordinate
        int x,y,val;
        ship s;    // if their is any ship pointing on this co-ordinate
        public pos(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
            s=null;
        }

    }
    public board(int n, int m) {
        this.n = n;
        this.m = m;
        for (int i = 0; i < n; i++) {
            for(int j=0;j<m;j++) {
                pos pp = new pos(i, j,0);
                page[i][j]=pp;
            }
        }
    }

}
class ship{
    boolean aa; // to tell that  ship is fully destroyed or not
    int size; // remaining size of this ship
    int []ship1;
    int sx,sy,ex,ey;
    public int hit(int x,int y){
        int temp= Math.abs(sx-x)+ Math.abs(sy-y);
        if (ship1[temp]>0){
            ship1[temp]--;
            if(ship1[temp]==0){
                size--;
                if (size==0){ aa=true; return 2;}
            }
            return 1;
        }
        return 0;
    }
    public ship( int size) {
        this.aa = false;
        this.size = size;
        ship1=new int[size];
        Arrays.fill(ship1,1);
    }
    public int postion(int sx,int sy,int ex,int ey){
        this.sx=sx;
        this.sy=sy; this.ex=ex;    this.ey=ey;
        return 1;
        // return 0;   if not valid return 0 , re-enter the value
    }

}
class battleBoard extends board{
    public battleBoard(int n, int m) {
        super(n, m);
    }

}
class user{
    battleBoard bt;
    int ships;
    ship[] sh;
    int turn;

    public user(int n,int m , int ships,int []ar,int turn) {
        battleBoard bt=new battleBoard(n,m);
        for (int i=0;i<ships;i++){
            ship ss=new ship(ar[i]);
            sh[i]= ss;
            for (int j=0;j<ar[i];j++){
                bt.page[3][2].s=ss;  // user will give input co - ordinate
            }
            while(ss.postion(0,0,0,0)==0);  // this need to be checked if valid or not
        }
        this.ships=ships;
        this.turn = turn;
    }

}

