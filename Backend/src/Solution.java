import java.util.*;

public class Solution {

  public boolean solved;
  public long runtime;
  public List<Integer> solution;
  public List<List<String>> history;
   
   
  Solution(){
	  this.solution= new ArrayList<Integer>();
	  this.history= new ArrayList<List<String>>();
  }
   

  public boolean isSolved(){
    return solved;
  }
   
  public void setSolved(boolean result){
    this.solved=result;
  }
   
  public long getRuntime(){
    return runtime;
  }
   
  public void setRuntime(long runtime){
	  this.runtime=runtime;
  }
   
  public void addToSolution(int index){
    this.solution.add(0,index);
  }
   
  public List<Integer> getSolution(){
    return solution;
  }
   
  public void addToHistory(int index, String status){
	  this.history.add(new ArrayList<String>());
	  this.history.get(index).add(status); 
  }
   
  public List<List<String>> getHistory(){
    return history;
  }
 
}

