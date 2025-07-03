package assistedProblems;


class Animal {
    String name;
    int age;

    Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    void makeSound() {
        System.out.println("Some generic animal sound");
    }
}

class Dog extends Animal {
    Dog(String name, int age) {
        super(name, age);
    }

    @Override
    void makeSound() {
        System.out.println(name + " says: Woof!");
    }
}
class Cat extends Animal {
    Cat(String name, int age) {
        super(name, age);
    }

    @Override
    void makeSound() {
        System.out.println(name + " says: Meow!");
    }
}

class Bird extends Animal {
    Bird(String name, int age) {
        super(name, age);
    }
    @Override
    void makeSound() {
        System.out.println(name + " says: Tweet!");
    }
}

public class AnimalHierarchyTest {
    public static void main(String[] args) {

        Animal dog = new Dog("Buddy", 3);
        Animal cat = new Cat("Whiskers", 2);
        Animal bird = new Bird("Tweety", 1);

        Animal[] animals = {dog, cat, bird};
        for (Animal a : animals) {
            a.makeSound();
        }
    }
}

