import java.util.LinkedList;

/**
 * Created by Hakim on 9/23/15.
 */

/**
 * Define an Animal.
 */
class Animal{
    String name;
    int adoptionTime;

    public Animal(String n){
        name = n;
    }
}

/**
 * Define a Dog.
 */
class Dog extends Animal{
    public Dog(String n){
        super(n);
    }
}

/**
 * Define a Cat.
 */
class Cat extends Animal{
    public Cat(String n){
        super(n);
    }
}

/**
 * Data structure to keep track of the Cats and Dogs arriving at the Shelter.
 * Update a time stamp to keep track of the Animal's arrival.
 * Store Dogs and Cats in separate LinkedLists.
 * When Enqueuing a new Animal, enqueue it in the corresponding linked list.
 * If dequeuing any animal, compare the oldest of the two linked lists and return the oldest of the two.
 */
class AnimalQueue{
    LinkedList<Dog> dogQueue = new LinkedList<>();
    LinkedList<Cat> catQueue = new LinkedList<>();
    int adoptionTime = 0;

    public void enqueue(Animal animal){
        animal.adoptionTime = adoptionTime;
        if (animal.getClass() == Dog.class){
            dogQueue.add((Dog)animal);
        }
        if (animal.getClass() == Cat.class){
            catQueue.add((Cat)animal);
        }
        adoptionTime++;
    }

    public Animal dequeueAny(){
        if (dogQueue.isEmpty() && catQueue.isEmpty()){
            return null;
        }
        if (dogQueue.isEmpty()){
            return catQueue.remove();
        }
        if (catQueue.isEmpty()){
            return dogQueue.remove();
        }

        int oldestDog = dogQueue.peek().adoptionTime;
        int oldestCat = catQueue.peek().adoptionTime;

        if (oldestCat < oldestDog){
            return catQueue.remove();
        }
        else{
            return dogQueue.remove();
        }
    }

    public Dog dequeueDog(){
        if (dogQueue.isEmpty()){
            return null;
        }
        return dogQueue.remove();
    }

    public Cat dequeueCat(){
        if (catQueue.isEmpty()){
            return null;
        }
        return catQueue.remove();
    }
}
public class Solution06 {
    public static void main(String[] args){
        AnimalQueue queue = new AnimalQueue();
        Dog dog1 = new Dog("dog1");
        Dog dog2 = new Dog("dog2");
        Dog dog3 = new Dog("dog3");

        Cat cat1 = new Cat("cat1");
        Cat cat2 = new Cat("cat2");
        Cat cat3 = new Cat("cat3");

        queue.enqueue(dog1);
        queue.enqueue(cat1);
        queue.enqueue(dog2);
        queue.enqueue(cat2);
        queue.enqueue(dog3);
        queue.enqueue(cat3);

        System.out.println("dequeueAny should return Dog1: " + queue.dequeueAny().name);
        System.out.println("dequeueDog should return Dog2: " + queue.dequeueDog().name);
        System.out.println("dequeueAny should return Cat1: " + queue.dequeueAny().name);
        System.out.println("dequeueCat should return Cat2: " + queue.dequeueCat().name);
        System.out.println("dequeueCat should return Cat3: " + queue.dequeueCat().name);
    }
}
