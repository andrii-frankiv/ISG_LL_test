package phoneDirectory;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class User {
    String name;
    String password;
    Map<String, Integer> phoneList = new HashMap<String, Integer>();

    void createUser(String userName,String userPassword){
        name = userName;
        password = userPassword;
    }

    void addPhoneToList(String name,Integer number){
        System.out.println(name + "is added.");
        phoneList.put(name,number);
    }
    void getPhoneList(){
        for(Map.Entry<String, Integer> item : phoneList.entrySet()){

            System.out.println("Name: "+ item.getKey() + ";  number: " + item.getValue());
        }
    }
    void getPhoneByName(String name){
        System.out.println(name + "'s number: " + phoneList.get(name));
    }
    void removePhoneByName(String name){
        phoneList.remove(name);
        System.out.println(name + " is deleted");
    }
}
