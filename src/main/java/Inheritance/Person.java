package Inheritance;

public class Person {
    private String firstName, lastName;
    private int age;
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = (age < 0 || age > 100) ? 0 : age;
    }
    public boolean isTeen() {
        return this.age > 12 && this.age < 20;
    }
    public String getFullName() {
        if (this.firstName.isEmpty() && this.lastName.isEmpty()) {
            return "";
        } else if (this.firstName.isEmpty() || this.lastName.isEmpty()) {
            return this.firstName.isEmpty() ? this.lastName : this.firstName;
        } else {
            return this.firstName + " " + this.lastName;
        }
    }
}
