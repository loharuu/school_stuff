import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class tempController {
    private temperatureConverter tempConv = new temperatureConverter();

    public double convert(String type, String oldType, double temp) throws SQLException {
        Object[] answer = new Object[2]; // I WANT it as one function and i know it is kinda bad to do like this
        double newTemp = 0;
        boolean isExtreme = false;
        switch (oldType){
            case "celsius" -> {
                switch (type){
                    case "celsius" -> {
                        newTemp = temp;
                        isExtreme = tempConv.isExtremeTemperature(temp);
                    }
                    case "fahrenheit" ->{
                        newTemp = tempConv.fahrenheitToCelsius(temp);
                        isExtreme = tempConv.isExtremeTemperature(newTemp);
                    }
                }
            }
            case "fahrenheit" ->{
                switch (type){
                    case "celsius" -> {
                        newTemp = tempConv.fahrenheitToCelsius(temp);
                        isExtreme = tempConv.isExtremeTemperature(newTemp);
                    }
                    case "fahrenheit" ->{
                        newTemp = temp;
                        isExtreme = tempConv.isExtremeTemperature(tempConv.fahrenheitToCelsius(temp));
                    }
                }
            }
            case "kelvin" ->{
                switch (type){
                    case "celsius" -> {
                        newTemp = tempConv.kelvinToCelsius(temp);
                        isExtreme = tempConv.isExtremeTemperature(newTemp);
                    }
                    case "fahrenheit" ->{
                        newTemp = tempConv.celsiusToFahrenheit(tempConv.kelvinToCelsius(temp));
                        isExtreme = tempConv.isExtremeTemperature(newTemp);
                    }
                }
            }
        }


        save(type, oldType, temp, newTemp, isExtreme);

        answer[0] = newTemp;
        answer[1] = isExtreme;
        //nwm i dont need that

        return newTemp;
    }


    public void save(String type, String oldType, double oldTemp, double newTemp, boolean isExtreme) throws SQLException {
        String sql = "INSERT INTO tempConversionHistory (originalConversion, newConversion, oldTemp, newTemp, isExtreme) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBconn.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, type);
            ps.setString(2, oldType);
            ps.setDouble(3, oldTemp);
            ps.setDouble(4, newTemp);
            ps.setBoolean(5, isExtreme);
            ps.executeUpdate();
        }
    }
    public void saveExtreme(double temp) throws SQLException {
        String sql = "INSERT INTO extremeTemps (temp) " +
                "VALUES (?)";

        try (Connection conn = DBconn.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setDouble(1, temp);
            ps.executeUpdate();
        }
    }

    public static List<String> getHistory(){
        List<String> answ = new ArrayList<>();
        String sql = "SELECT * FROM tempConversionHistory ORDER BY date DESC";

        try (Connection conn = DBconn.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            String str = "id: %s, was/is: %s / %s, temp (was/is): %2.3f / %2.3f, is Extreme: %b";
            while (rs.next()) {
                answ.add(String.format(str, rs.getInt("id"), rs.getString("originalConversion"), rs.getString("newConversion"), rs.getDouble("oldTemp"), rs.getDouble("newTemp"), rs.getBoolean("isExtreme")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return answ;
    }


}
