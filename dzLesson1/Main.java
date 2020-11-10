package dzLesson1;

import dzLesson1.band.Band;
import dzLesson1.band.Cat;
import dzLesson1.band.Human;
import dzLesson1.band.Robot;
import dzLesson1.obstacles.Obstacles;
import dzLesson1.obstacles.Treadmill;
import dzLesson1.obstacles.Wall;

public class Main {
    public static void main (String[] args) {
        Band[] bands = {
                new Cat("Timon", 700, 2),
                new Human("Anton"),
                new Robot("Platon", 300, 1),
                new Human("Petrov", 400, 4)
        };

        Obstacles[] obstacles = {
                new Treadmill(500),
                new Wall(1)
        };

        for (Band b : bands) {
            for (Obstacles o : obstacles) {
                o.doIt(b);
                if (!b.isOnPassage()) {
                    break;
                }
            }
        }

        for (Band band : bands) {
            band.info();
        }

    }
}

