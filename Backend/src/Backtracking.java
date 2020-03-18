import java.util.LinkedList;
import java.util.List;



public class Backtracking extends MazeSolver {
  
  Field[] mazeField;
 
  public int counter =0;

  boolean result;

  


	public boolean backtrack(int size,int x, Solution s){	

	  s.addToHistory(counter, Integer.toString(x));
	  s.addToHistory(counter, "CURRENT");
    counter++;


    if(x>(size*size)-1||x<0){
      return false;
    }
	
	  if(mazeField[x]==Field.END){
	    s.addToSolution(x);
	    s.setSolved(true);
	  
	    return true;
    }

    else if(mazeField[x]==Field.WALL){ 
      return false;
    }

     


    s.addToHistory(counter, Integer.toString(x));
 	  s.addToHistory(counter, "VISITED");
 	  counter++;
     
    mazeField[x]=Field.WALL;



    result= backtrack(size,x+size,s);

    if (result) {
    	s.addToSolution(x);
      s.addToHistory(counter, Integer.toString(x));
 	    s.addToHistory(counter, "SOLUTION");
      counter++; 
       
      return true;
    }

     
    result= backtrack(size,x+1,s);

    if (result) {
    	s.addToSolution(x);
      s.addToHistory(counter, Integer.toString(x));
 	    s.addToHistory(counter, "SOLUTION");
      counter++;
       
      return true;
    }
     
     
    result= backtrack(size,x-size,s);

    if (result) {
    	s.addToSolution(x);
      s.addToHistory(counter, Integer.toString(x));
 	    s.addToHistory(counter, "SOLUTION");
      counter++; 
      return true;
    }
  
     
    result= backtrack(size,x-1,s);

    if (result) {
    	s.addToSolution(x);
      s.addToHistory(counter, Integer.toString(x));
 	    s.addToHistory(counter, "SOLUTION");
      counter++; 
      return true;
    }

    
    
    s.addToHistory(counter, Integer.toString(x));
 	  s.addToHistory(counter, "DEAD-END");
 	  counter++;
   
    return false;
	}
    
    
	
  public Solution solve(Maze maze){
    Solution solution= new Solution();

    Backtracking back = new Backtracking();

    back.parseFromJSON(maze);

    back.mazeField = back.getField();

    int start = back.getStart();
    int sizeField = back.getSizeX();

    back.backtrack(sizeField, start, solution);

	 
    return  solution ;
  }





  public void parseFromJSON(Maze maze){
  
    int mazeSize = maze.getSizeX()*maze.getSizeX();
  
    Field[] field= new Field[mazeSize];
 
    setSizeX(maze.getSizeX());
    setSizeY(maze.getSizeY());
    setStart(maze.getStart());
    setEnd(maze.getEnd());

	  String[] array = {"WALL","WALL","WALL","WALL", "WALL", "WALL", "WALL", "WALL", "WALL", "WALL","WALL","START","WALL","EMPTY","EMPTY","EMPTY","EMPTY","EMPTY","EMPTY","WALL","WALL","EMPTY","WALL","EMPTY","WALL", "WALL", "WALL", "WALL", "WALL", "WALL","WALL","EMPTY","WALL","EMPTY","EMPTY","WALL", "EMPTY","EMPTY","EMPTY","WALL","WALL","EMPTY","WALL","WALL", "EMPTY","EMPTY","EMPTY","WALL", "WALL", "WALL","WALL","EMPTY","EMPTY","WALL","EMPTY","WALL", "EMPTY","EMPTY","EMPTY","WALL",
	                   "WALL","EMPTY","WALL","WALL", "EMPTY","WALL", "WALL", "WALL", "EMPTY","WALL","WALL","EMPTY","EMPTY","EMPTY","EMPTY","WALL","END",  "WALL", "EMPTY","WALL","WALL","EMPTY","WALL","EMPTY","EMPTY","WALL", "EMPTY","EMPTY","EMPTY","WALL","WALL","WALL", "WALL","WALL", "WALL", "WALL", "WALL", "WALL", "WALL", "WALL"} ;       
               
    //String[] array=maze.getMaze(); 
	  
	  
    for(int i=0;i<mazeSize;i++){ 
	    
      if(array[i]=="WALL"){
        field[i]=Field.WALL;
      }

      else if(array[i]=="EMPTY"){
        field[i]=Field.EMPTY;
      }

      else if(array[i]=="START"){
        field[i]=Field.START;
      }

      else if(array[i]=="END"){
        field[i]=Field.END;
      }
    }
  

    setField(field);
    mazeField= field;
  }

}
