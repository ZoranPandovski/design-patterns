// Setup Subject
var Subject = function() {
  this.observerList = [];
};

Subject.prototype.subscribeObserver = function(obj) {
  this.observerList.push(obj);
};

Subject.prototype.unsubscribeObserver = function(obj) {
  var index = this.observerList.indexOf(obj);
  if (index > -1) {
    this.observerList.splice(index, 1);
  }
};

Subject.prototype.notifyObserver = function(obj) {
  var index = this.observerList.indexOf(obj);
  if (index > -1) {
    this.observerList[index].notify(index);
  }
};

Subject.prototype.notifyAllObservers = function() {
  for (var i = 0; i < this.observerList.length; i++) {
    this.observerList[i].notify(i);
  }
};

// Setup Observer
var Observer = function() {
  return {
    notify: function(index) {
      console.log("Observer " + index + " is notified!");
    }
  };
};

var subject = new Subject();

var observer1 = new Observer();
var observer2 = new Observer();
var observer3 = new Observer();
var observer4 = new Observer();

subject.subscribeObserver(observer1);
subject.subscribeObserver(observer2);
subject.subscribeObserver(observer3);
subject.subscribeObserver(observer4);

subject.notifyObserver(observer2); // Observer 1 is notified!

subject.notifyAllObservers();
// Observer 0 is notified!
// Observer 1 is notified!
// Observer 2 is notified!
// Observer 3 is notified!
