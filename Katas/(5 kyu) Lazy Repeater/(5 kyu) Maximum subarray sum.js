function maxSequence(arr) {
  if(arr.length === 0)
    return 0;
    
  let maxSum = 0;
  
  for(let start = 0; start < arr.length; start++){
    let current = 0;
    
    for(let i of arr.slice(start)){
      current += i;
      if(current > maxSum)
        maxSum = current;
    }
  }
  
  return maxSum;
}