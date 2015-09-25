import java.lang.*;
import java.util.*;

/***
  * Represents the balls position and speed vectors.
***/


public class Vector {
  private double x;
  private double y;
  
  public Vector(double x, double y) {
    this.x = x;
    this.y = y;
  }
  
  public Vector add(Vector v) {
    Vector w = new Vector(this.getX() + v.getX(), this.getY() + v.getY());
    return w;
  }
  
  public Vector sub(Vector v) {
    Vector w = new Vector(this.getX() - v.getX(), this.getY() - v.getY());
    return w;
  }
  
  public double dot(Vector v) {
    return (this.getX()*v.getX())+(this.getY()*v.getY());
  }
  
  public Vector scale(double d) {
    Vector w = new Vector(this.getX()*d, this.getY()*d);
    return w;
  }
  
  public double distance(Vector v) {
    return Math.sqrt(Math.pow((this.getX() - v.getX()),2) + 
                     Math.pow((this.getY() - v.getY()),2));
  }
    
  public double length() {
    return Math.sqrt(Math.pow(this.getX(),2)+Math.pow(this.getY(),2));
  }
  
  public double getX() {
    return this.x;
  }
  
  public double getY() {
    return this.y;
  }
  
  public Vector flipSignX() {
    Vector w = new Vector(-this.getX(), this.getY());
    return w;
  }
  
  public Vector flipSignY() {
    Vector w = new Vector(this.getX(), -this.getY());
    return w;
  }
  
  public static Vector randomVector(double len) {
    Vector w = new Vector(len/Math.sqrt(2), len/Math.sqrt(2));
    return w;
  }
  
  public double angle() {
    return (double)(Math.atan2(this.getY(), this.getX()));
}

  public static Vector polar(double length, double angle) {
    Vector w = new Vector(length*Math.cos(angle), 
                          length*Math.sin(angle));
    return w;
  }
  
  public String toString() {
    return this.toString();
  }
  
  public static void main(String[] args) { 
    Vector v = new Vector(1, 1);
  }
}