let loopers = [];

class Looper {
  constructor(value) {
    this.value = value;
    this.idx = -1;
  }
  
  increment() {
    this.idx++;
    if(this.idx >= this.value.length)
      this.idx = 0;
  }
  
  get next() {
    this.increment();
    return this.value.charAt(this.idx);
  }
} 

function addLooper(str) {
  loopers.push(new Looper(str)); 
  return loopers[loopers.length -1];
}

function makeLooper(str) {
  // TODO: return a function that loops through 'str' on successive invocations
  let looper = addLooper(str);
  return () => looper.next;
}
 
makeLooper("done");