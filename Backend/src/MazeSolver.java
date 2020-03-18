
public abstract class MazeSolver implements Solveable {

  private Field[] maze;
  private String[] mazeS;
  private int sizeX = 0;
  private int sizeY=0;
  private int start=0;
  private int end=0;
  


  public Field[] getField(){
    return maze;
  }
  
  public String[] getMazeS(){
	return mazeS;
  }
  
  public int getSizeX(){
    return sizeX;
  }
  
  public int getSizeY(){
    return sizeY;
  }
  
 public int getStart(){
    return start;
  }
  
  public int getEnd(){
    return end;
  }
  
  
    
  
  public void setField(Field[] maze){
    this.maze=maze;
  }
  
  public void setMaseS(String[] mazeS){
	    this.mazeS=mazeS;
	  }
  
  public void setSizeX(int sizeX){
    this.sizeX=sizeX;
  }
  
  public void setSizeY(int sizeY){
    this.sizeY=sizeY;
  }
  
  public void setStart(int start){
    this.start=start;
  }
  
  public void setEnd(int end){
    this.end=end;
  }
   

  public abstract void parseFromJSON(Maze maze);

}

