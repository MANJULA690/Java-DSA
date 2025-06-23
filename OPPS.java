public class OPPS {

    public static void main(String[] args) {
        // Pen p1 = new Pen();
        // p1.changeColor("blue");
        // p1.changeTip(5);
        // p1.getColor();
        // p1.getTip();

        // p1.changeColor("red");
        // p1.changeTip(10);
        // p1.getColor();
        // p1.getTip();
        // Student s1 = new Student();
        // s1.name = "manju";
        // s1.age = 19;
        // Student s2 = new Student(s1);
        // System.out.println(s1.name);
        // System.out.println(s1.age);
        Fish shark = new Fish();
        // shark.eat();
    }
}

class Animal {
    String color;

    Animal() {
        System.out.println("Animal constructor called");
    }

    void eat() {
        System.out.println("eats");
    }

    void breathe() {
        System.out.println("breaths");
    }
}

class Fish extends Animal {
    Fish() {
        System.out.println("fish constructor called");
    }

    int fins;

    void swim() {
        System.out.println("swims in water");
    }
}

class Pen {
    private String color;
    private int tip;

    // getters
    public String getColor() {
        return this.color;
    }

    public int getTip() {
        return this.tip;
    }

    // setters
    void changeColor(String newColor) {
        color = newColor;
    }

    void changeTip(int newTip) {
        tip = newTip;
    }
}

class Student {
    String name;
    int age;

    Student(Student s1) {
        this.name = s1.name;
        this.age = s1.age;
    }

    Student() {
        System.out.println("constructor is called...");
    }

    Student(String name) {
        this.name = name;
    }

    Student(int age) {
        this.age = age;
    }
}