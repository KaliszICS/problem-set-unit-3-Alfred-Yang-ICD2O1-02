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
        String emailValidationMessage;


        System.out.print("Input an email: ");
        emailAddress = input.nextLine();
        emailValidationMessage = confirmingEmail(emailAddress);

        if (emailValidationMessage.startsWith("Valid")){
                System.out.println(emailValidationMessage);
        }
        else{
                System.out.println("Invalid");
                System.out.println(emailValidationMessage);
        }

        
        }

        public static String confirmingEmail(String emailAddress){
                String domain;
                String username;
                String domainSuffix;
                int locationOfAtSymbol;
                int locationOfDotInDomain;

        
                if (!(emailAddress.contains("@"))){
                        return "Missing @";
                }
                else if (!(emailAddress.contains("."))){
                        return "Missing .";
                }

                locationOfAtSymbol = emailAddress.indexOf("@");
                domain = emailAddress.substring(locationOfAtSymbol+1);
                username = emailAddress.substring(0, locationOfAtSymbol);

                if (!(domain.contains("."))){
                        return "No dot in domain";
                }
                locationOfDotInDomain = domain.indexOf(".");
                domainSuffix = domain.substring(locationOfDotInDomain+1);

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
                else if (domainSuffix.contains("1")){
                        return "Domain extension contains non-letters";
                }
                else if (username.contains(".")){
                        return "Valid (Gmail normalized)";
                }
                else{
                        return "Valid";
                }

        






}    
}
