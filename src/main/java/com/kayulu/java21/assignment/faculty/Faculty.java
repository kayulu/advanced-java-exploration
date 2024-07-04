package com.kayulu.java21.assignment.faculty;

abstract public sealed class Faculty implements Educational permits
        EngineeringFaculty, HumanitiesFaculty, BusinessFaculty {
}
