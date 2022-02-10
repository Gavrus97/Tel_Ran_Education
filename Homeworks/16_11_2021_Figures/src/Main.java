import figures.Line;
import figures.Picture;
import figures.Rectangle;
import figures.Shape;

public class Main {

    public static void main(String[] args) {

        Shape line1 = new Line('x',5);
        Shape line2 = new Line('+',25);
        Shape rectangle = new Rectangle('-', 3,3);

        Shape picture1 = new Picture('1',new Shape[]{line1,rectangle});

        Shape[] picture2Shapes = new Shape[]{line2, picture1};
        Shape picture2 = new Picture('2',picture2Shapes);

        picture2.draw();

    }
}
