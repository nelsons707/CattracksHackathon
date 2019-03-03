package nelson.cattracks;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.Scanner;

public class DB {



    static Connection connection = null;
    static int warehouseCounter = 0;

    public static void startConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:/../CatTracksDatabase/CatTracks");
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public double getCoordinatesX(String addressName) {
        try {
            double x = 0;
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.
            ResultSet coordinates = statement.executeQuery(
                    "select loc_coord_x"
                            + "from Location "
                            + "where loc_name = '" + addressName + "'");
            while (coordinates.next()) {
                x = coordinates.getDouble("loc_coord_x");
            }

            return x;
        }
        catch (SQLException e) {
            System.err.println(e);
        }
        return 0;
    }

    public double getCoordinatesY(String addressName) {
        try {
            double y = 0;
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.
            ResultSet coordinates = statement.executeQuery(
                    "select loc_coord_y"
                            + "from Location "
                            + "where loc_name = '" + addressName + "'");
            while (coordinates.next()) {
                y = coordinates.getDouble("loc_coord_y");
            }

            return y;
        }
        catch (SQLException e) {
            System.err.println(e);
        }
        return 0;
    }

/*

select loc_coord_x, loc_coord_y
from Location
where loc_name = (addressName)
*/



    public static String convertMinutesToTime(int minutes) {
        String time = "00:00";
        if (minutes > 0) {
            //mult hour by 60 and + min
            //int hourminute = minutes%60;
            //minutes = hourminute - minutes;
            //time = minutes/60 + ":" + hourminute;

            time = Math.floor(minutes/60) + ":" + (minutes % 60);
        }
        return time;
    }

    public static int convertTimeToMinutes(String time) {
        int minutes = 0;
        //mult hour by 60 and + min
        minutes = (((time.charAt(0)*10)+time.charAt(1))*60) + ((time.charAt(2)*10)+time.charAt(3));
        return minutes;
    }


    public static String getClosestTime(String inputLocation, String currentTime) {
        String closestTime = "";
        try {
            int bestDifference = 1440;
            int currentDifference = 0;
            int closestMinutes = 0;
            int currentMinutes = convertTimeToMinutes(currentTime);
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.
            ResultSet coordinates = statement.executeQuery(
                    "select bl_time "
                            + "from BusLoc, Location "
                            + "where loc_name = '" + inputLocation + "' "
                            + "and loc_key = bl_loc");
            while (coordinates.next()) {
                int tempTime = coordinates.getInt("bl_time");
                currentDifference = Math.abs(closestMinutes - tempTime);
                if (currentDifference < bestDifference) {
                    bestDifference = currentDifference;
                    closestMinutes = tempTime;
                }
            }
            closestTime = convertMinutesToTime(closestMinutes);
        }
        catch (SQLException e) {
            System.err.println(e);
        }
        return closestTime;
    }






}