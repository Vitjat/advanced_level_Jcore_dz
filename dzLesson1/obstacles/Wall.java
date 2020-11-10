package dzLesson1.obstacles;

import dzLesson1.band.Band;

public class Wall implements Obstacles {
    private int height;

    public Wall (int height) {
        this.height = height;
    }

    @Override
    public void doIt(Band b) {
        b.jump(height);
    }
}
