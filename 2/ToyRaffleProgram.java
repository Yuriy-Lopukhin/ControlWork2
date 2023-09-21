import java.io.*;
import java.util.*;

public class ToyRaffleProgram {
    public static void main(String[] args) {
        ToyStore toyStore = new ToyStore();

        // Load toys from file
        try (Scanner scanner = new Scanner(new File("toys.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                int quantity = Integer.parseInt(parts[2]);
                double weight = Double.parseDouble(parts[3]);
                Toy toy = new Toy(id, name, quantity, weight);
                toyStore.addToy(toy);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        
        Toy winner = toyStore.getRandomToy();
        if (winner != null) {
            System.out.println("Congratulations! The winner is: " + winner.getName());
        } else {
            System.out.println("No toys available.");
        }

        
        toyStore.updateToyWeight(1, 20.0);

        
        try (PrintWriter writer = new PrintWriter(new File("toys.txt"))) {
            for (Toy toy : toyStore.getToys()) {
                writer.println(toy.getId() + "," + toy.getName() + "," + toy.getQuantity() + "," + toy.getWeight());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}