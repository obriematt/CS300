/*
 Matthew O'Brien
CS300 Term Project Task Manager
Due June 3rd, 2015
 */
package TaskManager;

/**
 *
 * @author Matt
 */
public class TaskManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Attempts to create the table. Already made.
        try{
            Storage.createTable();
        }catch (Exception e){
            System.out.println(e);
        }
        //Makes the basic GUI for everything
        LogInMenu loginmenu = new LogInMenu();
        loginmenu.setVisible(true);
        
 
    }        
}
