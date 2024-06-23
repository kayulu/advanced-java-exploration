package com.kayulu.java11.annotations;

import java.lang.annotation.Repeatable;

// Define the Container Annotation
@interface Batteries {      // by convention, the plural of the annotation is used
    Battery[] value();      // must be value()
}

// This would be the old way of doing it without requiring the @Repeatable annotation
//@Batteries({
//        @Battery(level = "high", recharge = false),
//        @Battery(level = "low", recharge = true)
//})
//class ElectricCar{}


// Define the Repeated Annotation
@Repeatable(Batteries.class)
@interface Battery{
    String level();
    boolean recharge();
}

@Battery(level="high", recharge=false)
@Battery(level="low", recharge=true)
class ElectricCar{}


public class RepeatableExample {

}
