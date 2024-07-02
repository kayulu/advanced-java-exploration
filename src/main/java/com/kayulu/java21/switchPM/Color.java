package com.kayulu.java21.switchPM;

sealed interface Color permits Primary, Rainbow {}
enum Primary implements Color{ RED, GREEN, BLUE}
enum Rainbow implements Color{ RED, ORANGE, YELLOW, GREEN,
    BLUE, INDIGO, VIOLET}
