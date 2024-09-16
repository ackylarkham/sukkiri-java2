import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App {

    static {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("JDBCドライバーのロードに失敗");
        }
    }
    public static void main(String[] args) throws Exception {
        
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM ITEMS");
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                System.out.println(rs.getString("NAME") + " " + rs.getInt("PRICE") + " " + rs.getInt("WEIGHT"));
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn == null) {
                //NOP
            } else {
                try {
                    
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
