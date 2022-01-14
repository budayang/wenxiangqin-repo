package list;

public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return this.name;
    }
    @Override
    protected Person clone() throws CloneNotSupportedException {
        return (Person)super.clone();
    }
}
