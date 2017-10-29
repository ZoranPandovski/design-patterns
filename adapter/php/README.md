Here we will discussion on design patterns by taking a look at the adapter design pattern.
This particular pattern can be used when your code is dependent on some external API, or any other class that is prone to 
change frequently. This pattern falls under the category of "structural patterns" because it teaches us how our code and 
our classes should be structured in order to manage and/or extend them easily.

Again, I'd like to reiterate that design patterns have nothing new over traditional classes. Instead,
they show us a better way to structure our classes, handle their behavior, and manage their creation.
## The Problem

```php
<?php
class PayPal {
 
    public function __construct() {
        // Your Code here //
    }
 
    public function sendPayment($amount) {
        // Paying via Paypal //
        echo "Paying via PayPal: ". $amount;
    }
}
 
$paypal = new PayPal();
$paypal->sendPayment('2629');
```

In the above code, you can see that we are utilizing a PayPal class to simply pay the amount. Here, we are directly 
creating the object of the PayPal class and paying via PayPal. You have this code scattered in multiple places. 
So we can see that the code is using the ``` $paypal->sendPayment('amount here'); ``` method to pay. 

Some time ago, PayPal changed the API method name from ``` sendPayment``` to ```payAmount```. 
This should clearly indicate a problem for those of us who have been using the ```sendPayment``` method. Specifically,
we need to change all ```sendPayment``` method calls to ```payAmount```. Imagine the amount of code we need to change and 
the time we need to spend on testing each of the features once again.

## The Solution:
One solution to this problem is to use the adapter design pattern. 
According to **Wikipedia**:
***In software engineering, the adapter pattern is a software design pattern that allows the 
   interface of an existing class to be used from another interface. It is often used to make existing classes
   work with others without modifying their source code.***
   
In this case, we should create one wrapper interface which makes this possible. 
We will not make any changes in the external class library because we do not have control over it and it may change any time. 

Let's dig into the code now, which shows the adapter pattern in action:
```php
// Concrete Implementation of PayPal Class
class PayPal {
     
    public function __construct() {
        // Your Code here //
    }
     
    public function sendPayment($amount) {
        // Paying via Paypal //
        echo "Paying via PayPal: ". $amount;
    }
}
 
// Simple Interface for each Adapter we create
interface paymentAdapter {
    public function pay($amount);
}
 
class paypalAdapter implements paymentAdapter {
     
    private $paypal;
 
    public function __construct(PayPal $paypal) {
        $this->paypal = $paypal;
    }
     
    public function pay($amount) {
        $this->paypal->sendPayment($amount);
    }
}

```

Study the code above and you should be able to tell that we have not introduced any changes into the main ``` PayPal``` class.
Instead we have created one interface for our payment adapter and one adapter class for ```PayPal```.

And so afterward we have made the object of the adapter class instead of the main ```PayPal``` class.
While creating an object of ```adapter``` class we will pass the object of the main ```PayPal``` class as an argument,
so that ```adapter``` class can have a reference to the main class and it can call the required methods of the main ```PayPal``` class.

Let's find out how we can utilize this method directly:
```php
// Client Code
$paypal = new paypalAdapter(new PayPal());
$paypal->pay('2629');
```
Now imagine PayPal changes its method name from ```sendPayment``` to payAmount. 
Then we just need to make changes in ```paypalAdapter```. Just have a look at the revised adapter code, which has just one change.

```php
class paypalAdapter implements paymentAdapter {
     
    private $paypal;
 
    public function __construct(PayPal $paypal) {
        $this->paypal = $paypal;
    }
     
    public function pay($amount) {
        $this->paypal->payAmount($amount);
    }
}
```
So just one change and we are there.
## Adding a New Adapter

At this point, we've seen how we can use the adapter design patten to overcome the aforementioned scenarios. Now,
it's very easy to add a new class dependent on the existing adapter. Let's say the MoneyBooker API is there for payment.

Then instead of using the MoneyBooker class directly, we should be applying the same adapter pattern we just used for PayPal.

```php

// Concrete Implementation of MoneyBooker Class
class MoneyBooker {
 
    public function __construct() {
        // Your Code here //
    }
 
    public function doPayment($amount) {
        // Paying via MoneyBooker //
        echo "Paying via MoneyBooker: ".  $amount;
    }
}
 
// MoneyBooker Adapter
class moneybookerAdapter implements paymentAdapter {
 
    private $moneybooker;
 
    public function __construct(MoneyBooker $moneybooker) {
        $this->moneybooker = $moneybooker;
    }
 
    public function pay($amount) {
        $this->moneybooker->doPayment($amount);
    }
}
 
// Client Code
$moneybooker = new moneybookerAdapter(new MoneyBooker());
$moneybooker->pay('2629');

```
## Conclusion
A great application is constantly hooked into other libraries and APIs, so I would propose that we implement the adapter method, 
so that we do not experience any trouble when a third-party API or library changes its code base.

I have tried my best to provide an elementary and yet useful example to demonstrate the adapter design pattern, 
but if you have additional comments or questions, please don't hesitate to add them in the feed below.

