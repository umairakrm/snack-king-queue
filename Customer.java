public class Customer {
    private String firstName;
    private String secondName;
    private int id;
    private int pizzaRequired;

    public Customer(String firstName, String secondName, int id, int pizzaRequired) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.id = id;
        this.pizzaRequired = pizzaRequired;
    }

    public Customer() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPizzaRequired() {
        return pizzaRequired;
    }

    public void setPizzaRequired(int pizzaRequired) {
        this.pizzaRequired = pizzaRequired;
    }

    public String getFullName() {
        return firstName+" "+secondName;
    }
}
