
public class Maze {
	

	public int sizeX;
	public int sizeY;
	public String[] maze;
	public int start;
	public int end;
		   

	Maze(int sizeX, int sizeY,  int start, int end, String[] maze){
	  this.sizeX = sizeX;
	  this.sizeY=sizeY;
	  this.maze=maze;
	  this.start=start;
	  this.end=end;
	}
		   
		   
	Maze(){

	}


	public int getSizeX() {
	  return sizeX;
	}

	public void setSizeX(int sizeX) {
	  this.sizeX = sizeX;
	}

	public int getSizeY() {
	  return sizeY;
	}

	public void setSizeY(int sizeY) {
	  this.sizeY = sizeY;
	}

	public String[] getMaze() {
	  return maze;
	}

	public void setMaze(String[] maze) {
	  this.maze = maze;
	}

	public int getStart() {
	  return start;
	}

	public void setStart(int start) {
	  this.start = start;
	}

	public int getEnd() {
	  return end;
	}

	public void setEnd(int end) {
	  this.end = end;
	}
		   
		   
		   
		   
		

}

