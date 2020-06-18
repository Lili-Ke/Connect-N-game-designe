package ConnectN;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PlayBoard {
    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
        String nameStr="";
        List<Player> playersList=new ArrayList<>();
        
        System.out.println("Welcome to Connect N");
        System.out.println("There are 3 players 1, 2, 3");
        System.out.println("Player 1 is Human, Player 2 and 3 are Computer");
        System.out.println("To play the game type in the number of the column you want to drop you counter in");
        System.out.println("A player wins by connecting N counters in a row - vertically, horizontally or diagonally");
        System.out.println("");


        System.out.println("First,please input N(2 < N < 7) to connect:");
        int n_link = in.nextInt();
        if(!(n_link>2&&n_link<7)) {
        	 System.out.println("Please input correct N(2 < N < 7) to connect:");
        	 n_link = in.nextInt();
        }
        
        Scanner inName = new Scanner(System.in);
        System.out.println("please input your name(NO:1):");
        nameStr=inName.nextLine() ;
        HumanPlayer human=new HumanPlayer(nameStr);
        human.setPlayNo(1);
        playersList.add(human);
        
        System.out.println("please input the first Robot name(NO:2):");
        nameStr=inName.nextLine() ;
        RobotPlayer robot1=new RobotPlayer(nameStr);
        robot1.setPlayNo(2);
        playersList.add(robot1);

		
		System.out.println("please input the second Robot name(NO:3):");
        nameStr=inName.nextLine() ;
        RobotPlayer robot2=new RobotPlayer(nameStr);
        robot2.setPlayNo(3);
        playersList.add(robot2);
		
		Board board=new Board();
		
        Random r = new Random(7);
        int turn = 1;
        int playNo=0;
        boolean winner = false;

        //play a turn
        while (winner == false && turn <= 42){
        	Player currentPlayer=playersList.get(playNo);
		    System.out.println("Current player:"+currentPlayer.getName());
            boolean validPlay;
            int play;
            int humanInputNum=1;//Human input times in a turn;if >1,do not board.display()
            do {
            	if(humanInputNum==1) {
            		board.display();
            	}
            	else {
            		System.out.print("Error column!!!Please input the correct column!!!");
            	}
            	
                System.out.print("Player " + currentPlayer.getName() + ", choose a column: ");
                if(currentPlayer instanceof HumanPlayer) {
                	play = in.nextInt();
                }
                else {
                	play = r.nextInt(7);
                }
               
                //validate play
                validPlay = board.validate(play);

            }while (validPlay == false);

            currentPlayer.PlayTurn(board,play);
            //board.dropTheChecker(play,playNo);
            board.display();

            //determine if there is a winner
            winner = board.isWinner(n_link,playNo);

            if (winner){
                System.out.println("Player " + currentPlayer.getName() + " won");
                System.out.println("End of game");
                break;
            }
            turn++;
          // calculate index of next player  
            playNo++;
            if(!(playNo<playersList.size())) {
            	playNo=0;
            }
            //playNo= playNo<playersList.size()?playNo++:0;
            
        }
        
        if (!winner){            
            System.out.println("Tie game");
        }
    }
}

