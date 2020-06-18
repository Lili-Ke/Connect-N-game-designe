package ConnectN;

public class RobotPlayer implements Player {
    String name;
    int playNo;
    public void setPlayNo(int playNo) {
    	this.playNo=playNo;
    }
    public RobotPlayer(String name) {
        this.name=name;
    }
    public String getName() {
    	return name;
    }
    public void PlayTurn(Board board,int column) {
    	board.dropTheChecker(column,playNo);
    }
}