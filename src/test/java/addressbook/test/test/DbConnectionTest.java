package addressbook.test.test;

import addressbook.test.model.GroupData;
import addressbook.test.model.Groups;
import org.testng.annotations.Test;

import java.sql.*;

public class DbConnectionTest {
    @Test
    public void testDbConnection() {

        Connection conn = null;
        try {
            conn =
                    DriverManager.getConnection("jdbc:mysql://localhost:3306" +
                            "/addressbook?serverTimezone=UTC&user=root&password=");
            Statement st =  conn.createStatement();
            ResultSet rs = st.executeQuery
                    ("SELECT group_header,group_footer,group_id,group_name FROM group_list ");
            Groups groups = new Groups();
            while (rs.next()){
               groups.add(new GroupData().withId(rs.getInt("group_id"))
                        .withName(rs.getString("group_name"))
                        .withHeader(rs.getString("group_header"))
                        .withFooter(rs.getString("group_footer")));
            }
            rs.close();
            st.close();
            conn.close();
            System.out.println(groups);

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());

        }

    }
}
