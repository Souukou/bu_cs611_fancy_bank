package fancybank.user;

public abstract class User {
    private UID UID;
    private Name name;
    private Address address;
    private Email email;
    private Password password;

    public User() {
        this.UID = new UID();
        this.name = new Name();
        this.address = new Address();
        this.email = new Email();
    }

    public User(UID UID, Name name, Address address, Email email, Password password) {
        this.UID = UID;
        this.name = name;
        this.address = address;
        this.email = email;
    }

    public User(int uid, String firstName, String middleName, String lastName, String street, String city, String state, String zip, String country, String email, Password password) {
        this.UID = new UID(uid);
        this.name = new Name(firstName, middleName, lastName);
        this.address = new Address(street, city, state, zip, country);
        this.email = new Email(email);
    }

    public UID getUID() {
        return UID;
    }

    public void setUID(UID UID) {
        this.UID = UID;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Password getPassword() {
        return password;
    }

    public void setPassword(Password password) {
        this.password = password;
    }

    public String toString() {
        return "UID: " + UID + " Name: " + name + " Address: " + address + " Email: " + email;
    }

}
