package ConnectN;

public class Board {
	int [][] grid = new int[6][7];
	public Board() {
		for (int row = 0; row < grid.length; row++){
            for (int col = 0; col < grid[0].length; col++){
                grid[row][col] = -1;
            }
        }
	}
	public int getBoardRows() {
		
		return grid.length;
	}
	public  boolean isWinner(int n_link,int player){
        //check for 4 across
    	int endnum=n_link-1;
    	for(int row = 0; row<grid.length; row++){  
    		for (int col = 0;col < grid[0].length - endnum;col++){
    			boolean is_winner=true;
    			for(int num=0;num<n_link;num++) {
    				is_winner=is_winner&&(grid[row][col+num]== player);
    			}
                if (is_winner){
                    return true;
                }
            }
        }
    	
        
        //check for 4 up and down
        for(int row = 0; row < grid.length - endnum; row++){
            for(int col = 0; col < grid[0].length; col++){
            	boolean is_winner=true;
    			for(int num=0;num<n_link;num++) {
    				is_winner=is_winner&&(grid[row+num][col] == player);
    			}
                if (is_winner){
                    return true;
                }
            }
        }
        //check upward diagonal
        for(int row = endnum; row < grid.length; row++){
            for(int col = 0; col < grid[0].length - endnum; col++){
            	boolean is_winner=true;
    			for(int num=0;num<n_link;num++) {
    				is_winner=is_winner&&(grid[row-num][col+num] == player);
    			}
                if (is_winner){
                    return true;
                }
            	
            }
        }
        //check downward diagonal
        for(int row = 0; row < grid.length - endnum; row++){
            for(int col = 0; col < grid[0].length - endnum; col++){
            	boolean is_winner=true;
    			for(int num=0;num<n_link;num++) {
    				is_winner=is_winner&&(grid[row+num][col+num] == player);
    			}
                if (is_winner){
                    return true;
                }
            	
            } 
        }
        return false;
    }
	public  void display(){
        System.out.println(" 0 1 2 3 4 5 6");
        System.out.println("---------------");
        for (int row = 0; row < grid.length; row++){
            System.out.print("|");
            for (int col = 0; col < grid[0].length; col++){
            	if(grid[row][col]==-1) {
            		System.out.print(" ");
            	}
            	else
            	{
            		System.out.print(grid[row][col]);
            	}
                
                System.out.print("|");
            }
            System.out.println();
            System.out.println("---------------");
        }
        System.out.println(" 0 1 2 3 4 5 6");
        System.out.println();
    }
	public  boolean validate(int column){
        //valid column?
        if (column < 0 || column >= grid[0].length){//edited by ydy
            return false;
        }

        //full column?
        if (grid[0][column] != -1){
            return false;
        }

        return true;
    }
	public void dropTheChecker(int play,int player) {
		//drop the checker
        for (int row = grid.length-1; row >= 0; row--){
            if(grid[row][play] == -1){
                grid[row][play] = player;
                break;
            }
        }
	}
}
