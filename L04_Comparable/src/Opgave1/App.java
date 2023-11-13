package Opgave1;

public class App {

    public static void main(String[] args) {
        Mesureble[] objects = new Mesureble[4];
        objects[0] = new Chili("Habanero", 2000000);
        objects[1] = new Chili("Jalapeno", 2500);
        objects[2] = new Chili("Poblano", 150000);
        objects[3] = new Chili("Ghost", 1400000);

        System.out.println("Max: " + max(objects).getMeasure());
        System.out.println("Avg: " + avg(objects));

    }

    public static Mesureble max(Mesureble[] objects) {
        Mesureble max = objects[0];
        for (Mesureble object : objects) {
            if (object.getMeasure() > max.getMeasure()) {
                max = object;
            }
        }
        return max;
    }

    public static double avg(Mesureble[] objects) {
        double sum = 0;
        for (Mesureble object : objects) {
            sum += object.getMeasure();
        }
        return sum / objects.length;
    }
}
