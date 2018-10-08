/* 
In JS, **Singleton** serve as a shared resource *namespacing* which isolate code
from the global namespace, to provide a single point of access for functions. 
*/

/* 
The pre ES6 way, using closures and IIFE it is possible to create a
single instance of a Object. 
*/
var Singleton = (function(){
  function Singleton() {
    var obj = new Object('New Instance');
    return obj;
  }
  var instance;
  return {
    getInstance: function() {
      if (!instance) {
        instance = new Singleton();
      }
      return instance;
    }
  };
}());

/* creating of the single instance */
var oneInstance = Singleton.getInstance(); 


/* 
The ES2015+ way take advantage of the const keyword that can't be reassign to
create a single instance of the Singleton. 
*/
let _singleton = null

class Singleton {
  constructor (data){
    if(!_singleton) {
      this.data = data
      _singleton = this
    }
    else return _singleton
    console.log("Singleton class created")
  }
  SingletonOperation() {
    console.log("SingletonOperation")
  }
  GetSingletonData () {
    return this.data
  }
}

const instance = new Singleton('newInstance')  