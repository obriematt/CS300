/*
 Matthew O'Brien
CS300 Term Project Task Manager
Due June 3rd, 2015.
 */
package TaskManager;

import java.sql.*;

/**
 *
 * @author Matt
 */
public class Storage {

    //Connection to the online database
    public static Connection getConnection() throws Exception {

        try {
            //The driver for the connection to the database using mySQL
            String driver = "com.mysql.jdbc.Driver";
            //The URL for the database
            String url = "jdbc:mysql://tasker.cmksnghv8dly.us-west-2.rds.amazonaws.com:3306/taskDB";
            //username and password
            String user = "root";
            String pass = "unlocked";
            Class.forName(driver);

            //Connects to the online database
            Connection connection = DriverManager.getConnection(url, user, pass);
            return connection;

        //Making sure it's working
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    //Building the table if it doesn't exist, else do nothing.
    public static void createTable() throws Exception {
        //Builds a table in the online database with columns Username Task and Status
        try {
            Connection connection = getConnection();
            PreparedStatement create;
            create = connection.prepareStatement("CREATE TABLE IF NOT EXISTS MattTable(id int NOT NULL AUTO_INCREMENT, username varchar(255), task varchar(255), status varchar(20), PRIMARY KEY(id))");
            create.executeUpdate();

        //Making sure it works
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    //Inserting into the table with a given username, task, and status
    public static void insertToTable(String userToAdd, String taskToAdd, String taskStatus){
        //Does this work
        try{
            Connection connection = getConnection();
            PreparedStatement create;
            create = connection.prepareStatement("INSERT INTO MattTable(username, task, status) VALUES('"+userToAdd+"','"+taskToAdd+"','"+taskStatus+"')");
            create.executeUpdate(); 
        //Catch if it isn't working.    
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
    
    //Retrieves a concatenated string of tasks from the database for a given username
    public static String retrieveFromTable(String userToFind){
        //Making sure this works
        try{
            String tasksToShow = new String();
            Connection connection = getConnection();
            PreparedStatement retrieve;
            retrieve = connection.prepareStatement("SELECT * FROM MattTable WHERE username='"+userToFind+"'");// AND status='"+taskStatus+"'");
            
            //Grabbing all of the Tasks of a given username
            ResultSet resultsets = retrieve.executeQuery();
            while(resultsets.next()){
                tasksToShow += resultsets.getString("task");
                tasksToShow += "\n";
            }
            //Concatenated String of tasks in correct format for displays.
            return tasksToShow;
            
        //catching if it doesn't connect    
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }
    
    //Retrieves a concatenated string of all task's status from a given username
    public static String retrieveFromStatusTable(String userToFind){
        //Making sure there is a connection
        try{
            String tasksToShow = new String();
            Connection connection = getConnection();
            PreparedStatement retrieve;
            retrieve = connection.prepareStatement("SELECT * FROM MattTable WHERE username='"+userToFind+"'");// AND status='"+taskStatus+"'");
            
            //Grabs all of the statuses and returns the concatenated string in correct formate for display.
            ResultSet resultsets = retrieve.executeQuery();
            while(resultsets.next()){
                tasksToShow += resultsets.getString("status");
                tasksToShow += "\n";
            }
            return tasksToShow;
            
        //Catches on bad connections or other database faults.    
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }
        
    //This retrieves a single status for a specific task for the username    
    public static String retrieveSingleStatusTable(String userToFind, String taskToFind){
        //Making sure connection works to database
        try{
            String statusToShow = new String();
            Connection connection = getConnection();
            PreparedStatement retrieve;
            retrieve = connection.prepareStatement("SELECT * FROM MattTable WHERE username='"+userToFind+"' AND task='"+taskToFind+"' LIMIT 1");
            
            //Redundent since the retrieve is limited to one. Couldn't figure out how to fix this
            ResultSet resultsets = retrieve.executeQuery();
            while(resultsets.next()){
                statusToShow = resultsets.getString("status");
           //     statusToShow += "\n";
            }
            //The single status string return
            return statusToShow;
            
        //Making sure this all works.    
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }
       
    
    //Deletes from the database for a specific username and specific task.
    public static void deleteFromTable(String userToRemove, String taskToRemove){
        //Making sure connection to database is solid.
        try{
            Connection connection = getConnection();
            PreparedStatement remove;
            remove = connection.prepareStatement("DELETE FROM MattTable WHERE username='"+ userToRemove +"' AND task='"+taskToRemove+"' LIMIT 1 ");
            remove.executeUpdate();
        //Check for errors with connection    
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
    
    
    
    



    //testing area
/*    public static void main(String[] args) throws Exception {
        getConnection();
        createTable();
        insertToTable("Bob", "Dildos", "Stuff");
        System.out.println(retrieveFromTable("Bob", "Stuff"));
        deleteFromTable("Bob", "Dildos");
        System.out.println(retrieveFromTable("Bob", "Stuff"));


    }*/

}
