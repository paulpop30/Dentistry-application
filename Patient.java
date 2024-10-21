package domain;


public class Patient implements Identifiable<Long> {

    private Long id;
    private String name;
    private String phoneNumber;
    private String email;

    public Patient(Long id, String name, String phoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    @Override
    public Long getId() {
        return id;
    }
    @Override
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
