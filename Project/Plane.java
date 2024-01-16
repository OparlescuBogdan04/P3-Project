import java.util.ArrayList;
import java.util.Collection;
import java.util.List;;

public class Plane implements Comparable<Plane> {
    private String planeId;
    private String model;
    private int capacity;
    private float topSpeed;
    private List<Passenger> passangers;

    public Plane(String planeId, String model, int capacity, float topSpeed, List<Passenger> passangers) {
        this(planeId, model, capacity, topSpeed);
        this.passangers = passangers;
    }

    public Plane(String planeId, String model, int capacity, float topSpeed) {
        this.planeId = planeId;
        this.model = model;
        this.capacity = capacity;
        this.topSpeed = topSpeed;
        this.passangers = new ArrayList<>();
    }

    void addPassenger(Passenger passenger) {
        if (passenger == null)
            throw new NullPointerException("Passengers list is null. {Plane: " + planeId + "}");
        passangers.add(passenger);
    }

    void addPaggangers(Collection<Passenger> passangers) {
        for (Passenger p : passangers)
            this.passangers.add(p);
    }


    float average_age() throws InterruptedException {
        if (passangers == null || passangers.isEmpty())
            return 0.0f;

        int numberOfPassengers = passangers.size();
        int halfway = numberOfPassengers / 2;

        AverageAgeCalculatorThread thread1 = new AverageAgeCalculatorThread(passangers.subList(0, halfway));
        AverageAgeCalculatorThread thread2 = new AverageAgeCalculatorThread(passangers.subList(halfway, numberOfPassengers));
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        float avgAgeFirstHalf = thread1.getAverageAge();
        float avgAgeSecondHalf = thread2.getAverageAge();
        return (avgAgeFirstHalf + avgAgeSecondHalf) / 2;
    }

    public String getPlaneId() {
        return planeId;
    }

    public String getModel() {
        return model;
    }

    public int getCapacity() {
        return capacity;
    }

    public float getTopSpeed() {
        return topSpeed;
    }

    public List<Passenger> getPassangers() {
        return passangers;
    }

    public void setPlaneId(String planeId) {
        this.planeId = planeId;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setTopSpeed(float topSpeed) {
        this.topSpeed = topSpeed;
    }

    public void setPassangers(List<Passenger> passangers) {
        this.passangers = passangers;
    }

    public String toString() {
        return "Plane: " + planeId + ", model=" + model + "\n Listing passangers...\n" + passangers.toString()
                + "\n......................";
    }

    public int compareTo(Plane plane) {
        if (topSpeed < plane.topSpeed)
            return -1;
        if (topSpeed > plane.topSpeed)
            return 1;
        return 0;
    }
}

class AverageAgeCalculatorThread extends Thread {
    private List<Passenger> passengers;
    private float averageAge;

    public AverageAgeCalculatorThread(List<Passenger> passengers) {
        this.passengers = passengers;
        this.averageAge = 0.0f;
    }

    @Override
    public void run() {
        if (passengers == null || passengers.isEmpty()) {
            return;
        }

        int totalAge = 0;
        for (Passenger passenger : passengers) {
            totalAge += passenger.getAge();
        }

        averageAge = (float) totalAge / passengers.size();
    }

    public float getAverageAge() {
        return averageAge;
    }
}