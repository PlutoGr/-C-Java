public class moveRobot {
    public static void MoveRobot(Robot robot, int toX, int toY) {

        while (robot.getDirection()!=Direction.UP){
            robot.turnLeft();
        }

        if (toX>robot.getX()) {
            robot.turnRight();
            for (int i=robot.getX();i<toX;i++)
                robot.stepForward();
        }
        if (toX<robot.getX()) {
            robot.turnLeft();
            for (int i=robot.getX();i>toX;i--)
                robot.stepForward();
        }

        if (toY>robot.getY()) {
            if (robot.getDirection()==Direction.RIGHT) robot.turnLeft();
            if (robot.getDirection()==Direction.LEFT) robot.turnRight();
            for (int i=robot.getY();i<toY;i++)
                robot.stepForward();
        }
        if (toY<robot.getY()) {
            if (robot.getDirection()==Direction.RIGHT) robot.turnRight();
            if (robot.getDirection()==Direction.LEFT) robot.turnLeft();
            for (int i=robot.getY();i>toY;i--)
                robot.stepForward();
        }
        System.out.println("X="+robot.getX()+" ;Y="+robot.getY());
    }
}
