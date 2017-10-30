var PubSub = {};

(function(pubSub) {
  "use strict";

  var topics = {},
    lastUid = -1;

  var publish = function(topic, data) {
    if (!topics.hasOwnProperty(topic)) {
      return false;
    }

    var broadcast = function() {
      var subscribers = topics[topic];

      for (var i = 0, j = subscribers.length; i < j; i++) {
        try {
          subscribers[i].func(topic, data);
        } catch (e) {
          console.log(e);
        }
      }
    };

    setTimeout(broadcast, 0);
    return true;
  };

  pubSub.publish = function(topic, data) {
    return publish(topic, data, false);
  };

  pubSub.subscribe = function(topic, func) {
    var token = (++lastUid).toString();

    // Topic doesn't exist yet
    if (!topics.hasOwnProperty(topic)) {
      topics[topic] = [];
    }

    topics[topic].push({ token: token, func: func });

    // Return unsub token
    return token;
  };

  pubSub.unsubscribe = function(token) {
    for (var prop in topics) {
      if (topics.hasOwnProperty(prop)) {
        for (var i = 0, j = topics[prop].length; i < j; i++) {
          if (topics[prop][i].token === token) {
            topics[prop].splice(i, 1);
            return token;
          }
        }
      }
    }

    return false;
  };
})(PubSub);

// Suscriber callback
var subFunc = function(topics, data) {
  console.log(topics + ": " + data);
};

// Add the subscriber callback to the the list of subs to a topic
// Retain the subscription instance for unsubscribing later
var testSubscription = PubSub.subscribe("example", subFunc);

PubSub.publish("example", "Testing 1 2 3");
PubSub.publish("example", ["test", "4", "5", "6"]);
PubSub.publish("example", [{ test: "Yes" }, { pass: true }]);

// Wrap in setTimeout to be put to the end of the call stack
setTimeout(function() {
  PubSub.unsubscribe(testSubscription);
}, 0);

// Make sure the unsubscribe function worked.
// (Nothing should be displayed if it is unsubscribed)
PubSub.publish("example", "not unsubbed");
