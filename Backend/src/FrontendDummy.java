import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;



public class FrontendDummy {
	static Maze maze;
	static Solution solution;
	static Solveable solver;
	static long Time;



	public static void main (String[] args) throws JsonParseException, JsonMappingException, IOException {
        //maze = jsonToMaze(args[1]);
	    maze=jsonToMaze();

	    solver = new Backtracking();


		final long timeStart = System.currentTimeMillis(); 
		
		solution = solver.solve(maze);
		
	    final long timeEnd = System.currentTimeMillis(); 
		Time =timeEnd-timeStart;
		

	    System.out.println(solutionToString(solution));   
	}




	public static Maze jsonToMaze () throws JsonParseException, JsonMappingException, IOException  {
	    ObjectMapper objectMapper = new ObjectMapper();
	    
	    File file;
	    try {
	        file = new File("maze.json"); 
	        Maze mazeJson = objectMapper.readValue(file, Maze.class);
	
	        return mazeJson; 
	    }
	    catch(Exception e) {
	    	System.out.println("File not found");
	    }
	    
	    
        Maze mazeJson = new Maze();
	    return mazeJson;
	}




	private static String solutionToString (Solution solution) {
	
	    System.out.println( "\n \nIs Solved: " + solution.isSolved() + "\n" +"\n"
	    + "Solution: "+ solution.getSolution() );
	    
	    System.out.println( "\nRuntime: " + Time+" ms");

		List<List<String>> liste = solution.getHistory();
		
		System.out.println("\nHistory: \n");
	    for(List<String> value : liste) {
		
		    if(value.size()>0) {
		        System.out.println(value.get(0)+" : "+value.get(1));
	        }
	    }
	

	    return "";
	}

}
