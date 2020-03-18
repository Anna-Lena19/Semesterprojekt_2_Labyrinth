import React from 'react';
import './App.css';




const maze = {
  maze: ["START","EMPTY","EMPTY","WALL","WALL","WALL","WALL","WALL","EMPTY","WALL","EMPTY","WALL","EMPTY","WALL","WALL","EMPTY","EMPTY","EMPTY","EMPTY","EMPTY","WALL","WALL","EMPTY","EMPTY","EMPTY","WALL","EMPTY","WALL","WALL","EMPTY","EMPTY","EMPTY","WALL","EMPTY","WALL","WALL","EMPTY","WALL","EMPTY","WALL","EMPTY","WALL","WALL","EMPTY","EMPTY","EMPTY","EMPTY","WALL","WALL","WALL","WALL","WALL","WALL","WALL","WALL","WALL","EMPTY","EMPTY","WALL","EMPTY","WALL","EMPTY","WALL","WALL","EMPTY","EMPTY","EMPTY","EMPTY","EMPTY","WALL","WALL","EMPTY","EMPTY","EMPTY","EMPTY","EMPTY","WALL","WALL","EMPTY","EMPTY","EMPTY","WALL","EMPTY","WALL","WALL","EMPTY","EMPTY","EMPTY","WALL","EMPTY","WALL","WALL","WALL","WALL","WALL","WALL","WALL","END","EMPTY","EMPTY"],
  sizeX: 10,
  sizeY: 10,
  start: 0,
  end: 98
}

 class App extends React.Component {
  /*Konstruktor*/
  constructor(props) {
    super(props);
    this.state = {
      Groese: 10,
      fetched:false,
      MazeV:{maze: [],
      sizeX: 0,
      sizeY: 0,
      start: 0,
      end: 0},
    }
  }


/*returns the history */
change(runtime,history,event){
if(this.state.fetched==true){
  var lenge =0;
   

  for(var i = 0; (lenge==0); i++) { 
    
    var tmp = history[i][0];
    tmp = tmp.toString();

      
    if(history[i][0]==-1){

    }
    else if(history[i][1]=="DEAD_END"){
      document.getElementById(tmp).style.backgroundColor="indianred";
    }
    else if(history[i][1]=="SOLUTION"){
      lenge = 1;   
    }
    else{
      var co = document.getElementById(tmp).style.backgroundColor;
          
      if(co == "lightblue" || co == "grey" ||co =="lightgreen"){
           
      }
      else{
        document.getElementById(tmp).style.backgroundColor="green";
      }
          
    }
   
  } 
}
else{
  alert("No Solution found !");
}

}






/*send solution */
fetchSolution (json) {
  fetch('http://localhost:8080/maze', {
      method: 'POST',
      headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
      },
      body: json
    }).then(response => response.json())
      
      
    .then(data => this.setState({ solution: data.solution, history: data.history, runtime: data.runtime, solved: data.solved, fetched: true}));
      
}








/*set State MazeV */
UpdateState(){
   
  var z =0;
  var groese =(this.state.Groese * this.state.Groese)-1;
  var MazeField=[];
  var Start;
  var End;
 
  for(z;z<=groese;z++){
    var n = z.toString();

    var coll = document.getElementById(n).style.backgroundColor;
    if(coll=="grey"){
      Start=z;
      MazeField.push("START");
    }
    else if(coll=="lightgreen"){
      End=z;
      MazeField.push("END");
    }
    else if(coll=="lightblue"){
      MazeField.push("WALL");
    }
    else if(coll=="rgb(248, 197, 197)"){
      MazeField.push("EMPTY");
    }
 }

  

  this.setState({MazeV:{maze: MazeField,
  sizeX: this.state.Groese,
  sizeY: this.state.Groese,
  start: Start,
  end: End}});
}











/*call fechSolution with MazeV*/
callFunction(){
  alert("Ergebniss wird berechnet...");
  this.fetchSolution(JSON.stringify(this.state.MazeV));
}




/*Set size of Maze */
setGroese(event){
  var k = event.target.value;
  this.setState({Groese:k});

}






/*Set color of button */
SetButton(wall){
  
  var col = document.getElementById(wall).style.backgroundColor;
  if(col=="lightgrey"){
  
    document.getElementById(wall).style.backgroundColor ="rosybrown";
  }
  else{
     
    document.getElementById(wall).style.backgroundColor="lightgrey";
  }
}





/*set a wall, start, end */
SetItem(i){
 
  
  var col2 = document.getElementById("wall").style.backgroundColor;
  var col3 = document.getElementById("start").style.backgroundColor;
  var col4 = document.getElementById("end").style.backgroundColor;

  var index=i.toString();

  if(col2 == "rosybrown" && col3=="lightgrey" && col4 =="lightgrey"){
    document.getElementById(index).style.backgroundColor="lightblue";
  }
  else if(col2 == "lightgrey" && col3=="rosybrown" && col4 =="lightgrey"){
    document.getElementById(index).style.backgroundColor="grey";
  }
  else if(col2 == "lightgrey" && col3=="lightgrey" && col4 =="rosybrown"){
    document.getElementById(index).style.backgroundColor="lightgreen";
  }
}





/*return Button */
renderSquare(i){

  let styles = {
    margin: "1px",
    width: "30px",
    height: "30px",
    backgroundColor:"rgb(248, 197, 197)" ,
  };
  
 
  return(
    <button id={i} style={styles} onClick={this.SetItem.bind(this,i)}/>
  );
} 



/*return Maze */
renderSolution () {

  let content, fields;

      
  fields=[];
  var teiler=this.state.Groese;
  var end=teiler*teiler;
  var z=0;
  for(z;z<end;z++){
    if(z%teiler==0){
      content =(<br/>);
      fields.push(content);
    }
    content=(<span>{this.renderSquare(z)}</span>);
    fields.push(content);
  }

  return(
    <div id="content">
      <div id="maze">{fields}</div>
      
    </div>
  );
}




/*render site*/
render () {
  return (
    <div className="App">
      <div className="header">
        <h1 className="title">Labyrinth - The Game</h1>
        <hr id="line"/>
      </div>

      <div id="button">
      <br/>
        <div class="wallDiv">
          <button id="wall" style={{backgroundColor:"lightgrey"}} onClick={this.SetButton.bind(this,"wall")}>
            Place Wall
          </button>
          <div class="wallBlock" id="wallColor"> ___ </div>
        </div>
        <br/>

        <div class="wallDiv">
          <button id="start" style={{backgroundColor:"lightgrey"}} onClick={this.SetButton.bind(this,"start")}>
            Place Start
          </button>
          <div class="wallBlock" id="startColor"> ___ </div>
        </div>
        <br/>

        <div class="wallDiv">
          <button id="end" style={{backgroundColor:"lightgrey"}} onClick={this.SetButton.bind(this,"end")}>
            Place End
          </button>
          <div class="wallBlock" id="endColor"> ___</div>
        </div>
        <br/>

        <button id="startGame"  onClick={()=> {this.UpdateState(); this.callFunction(); setTimeout(()=>{this.fetchSolution.bind(this,JSON.stringify(this.state.MazeV));},1000); setTimeout(()=>{this.change(this.state.runtime,this.state.history);},1000); }}>
          Start Game
        </button>
        <br/>
        <br/>
        <br/>
        Change the size <br/>
        of Maze:
        <br/>
        <input type="text" size="9" onChange={this.setGroese.bind(this)}></input>
        <br/>
        <br/>
      </div>

      <div id="solution">{this.renderSolution()}</div>
    </div>
  );
}


}

export default App;