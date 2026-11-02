public class Box {
    int width;
    int height;
    int depth;

    Box(int width , int height, int depth){
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public int volume(){
        return width*height*depth;
    }

    public void setWidth(int width){
        this.width = width;
    }
}

class BoxDemo{
    public static void main(String[] args) {
        Box box = new Box(20 , 30, 40);
        box.setWidth(30);
        System.out.println(box.volume());
    }
}
