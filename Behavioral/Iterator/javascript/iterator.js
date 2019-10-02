/*
 * [1] In JavaScript an iterator is an object which defines a sequence and potentially
 * a return value upon its termination. More specifically an iterator is any object
 * which implements the Iterator protocol by having a next() method which returns
 * an object with two properties: value, the next value in the sequence; and done,
 * which is true if the last value in the sequence has already been consumed. If
 * value is present alongside done, it is the iterator's return value.
 * 
 * [2] An object is iterable if it defines its iteration behavior, such as what values are
 * looped over in a for...of construct. Some built-in types, such as Array or Map, have
 * a default iteration behavior, while other types (such as Object) do not.
 * 
 * In order to be iterable, an object must implement the @@iterator method, meaning that
 * the object (or one of the objects up its prototype chain) must have a property with a
 * Symbol.iterator key.
 */

const FibonacciIterable = (max = Number.MAX_SAFE_INTEGER) => {
  const serie = [0, 1];

  // Generate serie
  for(let i = 2; i <= max; i++) {
    if(serie[i-1] + serie[i-2] > Number.MAX_SAFE_INTEGER) break;
    serie[i] = serie[i-1] + serie[i-2];
  }

  let post = 0;
  return {
    // Return the next method according to the Iterator protocol [1]
    next: () => {
      if(post >= serie.length)
        return { value: undefined, done: true };
      else
        return { value: serie[post++], done: false };
    },
    // Return the method Symbol.iterator according to Iterable protocol [2]
    [Symbol.iterator] () {
      return this
    }
  }
}

function main(){
  let fib = FibonacciIterable(5);
  for(let item of fib){
    console.log(item);
  }

  let fib2 = FibonacciIterable(10);
  console.log(fib2.next());
  console.log(fib2.next());
  console.log(fib2.next());
  console.log(fib2.next());
  console.log(fib2.next());
  console.log(fib2.next());
  console.log(fib2.next());
  console.log(fib2.next());
  console.log(fib2.next());
  console.log(fib2.next());
  console.log(fib2.next());
  console.log(fib2.next());
}

main();
