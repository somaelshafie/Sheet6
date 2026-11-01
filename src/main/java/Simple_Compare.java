public class Simple_Compare {
    public static void main(String[] args){

        GeometricObject[] arr = {
                new Circle("Red", true, 5.0f),
                new Rectangle("Blue", true, 4.0f, 3.0f),
                new Circle("Green", false, 2.0f)
        };

        ComparableSorting.sort(arr);

        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
            System.out.println(arr[i].getArea());
        }
    }
}

class ComparableSorting{

    static void sort(GeometricObject[] arr){

        for(int i=0; i<arr.length-1; i++){
            for(int j=0; j<arr.length-1-i; j++){

                if(arr[j].compareTo(arr[j+1]) > 0){
                    GeometricObject temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
}

abstract class GeometricObject implements Comparable<GeometricObject>{
    private String color;
    private boolean filled;

    GeometricObject(String color, boolean filled){
        this.color=color;
        this.filled=filled;
    }

    abstract float getArea();
    abstract float getPerimeter();

    @Override
    public int compareTo(GeometricObject obj){

        if(getArea() > obj.getArea())
            return 1;
        else if(getArea() < obj.getArea())
            return -1;
        else
            return 0;
    }

    @Override
    public String toString(){
        return "color: "+color+" filled: "+filled;
    }
}

class Circle extends GeometricObject{
    private float radius;

    Circle(String color, boolean filled, float radius){
        super(color, filled);
        this.radius=radius;
    }

    @Override
    float getArea(){
        return 3.14f*radius*radius;
    }

    @Override
    float getPerimeter(){
        return 2*3.14f*radius;
    }

    @Override
    public String toString(){
        return super.toString()+" radius: "+radius;
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

    @Override
    float getArea(){
        return length*width;
    }

    @Override
    float getPerimeter(){
        return 2*(length+width);
    }

    @Override
    public String toString(){
        return super.toString()+" length: "+length+" width: "+width;
    }
}