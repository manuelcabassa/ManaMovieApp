
package manamovieapp;

import java.sql.Date;
import java.time.LocalDate;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Manuel
 */
public class Customers {

    private SimpleStringProperty Id;
    private SimpleStringProperty firstName;
    private SimpleStringProperty middleName;
    private SimpleStringProperty lastName;
    private SimpleStringProperty adress;
    private LocalDate dateOfBirth;
    private SimpleStringProperty username;
    private SimpleStringProperty isAdmin;
    
        public Customers(String id, String firstName, String middleName, String lastName, String adress, LocalDate dateOfBirth, String username, String isAdmin) {
        this.Id = new SimpleStringProperty(id);
        this.firstName = new SimpleStringProperty(firstName);
        this.middleName = new SimpleStringProperty(middleName);
        this.lastName = new SimpleStringProperty(lastName);
        this.adress = new SimpleStringProperty(adress);
        this.dateOfBirth = dateOfBirth;
        this.username = new SimpleStringProperty(username);
        this.isAdmin = new SimpleStringProperty(isAdmin);
    }
        
    public String getId() {
        return Id.get();
    }

    public void setId(SimpleStringProperty id) {
        this.Id = id;
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(SimpleStringProperty firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName.get();
    }

    public void setMiddleName(SimpleStringProperty middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(SimpleStringProperty lasttName) {
        this.lastName = lasttName;
    }

    public String getAdress() {
        return adress.get();
    }

    public void setAdress(SimpleStringProperty adress) {
        this.adress = adress;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getUsername() {
        return username.get();
    }

    public void setUsername(SimpleStringProperty username) {
        this.username = username;
    }

    public String getIsAdmin() {
        return isAdmin.get();
    }

    public void setIsAdmin(SimpleStringProperty isAdmin) {
        this.isAdmin = isAdmin;
    }
    
}
