package com.company;

// key word extends is used to inherit from other class
public class Punkt3D extends Punkt2D {
    private double z;

    // Constructor
    public Punkt3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    // Getters
    public double getZ() {
        return z;
    }

    // Setters
    public void setZ(double z) {
        this.z = z;
    }

    // Method that returns distance between current point and point given as argument
    public double distance(Punkt3D other) {
        return Math.sqrt(Math.pow(super.distance(other), 2) + Math.pow(this.getZ() - other.getZ(), 2));
    }

    @Override
    public String toString() {
        return "X: " + super.getX() + "Y: " + super.getY() + "Z: " + this.getZ();
    }
}