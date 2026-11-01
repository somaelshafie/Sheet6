
public class Simple_Movable {
    public static void main(String[] args){

        Movable m = new MovablePoint(2.0f, 3.0f, 1.0f, 2.0f);

        System.out.println(m);

        m.moveRight();
        m.moveDown();

        System.out.println(m);

        m.moveLeft();
        m.moveUp();

        System.out.println(m);
    }
}

interface Movable{
    void moveRight();
    void moveDown();
    void moveLeft();
    void moveUp();
}

class MovablePoint implements Movable{
    private float x;
    private float y;
    private float xAmount;
    private float yAmount;

    MovablePoint(float x, float y, float xAmount, float yAmount){
        this.x=x;
        this.y=y;
        this.xAmount=xAmount;
        this.yAmount=yAmount;
    }

    @Override
    public void moveRight(){
        x=x+xAmount;
    }

    @Override
    public void moveDown(){
        y=y+yAmount;
    }

    @Override
    public void moveLeft(){
        x=x-xAmount;
    }

    @Override
    public void moveUp(){
        y=y-yAmount;
    }

    @Override
    public String toString(){
        return "("+x+", "+y+") Amount=("+xAmount+", "+yAmount+")";
    }
}