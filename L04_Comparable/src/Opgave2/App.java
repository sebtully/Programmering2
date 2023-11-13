package Opgave2;

public class App {
    public static void main(String[] args) {
        Customer[] customers = new Customer[3];
        customers[0] = new Customer("Hans", "Hansen", 20);
        customers[1] = new Customer("Peter", "Hendersen", 30);
        customers[2] = new Customer("Jens", "Haderslev", 40);

        System.out.println("First: " + firstCustomer(customers).getEfternavn());
        System.out.println("After: " + afterCustomer(customers).getEfternavn());
        System.out.println("Last: " + lastCustomer(customers).getEfternavn());

    }

    public static Customer firstCustomer(Customer[] customers) {
        Customer first = customers[0];
        for (Customer customer : customers) {
            if (customer.compareTo(first) < 0) {
                first = customer;
            }
        }
        return first;
    }

    public static Customer lastCustomer(Customer[] customers) {
        Customer last = customers[0];
        for (Customer customer : customers) {
            if (customer.compareTo(last) > 0) {
                last = customer;
            }
        }
        return last;
    }

    public static Customer afterCustomer(Customer[] customers) {
        Customer after = customers[0];
        for (Customer customer : customers) {
            if (customer.compareTo(after) < 0) {
                after = customer;
            }
        }
        return after;
    }


}
