package models;

public class Producer {
    private String fursName;
    private String lastName;

    public Producer(String fursName, String lastName) {
        this.fursName = fursName;
        this.lastName = lastName;
    }

    public String getFursName() {
        return fursName;
    }

    public void setFursName(String fursName) {
        this.fursName = fursName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "models.Producer{" +
                "fursName='" + fursName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
