public class Robot {

    private  int x=0;
    private  int y=0;
    private Direction dir=Direction.UP;

    public Robot (int x,int y,Direction dir){
        this.x=x;
        this.y=y;
        this.dir=dir;
    }

    public Robot (int x,int y){
        this.x=x;
        this.y=y;
        //this.dir=Direction.UP;
    }

    public Robot (Direction dir){
        //this.x=0;
        //this.y=0;
        this.dir=dir;
    }

    public Robot (){
        //this.x=0;
        //this.y=0;
        //this.dir=Direction.UP;
    }

    public Direction getDirection() {
        // текущее направление взгляда
        return  dir;
    }

    public int getX() {
        // текущая координата
        return x;
    }

    public int getY() {
        // текущая координата Y
        return y;
    }

    public void turnLeft() {
        // повернуться на 90 градусов против часовой стрелки
        System.out.println("Поворот против часовой стрелки");
        if (dir == Direction.DOWN){
            System.out.println("Вниз -> вправо");
            this.dir = Direction.RIGHT;
            return;
        }

        if (dir == Direction.UP){
            System.out.println("Вверх -> влево");
            this.dir = Direction.LEFT;
            return;
        }

        if (dir == Direction.LEFT){
            System.out.println("Влево -> вниз");
            this.dir = Direction.DOWN;
            return;
        }

        if (dir == Direction.RIGHT){
            System.out.println("Вправо -> вверх");
            this.dir = Direction.UP;
            return;
        }
    }

    public void turnRight() {
        // повернуться на 90 градусов по часовой стрелке
        System.out.println("поворот по часовой стрелке");
        if (this.dir == Direction.DOWN){
            System.out.println("Вниз -> влево");
            this.dir = Direction.LEFT;
            return;
        }

        if (this.dir == Direction.UP){
            System.out.println("Вверх -> вправо");
            this.dir = Direction.RIGHT;
            return;
        }

        if (this.dir == Direction.LEFT){
            System.out.println("Влево -> вверх");
            this.dir = Direction.UP;
            return;
        }

        if (this.dir == Direction.RIGHT){
            System.out.println("Вправо -> вниз");
            this.dir = Direction.DOWN;
            return;
        }
    }

    public void stepForward() {
        // шаг в направлении взгляда
        // за один шаг робот изменяет одну свою координату на единицу
        System.out.println("движение");
        if (dir == Direction.DOWN){
            System.out.println("вниз");
            this.y--;
        }

        if (dir == Direction.UP){
            System.out.println("вверх");
            this.y++;
        }

        if (dir == Direction.LEFT){
            System.out.println("налево");
            this.x--;
        }

        if (dir == Direction.RIGHT){
            System.out.println("направо");
            this.x++;
        }

        /*@Override
        public String toString(){
            return "X="+this.x+"Y="+this.y+"Direction="+this.dir;
        }*/
    }
}
