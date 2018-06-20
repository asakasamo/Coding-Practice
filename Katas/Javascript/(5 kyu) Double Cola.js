function whoIsNext(names, r){
  let level = 0;
  const nameCount = names.length;

  while(getLeadingTerm(nameCount, level) <= r)
    level++;
  level--;

  const leadingTerm = getLeadingTerm(nameCount, level);
  const offset = r - leadingTerm;
  let clones = Math.pow(2, level);
  let answer = offset / clones;
  
//   console.log(names);
//   console.log(level,leadingTerm, offset, clones, answer);
  
  return names[parseInt(answer)];
}

function getLeadingTerm(nameCount, level) {
  if(level === 0)
    return 1;
  
  let term = nameCount +1;
  for(let i = 1; i < level; i++){
    term += (Math.pow(2, i) * nameCount);
  }
  
  return term;
}