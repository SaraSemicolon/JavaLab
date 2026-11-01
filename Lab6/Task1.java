package Lab6;

import java.util.Arrays;

abstract class GeometricObject implements Comparable<GeometricObject>
{
    protected String color;
    protected boolean filled;

     GeometricObject (String color, boolean filled)
    {
        setColor(color); setFilled(filled);
    }

    public String getColor() {return color;}
    public void setColor(String color) {this.color = color;}
    public boolean isFilled() {return filled;}
    public void setFilled(boolean filled) {this.filled = filled;}

    @Override
    public String toString() {
        return "GeometricObject{" +
                "color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }

    abstract public double area ();

     public int compareTo (GeometricObject g)
     {
         if(area() < g.area())
             return -1;
         else if(area() > g.area())
             return 1;
         else
             return 0;
     }
}

class ComparableSorting
{
    public static <T extends Comparable<T>> void sort (T[] arr) {Arrays.sort(arr);}
}

class Circle extends GeometricObject
{
    protected float radius;

     Circle (String color, boolean filled, float radius)
    {
        super(color,filled);
        setRadius(radius);
    }

    public float getRadius() {return radius;}
    public void setRadius(float radius) {this.radius = radius;}


    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                ", area=" + area() +
                '}';
    }

    public double area ()
    {
        return 3.14 * Math.pow(radius,2);
    }
}

class Rectangle extends GeometricObject
{
    protected float length ,width;

    Rectangle (String color, boolean filled, float length, float width)
    {
        super(color,filled);
        setLength(length); setWidth(width);
    }

    public float getLength() {return length;}
    public void setLength(float length) {this.length = length;}
    public float getWidth() {return width;}
    public void setWidth(float width) {this.width = width;}

    @Override
    public String toString() {
        return "Rectangle{" +
                "length=" + length +
                ", width=" + width +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                ", area=" + area() +
                '}';
    }

    public double area ()
    {
        return length * width;
    }
}

class Square extends Rectangle
{
    Square(String color, boolean filled, float side)
    {
        super(color
                ,filled
                ,side
                ,side);
    }

    public float getSide() {return length;}
    public void setSide(float side) {setLength(side); setWidth(side);}

    @Override
    public String toString() {
        return "Square{" +
                "filled=" + filled +
                ", color='" + color + '\'' +
                ", width=" + width +
                ", length=" + length +
                ", area=" + area() +
                '}';
    }

    public double area ()
    {
        return Math.pow(length,2);
    }
}

public class Task1
{
    public static void main(String[] args)
    {
        GeometricObject[] arr = new GeometricObject[3];
        arr[0] = new Circle("red",false,5);
        arr[1] = new Rectangle("blue",false,3,7);
        arr[2] = new Square("yellow",true,4);

        System.out.println("--- show the information of geometric objects whose areas exceed 20 ---");
        for(int i = 0; i < arr.length; i++)
            if(arr[i].area() > 20)
                System.out.println(arr[i].toString());

        System.out.println("--- Before Sorting ---");
        for(int i=0;i<arr.length;i++)
            System.out.println(arr[i].toString());

        ComparableSorting.sort(arr);

        System.out.println("--- After Sorting ---");
        for(int i=0;i<arr.length;i++)
            System.out.println(arr[i].toString());

    }
}
