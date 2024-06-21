package com.kayulu.annotations;

import java.lang.annotation.Inherited;

// 1. Apply directly.
// 2. Apply via inheritance.

//@interface BreatheInWater{}
@Inherited @interface BreatheInWater{} // this is an inheritable annotation

@BreatheInWater class Fish{}

class Trout extends Fish{}  // this also inherits the annotation of its parent

public class InheritedExample {

}
