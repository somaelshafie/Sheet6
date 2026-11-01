public class Simple_GemoTraceObject {
    public static void main(String[] args){

        GeometricObject[] objects = {
                new Circle("Red", true, 3.0f),
                new Circle("Blue", false, 2.0f),
                new Rectangle("Green", true, 5.0f, 4.0f),
                new Square("Yellow", true, 5.0f)
        };

        for(int i=0; i<objects.length; i++){
            if(objects[i].getArea() > 20){
                System.out.println(objects[i]);
                System.out.println("Area: "+objects[i].getArea());
                System.out.println("Perimeter: "+objects[i].getPerimeter());
            }
        }
    }
}

abstract class GeometricObject{
    private String color;
    private boolean filled;

    GeometricObject(String color, boolean filled){
        this.color=color;
        this.filled=filled;
    }

    void setColor(String color){
        this.color=color;
    }

    String getColor(){
        return color;
    }

    void setFilled(boolean filled){
        this.filled=filled;
    }

    boolean getFilled(){
        return filled;
    }

    @Override
    public String toString(){
        return "color: "+color+" filled: "+filled;
    }

    abstract float getArea();
    abstract float getPerimeter();
}

class Circle extends GeometricObject{
    private float radius;

    Circle(String color, boolean filled, float radius){
        super(color, filled);
        this.radius=radius;
    }

    void setRadius(float radius){
        this.radius=radius;
    }

    float getRadius(){
        return radius;
    }

    @Override
    public String toString(){
        return super.toString()+" radius: "+radius;
    }

    @Override
    float getArea(){
        return 3.14f*radius*radius;
    }

    @Override
    float getPerimeter(){
        return 2.0f*3.14f*radius;
    }
}

class Rectangle extends GeometricObject{
    private float length;
    private float width;

    Rectangle(String color, boolean filled, float length, float width){
        super(color, filled);
        this.length=length;
        this.width=width;
    }

    void setLength(float length){
        this.length=length;
    }

    float getLength(){
        return length;
    }

    void setWidth(float width){
        this.width=width;
    }

    float getWidth(){
        return width;
    }

    @Override
    public String toString(){
        return super.toString()+" length: "+length+" width: "+width;
    }

    @Override
    float getArea(){
        return length*width;
    }

    @Override
    float getPerimeter(){
        return 2*(length+width);
    }
}

class Square extends Rectangle{

    Square(String color, boolean filled, float side){
        super(color, filled, side, side);
    }

    void setSide(float side){
        setLength(side);
        setWidth(side);
    }

    float getSide(){
        return getLength();
    }

    @Override
    public String toString(){
        return super.toString()+" side: "+getSide();
    }
}
