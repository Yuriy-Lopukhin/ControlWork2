
import java.util.ArrayList;
import java.util.List;

class ToyStore {
    private List<Toy> toys;

    public ToyStore() {
        toys = new ArrayList<>();
    }

    public void addToy(Toy toy) {
        toys.add(toy);
    }

    public void updateToyWeight(int id, double weight) {
        for (Toy toy : toys) {
            if (toy.getId() == id) {
                toy.setWeight(weight);
                break;
            }
        }
    }

    public Toy getRandomToy() {
        double totalWeight = 0;
        for (Toy toy : toys) {
            totalWeight += toy.getWeight();
        }

        double random = Math.random() * totalWeight;

        for (Toy toy : toys) {
            random -= toy.getWeight();
            if (random <= 0) {
                return toy;
            }
        }

        return null;
    }

    public List<Toy> getToys() {
        return toys;
    }
}
