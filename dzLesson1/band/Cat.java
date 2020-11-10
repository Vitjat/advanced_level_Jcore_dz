package dzLesson1.band;

public class Cat implements Band {
    private String name;
    private int maxDistance;
    private int maxHeight;
    private boolean onPassage;

    public Cat(String name, int maxDistance, int maxHeight) {
        this.name = name;
        this.maxDistance = maxDistance;
        this.maxHeight = maxHeight;
        this.onPassage = true;
    }

    public Cat(String name) {
        this(name,700,1);
    }

    @Override
    public void run(int distance) {
        if (distance <= maxDistance) {
            System.out.printf("%s пробежал %d  метров\n",  name, distance);
        } else {
            System.out.printf("%s не пробежал %d  метров\n", name, distance);
            onPassage = false;
        }
    }

    @Override
    public void jump(int height) {
        if (height <= maxHeight) {
            System.out.printf("%s прыгнул %d  метров\n", name, maxHeight);
        } else {
            System.out.printf("%s не прыгнул %d  метр\n", name, maxHeight);
            onPassage = false;
        }
    }

    @Override
    public boolean isOnPassage() {
        return onPassage;
    }

    @Override
    public void info() {
        System.out.printf("%s %b\n", name, onPassage);
    }
}
