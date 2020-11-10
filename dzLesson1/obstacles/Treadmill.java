package dzLesson1.obstacles;

import dzLesson1.band.Band;

public class Treadmill implements Obstacles {
    private int distance;

    public Treadmill (int distance) {
        this.distance = distance;
    }

    @Override
    public void doIt(Band b) {
        b.run(distance);
    }
}
