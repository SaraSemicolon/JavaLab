package Lab5;

class Point2D
{
    private double x ,y;

    Point2D (double x ,double y)
    {
        setXY(x,y);
    }

    public double getX() {return x;}
    public void setX(double x) {this.x = x;}
    public double getY() {return y;}
    public void setY(double y) {this.y = y;}

    public void setXY (double x,double y)
    {
        setX(x); setY(y);
    }

    public double [] getXY ()
    {
        return new double [] {x,y};
    }

    public double distance (Point2D p)
    {
        double dx = this.x - p.getX();
        double dy = this.y - p.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    public double distance (double x, double y)
    {
        double dx = this.x - x;
        double dy = this.y - y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    public static double distance (Point2D p1, Point2D p2)
    {
        return p1.distance(p2);
    }

    @Override
    public boolean equals(Object obj)
    {
        Point2D p = (Point2D) obj;
        return (x == p.getX()) && (y == p.getY());
    }

    @Override
    public String toString()
    {
        return "Point2D(" + x + "," + y + ')';
    }
}

class Point3D extends Point2D
{
    private double z;
    Point3D (double x ,double y ,double z)
    {
        //setXYZ(x,y,z);
        super(x,y);
        setZ(z);
    }

    public double getZ() {return z;}
    public void setZ(double z) {this.z = z;}

    public void setXYZ (double x,double y,double z)
    {
        setXY(x,y); setZ(z);
    }

    public double [] getXYZ ()
    {
        return new double [] {getX(),getY(),z};
    }

    public double distance (Point3D p) {
        double dx = getX() - p.getX();
        double dy = getY() - p.getY();
        double dz = this.z - p.getZ();
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    public double distance (double x, double y, double z) {
        double dx = getX() - x;
        double dy = getY() - y;
        double dz = this.z - z;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    @Override
    public boolean equals(Object obj)
    {
        Point3D p = (Point3D) obj;
        return (getX() == p.getX()) && (getY() == p.getY()) && (z == p.getZ());
    }

    @Override
    public String toString()
    {
        return "Point3D(" + getX() + "," + getY() + "," + z + ')';
    }

}

public class Task1
{
    public static void main(String[] args)
    {
        Point2D [] points = new Point2D [5];
        points[0] = new Point2D (3,4);
        points[1] = new Point3D (5,7,4);
        points[2] = new Point2D (2,7);
        points[3] = new Point2D (3,4);
        points[4] = new Point3D (5,7,1);

        for(int i =0 ;i< points.length -1; i++)
        {
            boolean type1 = points[i] instanceof Point3D;
            for(int j = i+1 ; j<points.length;j++)
            {
                boolean type2 = points[j] instanceof Point3D;
                if(!type1 && !type2)
                {
                    System.out.println(points[i].toString());
                    System.out.println(points[j].toString());
                    System.out.println("--- Distance Of Two Points 2D = " + Point2D.distance(points[i], points[j]) + " ---");
                    System.out.println("--- Are Equal " + points[i].equals(points[j]) + " ---");
                }
                else if (type1 && type2)
                {
                    Point3D p1 = (Point3D) points[i];
                    Point3D p2 = (Point3D) points[j];
                    System.out.println(p1.toString());
                    System.out.println(p2.toString());
                    System.out.println("--- Distance Of Two Points 3D =  " + p1.distance(p2) + " ---");
                    System.out.println("--- Are Equal " + p1.equals(p2) + " ---");
                }
            }
        }

    }
}
