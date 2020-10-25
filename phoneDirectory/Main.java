package phoneDirectory;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Map<Integer, User> userMap = new HashMap<Integer, User>();

    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int k = -1;//user

        while (true) {
            System.out.println("Select action: ");
            System.out.println(1 + ". Create user." + "\n" + 2 + ". Sign In" + "\n" + 0 + ". Exit");
            Scanner in = new Scanner(System.in);
            String userInput = in.next();

            if (userInput.equals("1")) {
                createNewUser(k);
                k++;
                System.out.println("Select option: ");

                while (true) {
                    System.out.println(1 + ". Add contact." + "\n" + 2 + ". Get phone list" + "\n" + 3 + ". Find contact by name" + "\n" + 4 + ". Remove contact" + "\n" + 0 + ". Log Out");
                    userInput = in.next();
                    if (userInput.equals("1")) {
                        addPhone(k);
                    } else if (userInput.equals("2")) {
                        userMap.get(k).getPhoneList();
                    } else if (userInput.equals("3")) {
                        System.out.println("print name whom phone you want to find");
                        userInput = in.next();
                        userMap.get(k).getPhoneByName(userInput);
                    } else if (userInput.equals("4")) {
                        System.out.println("print name of contact you want to remove");
                        userInput = in.next();
                        userMap.get(k).removePhoneByName(userInput);
                    } else if (userInput.equals("0")) {
                        break;
                    } else {
                        System.out.println("Try again");
                    }
                }

            } else if (userInput.equals("2")) {
                if (signIn(k)) {
                    System.out.println("yeah");
                    System.out.println("Select option: ");

                    while (true) {
                        System.out.println(1 + ". Add contact." + "\n" + 2 + ". Get phone list" + "\n" + 3 + ". Find contact by name" + "\n" + 4 + ". Remove contact" + "\n" + 0 + ". Log Out");
                        userInput = in.next();
                        if (userInput.equals("1")) {
                            addPhone(k);
                        } else if (userInput.equals("2")) {
                            userMap.get(k).getPhoneList();
                        } else if (userInput.equals("3")) {
                            System.out.println("print name whom phone you want to find");
                            userInput = in.next();
                            userMap.get(k).getPhoneByName(userInput);
                        } else if (userInput.equals("4")) {
                            System.out.println("print name of contact you want to remove");
                            userInput = in.next();
                            userMap.get(k).removePhoneByName(userInput);
                        } else if (userInput.equals("0")) {
                            break;
                        } else {
                            System.out.println("Try again");
                        }
                    }
                } else {
                    System.out.println("shit, here we go again");
                }
            } else if (userInput.equals("0")) {
                break;
            } else {
                System.out.println("Try again");
            }

        }
    }

    static int createNewUser(int k) {
        k++;
        System.out.println("input username and password: ");
        Scanner in = new Scanner(System.in);
        String username = in.next();
        String password = in.next();
        User u = new User();
        u.name = username;
        u.password = password;
        userMap.put(k, u);
        return k;
    }

    static void addPhone(int k) {
        System.out.println("input name and number which you want to add: ");
        Scanner in = new Scanner(System.in);
        String name = in.next();
        int number = Integer.parseInt(in.next());
        userMap.get(k).addPhoneToList(name, number);
    }

    static boolean signIn(int k) {
        System.out.println("Print name and password: ");
        Scanner in = new Scanner(System.in);
        String username = in.next();
        String password = in.next();
        for (int i = 0; i < k + 1; i ++) {
            if ( userMap.get(i).name.equals(username)&& userMap.get(i).password.equals(password) ){
                return true;
            }
        }

        return false;
    }
}
