package Lab5;

class Figure
{
    private Point2D startingPoint;
    private String color;

    Figure (Point2D startingPoint, String color)
    {
        setStartingPoint(startingPoint); setColor(color);
    }

    public Point2D getStartingPoint() {return startingPoint;}
    public void setStartingPoint(Point2D startingPoint) {this.startingPoint = startingPoint;}
    public String getColor() {return color;}
    public void setColor(String color) {this.color = color;}

    @Override
    public String toString() {
        return "Figure{" +
                "startingPoint=" + startingPoint +
                ", color='" + color + '\'' +
                '}';
    }
}

class ClosedFigure extends Figure
{
    private float width;
    private float height;
    private boolean filled ;

    ClosedFigure (Point2D startingPoint, String color ,float width ,float height ,boolean filled)
    {
        super(startingPoint,color);
        setWidth(width); setHeight(height); setFilled(filled);
    }

    public float getWidth() {return width;}
    public void setWidth(float width) {this.width = width;}
    public float getHeight() {return height;}
    public void setHeight(float height) {this.height = height;}
    public boolean isFilled() {return filled;}
    public void setFilled(boolean filled) {this.filled = filled;}

    public double area ()
    {
        return width * height;
    }

    @Override
    public String toString() {
        return "ClosedFigure{" +
                "width=" + width +
                ", height=" + height +
                ", filled=" + filled +
                '}';
    }
}

class Rectangle extends ClosedFigure
{
    Rectangle (Point2D startingPoint, String color ,float width ,float height ,boolean filled)
    {
        super(startingPoint,color,width,height,filled);
    }

    Rectangle (Point2D startingPoint, String color,boolean filled,Point2D endingPoint)
    {
        float width = (float) Math.abs(startingPoint.getX() - endingPoint.getX());
        float height = (float) Math.abs(startingPoint.getY() - endingPoint.getY());
        super(startingPoint,color,width,height,filled);
    }

    @Override
    public double area ()
    {
        return getWidth() * getHeight();
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + getWidth() +
                ", height=" + getHeight() +
                ", filled=" + isFilled() +
                ",area=" + area() +
                '}';
    }
}

public class Task2
{
    public static void main(String[] args)
    {
        Figure figure = new Figure(new Point2D(3,4),"Red");
        ClosedFigure closedFigure = new ClosedFigure(new Point2D(5,7),"Blue",10,30,true);
        Rectangle rectangle = new Rectangle(new Point2D(7,10),"yellow",false,new Point2D(10,3));

        System.out.println(figure.toString());
        System.out.println(closedFigure.toString());
        System.out.println(rectangle.toString());

        System.out.println(closedFigure.area());
        System.out.println(rectangle.area());

        Figure figures [] = new Figure [3];
        figures[0] = closedFigure;
        figures[1] = new ClosedFigure(new Point2D(10,3),"Blue",50,40,true);
        figures[2] = rectangle;

        for(int i = 0;i<figures.length;i++)
        {
            System.out.println(figures[i].toString());
            ClosedFigure newFigure = (ClosedFigure) figures[i];
            System.out.println(newFigure.area());
        }
    }
}
