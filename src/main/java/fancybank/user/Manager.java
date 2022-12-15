package fancybank.user;

/**
 * @author Haodong Chen hjc5283@bu.edu
 *         Class for bank manager.
 */
public class Manager extends User {

    public Manager() {
        super();
    }

    public Manager(UID UID, Username username, Name name, Address address, Email email, Password password) {
        super(UID, username, name, address, email, password);
    }

}
