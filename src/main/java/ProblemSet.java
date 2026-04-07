/**

        * File: Problem Set Unit 3 
        * Author: Alfred Yang
        * Date Created: March 30, 2026
        * Date Last Modified: April 7, 2026
        */

// This program validates or invalidates email addresses according to a select set of rules.
import java.util.Scanner;
public class ProblemSet {


	public static void main(String args[]){
                Scanner input = new Scanner(System.in);
                String emailAddress;        
                String firstemailAddress;
                String secondemailAddress;                                                                 ;
                String firstEmailValidationMessage;
                String secondEmailValidationMessage;
                String local;
                String domain;
                Boolean secondemailAddressExist = false;

                //checking how many emails there are
                System.out.print("Input two emails: ");
                emailAddress = input.nextLine();
                if (!(emailAddress.contains(", "))){
                        firstemailAddress = emailAddress;
                        secondemailAddress = null;
                        secondEmailValidationMessage = null;
                }
                else { 
                        secondemailAddressExist = true;
                        secondemailAddress = emailAddress.substring(emailAddress.indexOf(", ")+2);
                        firstemailAddress = emailAddress.substring(0, emailAddress.indexOf(", "));
                }
                
                firstEmailValidationMessage = confirmingEmail(firstemailAddress);
                if (firstEmailValidationMessage.startsWith("Valid")){
                        local = firstemailAddress.substring(0, firstemailAddress.indexOf("@"));
                        domain = firstemailAddress.substring(firstemailAddress.indexOf("@")+1);
                        //output message for the first email when it's valid
                        System.out.println(firstemailAddress + ": " + firstEmailValidationMessage + " | Local: " + local + " | Domain: " + domain);
                }
                else{
                        //output message for the first email when it's invalid
                        System.out.println(firstemailAddress + ": Invalid: " + firstEmailValidationMessage);
                }
                
                if (!(secondemailAddressExist)){
                        return;
                }
                
                secondEmailValidationMessage = confirmingEmail(secondemailAddress);
                if (secondEmailValidationMessage.startsWith("Valid")){
                        local = secondemailAddress.substring(0, secondemailAddress.indexOf("@"));
                        domain = secondemailAddress.substring(secondemailAddress.indexOf("@")+1);
                        //output message for the second email when it's valid
                        System.out.println(secondemailAddress + ": " + secondEmailValidationMessage + " | Local: " + local + " | Domain: " + domain);
                }
                else{
                        //output message for the second email when it's invalid
                        System.out.println(secondemailAddress + ": Invalid: " + secondEmailValidationMessage);
                }
        }
        public static String confirmingEmail(String emailAddress){
                String domain;
                String username;
                String domainSuffix;
                int locationOfAtSymbol;
                int locationOfDotInDomain;

                if (!emailAddress.contains("@")){
                        return "Missing @";
                }
                else if (!(emailAddress.contains("."))){
                        return "Missing .";
                }

                locationOfAtSymbol = emailAddress.indexOf("@");
                domain = emailAddress.substring(locationOfAtSymbol + 1);
                username = emailAddress.substring(0, locationOfAtSymbol);

                // normalizing gmail addresses
                if (domain.endsWith("gmail.com")){
                        username = username.replaceAll("\\+", "");
                        username = username.replaceAll("\\_", "");
                        username = username.replaceAll("\\.", "");
                }

                if (!(domain.contains("."))){
                        return "No dot in domain";
                }
                locationOfDotInDomain = domain.lastIndexOf(".");
                domainSuffix = domain.substring(locationOfDotInDomain + 1);

                if (domain.contains("@") && username.contains("@")){
                        return "Multiple @";
                }
                else if (emailAddress.startsWith(".") && emailAddress.endsWith(".")){
                        return "Starts or ends with dot";
                }
                else if (emailAddress.contains(" ")){
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
                else if (domain.endsWith("gmail.com")){
                        return "Valid (Gmail normalized)";
                }             
                else {
                        return "Valid";
                }
}
}