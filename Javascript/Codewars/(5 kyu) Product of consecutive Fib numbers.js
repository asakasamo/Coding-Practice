function productFib(prod){
  let [n_1, n_2, fib] = [0, 1, 1];
  
  while(fib * n_1 < prod){      
    [n_2, n_1] = [n_1, fib];
    fib = n_1 + n_2;
  }
  
  return [n_1, fib, (n_1 * fib === prod)];
}

//Test.assertSimilar(productFib(602070), [610, 987, true]);