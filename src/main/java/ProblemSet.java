/**

        * File: Problem Set Unit 3 
        * Author: Alfred Yang
        * Date Created: March 30, 2026
        * Date Last Modified: April ????????????????????????????, 2026
        */
import java.util.Scanner;
public class ProblemSet {


	public static void main(String args[]){
                Scanner input = new Scanner(System.in);
                String emailAddress;        
                String firstEmailAddress;
                String secondEmailAddress;                                                                 ;
                String firstEmailValidationMessage;
                String secondEmailValidationMessage;
                String local;
                String domain;
                Boolean secondEmailAddressExist = false;

                //checking how many emails there are
                System.out.print("Input two emails: ");
                emailAddress = input.nextLine();
                if (!(emailAddress.contains(", "))){
                        firstEmailAddress = emailAddress;
                        secondEmailAddress = null;
                        secondEmailValidationMessage = null;
                }
                else { 
                        secondEmailAddressExist = true;
                        secondEmailAddress = emailAddress.substring(emailAddress.indexOf(", ")+2);
                        firstEmailAddress = emailAddress.substring(0, emailAddress.indexOf(", "));
                }
                
                firstEmailValidationMessage = confirmingEmail(firstEmailAddress);
                if (firstEmailValidationMessage.startsWith("Valid")){
                        local = firstEmailAddress.substring(0, firstEmailAddress.indexOf("@"));
                        domain = firstEmailAddress.substring(firstEmailAddress.indexOf("@")+1);
                        System.out.println(firstEmailAddress + ": " + firstEmailValidationMessage + " | Local: " + local + " | Domain: " + domain);
                }
                else{
                        System.out.println(firstEmailAddress + ": Invalid: " + firstEmailValidationMessage);
                }
                
                if (!(secondEmailAddressExist)){
                        return;
                }
                
                secondEmailValidationMessage = confirmingEmail(secondEmailAddress);
                if (secondEmailValidationMessage.startsWith("Valid")){
                        local = secondEmailAddress.substring(0, secondEmailAddress.indexOf("@"));
                        domain = secondEmailAddress.substring(secondEmailAddress.indexOf("@")+1);
                        System.out.println(secondEmailAddress + ": " + secondEmailValidationMessage + " | Local: " + local + " | Domain: " + domain);
                }
                else{
                        System.out.println(secondEmailAddress + ": Invalid: " + secondEmailValidationMessage);
                }
        }
        public static String confirmingEmail(String EmailAddress){
                String domain;
                String username;
                String domainSuffix;
                int locationOfAtSymbol;
                int locationOfDotInDomain;

                if (!(EmailAddress.contains("@"))){
                        return "Missing @";
                }
                else if (!(EmailAddress.contains("."))){
                        return "Missing .";
                }

                locationOfAtSymbol = EmailAddress.indexOf("@");
                domain = EmailAddress.substring(locationOfAtSymbol+1);
                username = EmailAddress.substring(0, locationOfAtSymbol);

                if (!(domain.contains("."))){
                        return "No dot in domain";
                }
                locationOfDotInDomain = domain.indexOf(".");
                domainSuffix = domain.substring(locationOfDotInDomain+1);

                if (domain.contains("@") && username.contains("@")){
                        return "Multiple @";
                }
                else if (EmailAddress.startsWith(".") && EmailAddress.endsWith(".")){
                        return "Starts or ends with dot";
                }
                else if (EmailAddress.contains(" ")){
                        return "Contains spaces";
                }
                else if (username.length() < 1){
                        return "Local part too short";
                }
                else if (username.length() > 64){
                        return "Local part too long";
                }
                else if (domainSuffix.length() < 2 || domainSuffix.length() > 6){
                        return "Invalid domain extension length";
                }
                else if (domain.contains("+") || domain.contains("_")){
                        return "+ or _ in non local area";
                }
                else if (username.contains(".")){
                        return "Valid (Gmail normalized)";
                }
                else{
                        return "Valid";
                }
}
}