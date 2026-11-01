package Lab6;

interface Movable
{
    public void moveRight (float amount);
    public void moveDown (float amount);
    public void moveLeft (float amount);
    public void moveUp (float amount);
}

class MovablePoint implements Movable
{
    protected float xCoordinates, yCoordinates;
    protected float xAmount, yAmount;

    MovablePoint (float xCoordinates,float yCoordinates,float xAmount, float yAmount)
    {
        this.xCoordinates = xCoordinates;
        this.yCoordinates = yCoordinates;
        this.xAmount = xAmount;
        this.yAmount = yAmount;
    }

    @Override
    public String toString() {
        return "MovablePoint{" +
                "(" + xCoordinates +
                "," + yCoordinates +
                ")" +
                "\tAmount= (" + xAmount +
                "," + yAmount +
                ")" +
                '}';
    }

    public void moveRight (float amount) {xCoordinates += amount;}
    public void moveDown (float amount) {yCoordinates += amount;}
    public void moveLeft (float amount) {xCoordinates -= amount;}
    public void moveUp (float amount) {yCoordinates -= amount;}
}

public class Task2
{
    public static void main(String[] args)
    {
        Movable point = new MovablePoint(5,7,10,20);
        System.out.println("--- Before Update ---");
        System.out.println(point.toString());
        System.out.println("----------------------------------");
        System.out.println("--- After Update ---");
        point.moveRight(5);
        point.moveDown(3);
        point.moveLeft(7);
        point.moveUp(1);
        System.out.println(point.toString());
    }
}
