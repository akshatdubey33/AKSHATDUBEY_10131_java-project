class Consumer {
    private int id;
    private String name;
    private int unitsConsumed;

    // Constructor
    public Consumer(int id, String name, int unitsConsumed) {
        this.id = id;
        this.name = name;
        this.unitsConsumed = unitsConsumed;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getUnitsConsumed() {
        return unitsConsumed;
    }
}

class TariffCalculator {

    public double generateBill(Consumer consumer) {
        int units = consumer.getUnitsConsumed();
        double bill = 0;

        // Slab-based pricing
        if (units <= 100) {
            bill = units * 1.5;
        } 
        else if (units <= 200) {
            bill = (100 * 1.5) + (units - 100) * 2.5;
        } 
        else if (units <= 300) {
            bill = (100 * 1.5) + (100 * 2.5) + (units - 200) * 4.0;
        } 
        else {
            bill = (100 * 1.5) + (100 * 2.5) + (100 * 4.0) + (units - 300) * 6.0;
        }

        // Optional fixed charge
        double fixedCharge = 50;
        bill += fixedCharge;

        return bill;
    }
}

public class Main {
    public static void main(String[] args) {

        // Create Consumer object
        Consumer consumer = new Consumer(101, "Rahul", 250);

        // Create TariffCalculator object
        TariffCalculator calculator = new TariffCalculator();

        // Generate Bill
        double totalBill = calculator.generateBill(consumer);

        // Display generated bill
        System.out.println("===== Electricity Bill =====");
        System.out.println("Consumer ID: " + consumer.getId());
        System.out.println("Name: " + consumer.getName());
        System.out.println("Units Consumed: " + consumer.getUnitsConsumed());
        System.out.println("Total Electricity Bill:" + totalBill);
    }
}
