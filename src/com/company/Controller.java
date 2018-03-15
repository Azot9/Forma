package com.company;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.Date;

public class Controller {
    private Model model;
  private    View view;

     Controller (Model model, View view){
         this.model = model;
         this.view = view;

         model.setName(namesControle(View.NAME));
         model.setSurname(namesControle(View.SURNAME));
         model.setPatronimic(namesControle(View.PATRONYMIC));

         model.setNsp(model.getName() + model.getSurname() + model.getPatronimic());

         model.setNickname(namesControle(View.NICKNAME));
         model.setCommennt(withoutControle(View.COMMENT));
         model.setSkype(namesControle(View.SKYPE));
         model.setSurname(namesControle(View.GROUPS));
         model.setMobileNumber1(numbersControle(View.MOBILE_NUMBER1));
         model.setMobileNumber2(numbersControle(view.MOBILE_NUMBER2));
         model.setHomeNumber(numbersControle(view.HOME_NUMBER));
         //model.setEmail(emailControle(view.EMAIL));
         model.setAddress(addressControle(view.ADDRESS));
         model.setGroup(groupControle(view.GROUPS));

         Date date = new Date();
         model.setDate(date.toString());

         view.showAll(model.getNsp(), model.getAddress());

     }

     public String namesControle(String message){
         Scanner in = new Scanner(System.in);
         System.out.println(view.WRITING_DATA + message + " ");
         String temp = in.nextLine();
         boolean isFound1 = Pattern.matches("[A-Z][a-z]*", temp);
            if (isFound1){
             System.out.println("Good");
             return temp;
            }
            else {
                System.out.println(View.WRONG_INPUT_INT_DATA);
             return this.namesControle(message);
            }
     }

    public String numbersControle(String message) {
        Scanner in = new Scanner(System.in);
        System.out.println(View.WRITING_DATA + message + " ");
        String temp = in.nextLine();
        boolean isFound1 = Pattern.matches("[0-9]+", temp);
        if (isFound1) {
            System.out.println("Good");
            return temp;
        } else {
            System.out.println(View.WRONG_INPUT_INT_DATA);
           return this.numbersControle(message);
        }
    }

    public String emailControle(String message) {
        Scanner in = new Scanner(System.in);
        System.out.println(View.WRITING_DATA + message + " ");
        String temp = in.nextLine();
        boolean isFound1 = Pattern.matches("^(\\w|[-\\.!#$%&*+?/{}~]){2,20}@[a-z]{1,10}\\.[a-z]{1,5}$", temp);
        if (isFound1) {
            System.out.println("Good");
            return temp;
        } else {
            System.out.println(View.WRONG_INPUT_INT_DATA);
            return this.numbersControle(message);
        }
    }

    public String withoutControle(String message) {
        Scanner in = new Scanner(System.in);
        System.out.println(View.WRITING_DATA + message + " ");
        String temp = in.nextLine();
            System.out.println("Good");
            return temp;
    }

    public String addressControle(String message){
        Address address = new Address();
        System.out.println(View.WRITING_DATA + message + " ");
        address.index =  numbersControle(View.INDEX);
        address.city =  namesControle(View.CITY);
        address.street =  namesControle(View.STREET);
        address.house_number =  numbersControle(View.HOUSE_NUMBER);
        address.flat_number =  numbersControle(View.FLAT_NUMBER);
        return View.INDEX + address.index + View.CITY + address.city + View.STREET + address.street +
                View.HOUSE_NUMBER + address.house_number + View.FLAT_NUMBER + address.flat_number  ;
    }


    public String groupControle(String message) {
        Scanner in = new Scanner(System.in);
        Group grou = Group.GROUP1;
        System.out.println(View.CHOOSING_DATA + message + ": " + grou.GROUP1 + " or " + grou.GROUP2 + " or " + grou.GROUP3);
        int temp = in.nextInt();
        System.out.println("Good");
        if (temp==1) return "GROUP1";
            else if (temp==2) return "GROUP2";
               else  if (temp==3) return "GROUP3";
        else return groupControle( message);
    }

}
