/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Users;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

/**
 *
 * @author group-11
 */
public class UserCat {
    
    private ArrayList<User> userCat;
    
    public UserCat(){
        userCat = new ArrayList<>();
    }

    public ArrayList<User> getUserCat() {
        return userCat;
    }

    public void setUserCat(ArrayList<User> userCat) {
        this.userCat = userCat;
    }
    
    public User addUser(){
        User user = new User();
        userCat.add(user);
        return user;
    }
    public void deleteUser(User u){
        userCat.remove(u);
    }

    public User getUserDetails(String userName, String hash) {
        User user = new User();
        for(User k : userCat){
            if(userName.compareTo(k.getUserName()) == 0 && hash.compareTo(k.getPassword())==0){
                user =k;
                System.out.println("User Found");
                break;
            }
            
        }
        return user;
    }

    public User getUserfromId(int search) {
        User result = new User();
        for(User k : userCat){
             if(k.getUserId()==search)
                result=k;
        }    
        return result;
    }
    public String get_SHA_512_SecurePassword(String passwordToHash, String   salt) throws UnsupportedEncodingException{
        String generatedPassword = null;
        try {
             MessageDigest md = MessageDigest.getInstance("SHA-512");
             md.update(salt.getBytes("UTF-8"));
             byte[] bytes = md.digest(passwordToHash.getBytes("UTF-8"));
             StringBuilder sb = new StringBuilder();
             for(int i=0; i< bytes.length ;i++){
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
             }
             generatedPassword = sb.toString();
            } 
           catch (NoSuchAlgorithmException e){
            e.printStackTrace();
           }
        return generatedPassword;
    }
}
