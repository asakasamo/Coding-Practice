class Escapist {
  constructor(maze) {
    this.R_EDGE = maze[0].length -1;
    this.B_EDGE = maze.length -1;
    this.visited = {};
    this.maze = maze;
    this.solution = "";
    
    this.findEscape();
  }
  
  findEscape() {
    //find start position
    let [startx, starty, dir] = this.getStartPos;
    
    //depth first search stores solution string in this.escape
    this.depthVisit(startx, starty, dir);
  }
  
  isEscape(x, y) {
    return x === 0 || x === this.B_EDGE || y === 0 || y === this.R_EDGE;
  }
  
  inBounds(x, y) {
    return x >= 0 && y >= 0 && x <= this.B_EDGE && y <= this.R_EDGE;
  }
  
  isWall(x, y) {
    return this.maze[x][y] === "#";
  }
  
  get getStartPos() {
    const body = /\^|v|<|>/g;
  
    for(let x = 0; x <= this.B_EDGE; x++){
      for(let y = 0; y <= this.R_EDGE; y++){        
        if(this.maze[x][y].match(body))
          return [x, y, this.maze[x][y]];
      }
    }
    
    throw "Maze is invalid";
  }
  
  orientToDir(start, end){  
    const dirs = ["^", ">", "v", "<"];
    let instructions = [];
    let curr = dirs.findIndex((elem) => elem === start);
    
    while(start != end){
      instructions.push("R");
      curr = (curr + 1) % 4
      start = dirs[curr];
    }
    
    return instructions;
  }
  
  depthVisit(x, y, solution) {      
    if(!this.inBounds(x,y))
      return;
    
    if(this.isWall(x, y))
      return;
      
    const visited = this.visited[`${x},${y}`];
    if(visited)
      return;
    
    if(this.isEscape(x,y)){
      this.solution = solution;
      return;
    }
    
    this.visited[`${x},${y}`] = true;
        
    this.depthVisit(x-1, y, solution + '^');
    this.depthVisit(x+1, y, solution + 'v');
    this.depthVisit(x, y-1, solution + '<');
    this.depthVisit(x, y+1, solution + '>');
  }
  
  get escape(){
    //convert the escape to proper array format
    let esc = [];
    for(let i = 0; i < this.solution.length -1; i++){
      esc.push(...(this.orientToDir(this.solution[i], this.solution[i+1])), "F");
    }
    
    return esc;
  }
}

function escape(maze) {
  // Return the array of movements to execute to get out of the maze
  return (new Escapist(maze)).escape;
}