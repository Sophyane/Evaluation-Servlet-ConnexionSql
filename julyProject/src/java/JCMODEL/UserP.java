/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JCMODEL;

/**
 *
 * @author oz
 */
public class UserP {
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String adress;
    private int telephone1;
    private int telephone2;
    private int idUser;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
    
     //Creating GETTERS 
    
    public String getFirstName() {
    return firstName;
    }
    
    //Creating SETTERS
    
    public String setFirstName(String firstname){
    this.firstName = firstname;
        return null;
        
        //Same here...
    }
    
    public String getLastName() {
    return lastName;
    }
    
    public String setLastName(String lastname){
    this.lastName = lastname;
        return null;
        
    }  
    
    public String getPassword() {
    return password;
    }
    
    public String setPassword (String password){
    this.password = password;
    return null;
    }
    
    public String getEmail() {
    return email;
    }
    
    public String setEmail(String email){
    this.email = email;
        return null;    
    }
    
    public String getAdress() {
    return adress;
    }
    
    public String setAdress(String adress){
    this.adress = adress;
        return null;
        
    }
    
    
    public int getTelephone1() {
    return telephone1;
    }
    
    public int setTelephone1(int telephone1){
    this.telephone1 = telephone1;
        return 0;  
    }
    
    
     public int getTelephone2() {
    return telephone2;
    }
     
     public int setTelephone2(int telephone2){
    this.telephone2 = telephone2;
    return 0;
    }
    
}
