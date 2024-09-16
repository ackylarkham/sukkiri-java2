import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemsDAO {
    
    static {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("JDBCドライバーのロードに失敗");
        }
    }
    public static ArrayList<Item> findByMinimumPrice(int i) {
        
        Connection conn = null;
        ArrayList<Item> items = new ArrayList<>();
        try {
            conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM ITEMS WHERE PRICE >= ?");
            pstmt.setInt(1, i);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                Item item = new Item();
                item.setName(rs.getString("NAME"));
                item.setPrice(rs.getInt("PRICE"));
                item.setWeight(rs.getInt("WEIGHT"));
                items.add(item);
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
        return items;
    }
}
