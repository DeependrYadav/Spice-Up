package com.spiceUp.javaFrame;

import java.util.List;

import com.spiceUp.entity.AppInfo;

public class Messages {
    static Design intro = new Design(120);
    static Design wd = new Design(55);
    static Design batch = new Design(150);

    static{
        wd.setBorder(1);
        wd.setBorder(1, 1, 1, 1);
        wd.setBorderStyle("+-","-+");
        wd.setBorderColor(Design.PURPLE);
        wd.setPadding(0, 0, 0, 0);
        wd.bold(true);
        wd.setTextColor(Design.PURPLE);

        intro.setBorder(2);
        intro.setBorderStyle("+-");
        intro.setBorderColor(Design.RED);
        intro.setPadding(2);
        
        intro.italic(true);
        intro.setTextColor(Design.CYAN);

        batch.setBorder(1,0,1,0);
        batch.setBorderStyle("-");
        batch.setBorderColor(Design.RED);
        batch.setPadding(0, 1, 0, 1);
    }
    // util methods
    public static void optionsTitle(String title, boolean cancelable){
        if(cancelable){
            Print.printlnStyle(title + " (TYPE '"+Print.wrapStyle('C', Design.GREEN, Design.BOLD, Design.ITALIC, Design.UNDERLINE)+"' FOR CANCELING ANYTIME):-\n", Design.ITALIC, Design.UNDERLINE);
        }
        else{
            Print.printlnStyle(title + " ->\n", Design.ITALIC, Design.UNDERLINE);
        }
    }
    static void option(String title, int index){
        Print.printlnStyle("->" + title +" : Press "+Print.wrapStyle(index), Design.ITALIC, Design.GREEN);
    }
    static public void optionInput(){
        Print.printStyle("Enter selection -> ", Design.UNDERLINE,Design.YELLOW );
    }
    static public void takeInput(String feild, String type){
        if(type != null){
            Print.printStyle(feild + " (" + type +") :" , Design.RED_BACKGROUND, Design.WHITE, Design.BOLD);
        }
        else{
            Print.printStyle(feild + " : " , Design.RED_BACKGROUND, Design.WHITE, Design.BOLD);
        }
    }
    static public void valueName(String str) {
    	Print.printStyle(str , Design.YELLOW, Design.BOLD);
    }
    static public void value(Object val) {
    	Print.printStyle(val , Design.GREEN, Design.ITALIC, Design.BOLD);
    }
    static public void welcomeUser(String name){
        Print.printDesign("Welcome back '"+Print.wrapStyle(name, Design.GREEN, Design.ITALIC, Design.BOLD)+"' (Happy to see you again :)", wd); 
    }
    static public void selectedOption(String title){
        Print.printlnStyle(title, Design.CYAN, Design.BOLD);
    }

    // welcome messages
    static public void initial(){
        Print.printlnStyle(AppInfo.LOGO, Design.WHITE, Design.BOLD, Design.BLACK_BACKGROUND);
        Print.printDesign(AppInfo.DESCRIPTION, intro);
    }
    static public void welcome(){
        Print.printDesign("Welcome to the Spice Up (Here you find all recipes)", wd);
    }
    static public void welcomeOption(){
        optionsTitle("Login SignUp", false);
        option("Login as Administrator", 1);
        option("Login as Customer", 2);
        option("Don't have account? Create new Account", 3);
        option("Exit from system",0);
        Print.printLine(1);
    }

    // admin messages
    static public void adminOption(){
        optionsTitle("HERE ARE A FEW OPTIONS YOU CAN NAVIGATE THROUGH", false);
        option("Add new recipes", 1);
        option("View All recipes", 2);
        option("Update existing recipes", 3);
        option("Delete recipes", 4);
        option("View the number of likes received by each recipe", 5);
        option("Generate reports on recipe likes and popularity", 6);
        option("Logout", 0);
        Print.printLine(1);
    }
    
//    static public void createBatch(){
//        selectedOption("Creating a new Batch...");
//        Print.printLine(1);
//        optionsTitle("PLEASE ENTER BATCH DETAILS", true);
//    }
//    static public void updateBatch(){
//        Print.printLine(1);
//        optionsTitle("PLEASE ENTER BATCH DETAILS", true);
//    }
//    static public void viewBatch(List<Batch> batches){
//        
//        for(int i = 0; i < batches.size(); i++){
//
//            StringBuilder list = new StringBuilder();
//            list.append(Print.wrapStyle("Batch ID: ", Design.BOLD));
//            list.append(batches.get(i).getID());
//            list.append(Print.wrapStyle(" | ", Design.RED));
//
//            list.append(Print.wrapStyle("Course Name: ", Design.BOLD));
//            list.append(batches.get(i).getCourseName());
//            list.append(Print.wrapStyle(" | ", Design.RED));
//
//            list.append(Print.wrapStyle("Number of Seats: ", Design.BOLD));
//            list.append(batches.get(i).getNumberOfSeats());
//            list.append(Print.wrapStyle(" | ", Design.RED));
//
//            list.append(Print.wrapStyle("Start Date: ", Design.BOLD));
//            list.append(batches.get(i).getStartDate());
//            list.append(Print.wrapStyle(" | ", Design.RED));
//
//            list.append(Print.wrapStyle("Duration (Days): ", Design.BOLD));
//            list.append(batches.get(i).getDurationInDays());
//            
//            list.append(Print.wrapStyle("    ("+Print.wrapStyle(i+1, Design.GREEN)+")", Design.ITALIC));
//
//            System.out.println("\u001B" + Print.wrapDesign(list.toString(), batch).trim());
//        }
//    }
//    static public void viewFaculty(List<User> faculties){
//        
//        for(int i = 0; i < faculties.size(); i++){
//
//            StringBuilder list = new StringBuilder();
//            list.append(Print.wrapStyle("Faculty ID: ", Design.BOLD));
//            list.append(faculties.get(i).getID());
//            list.append(Print.wrapStyle(" | ", Design.RED)
//            );
//            list.append(Print.wrapStyle("Username: ", Design.BOLD));
//            list.append(faculties.get(i).USERNAME);
//            list.append(Print.wrapStyle(" | ", Design.RED));
//
//            list.append(Print.wrapStyle("Phone Number: ", Design.BOLD));
//            list.append(faculties.get(i).details.number);
//            list.append(Print.wrapStyle(" | ", Design.RED));
//
//            list.append(Print.wrapStyle("State: ", Design.BOLD));
//            list.append(faculties.get(i).details.state);
//            list.append(Print.wrapStyle(" | ", Design.RED));
//
//            list.append(Print.wrapStyle("ZipCode: ", Design.BOLD));
//            list.append(faculties.get(i).details.zipcode);
//            
//            list.append(Print.wrapStyle("    ("+Print.wrapStyle(i+1, Design.GREEN)+")", Design.ITALIC));
//
//            System.out.println("\u001B" + Print.wrapDesign(list.toString(), batch).trim());;
//        }
//    }
    
    // faculty/user messages
    static public void userOption(){
        optionsTitle("HERE ARE A FEW OPTIONS YOU CAN NAVIGATE THROUGH", false);
        option("View All recipes", 1);
        option("Filter recipes based on ingredients", 2);
        option("Like recipes by id", 3);
        option("View all liked recipes", 3);
        option("Delete my account", 3);
        option("Logout", 0);
        Print.printLine(1);
    }

    // errors messages
    static public void error(Exception e){
        Print.printLine(2);
        Print.printlnStyle(" Something Went Wrong :( ", Design.RED_BACKGROUND, Design.WHITE);
        new Exception(Print.wrapStyle(e.getMessage(), Design.RED_BACKGROUND, Design.WHITE));
    }
    static public void inputError(boolean cancelable){
        Print.printLine(1);
        if(cancelable){
            Print.printStyle("PLEASE ENTER A VALID INPUT (PRESS 'C' FOR CANCEL) :"+ Design.BLANK, Design.RED_BACKGROUND, Design.WHITE, Design.BOLD);
        }
        else{
            Print.printStyle("PLEASE ENTER A VALID INPUT :"+ Design.BLANK, Design.RED_BACKGROUND, Design.WHITE, Design.BOLD);
        }
    }
    static public void error(String msg){
        Print.printlnStyle(msg, Design.RED, Design.RED_BACKGROUND, Design.WHITE);
    }
    static public void warning(String msg){
        Print.printlnStyle(msg, Design.RED, Design.YELLOW_BACKGROUND, Design.BOLD);
    }
    // success messages
    static public void success(String msg){
        Print.printlnStyle(msg, Design.BLACK, Design.CYAN_BACKGROUND, Design.BOLD);
    }

}
