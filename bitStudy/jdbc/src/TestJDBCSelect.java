import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestJDBCSelect {
    public static void main(String[] args) throws SQLException {
        //1.构造DataSource
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource) dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/javasql?characterEncoding=utf8&&useSSL=false");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("1234");

        //2.建立连接
        Connection connection = dataSource.getConnection();

        //3. 构造sql
        String sql = "select * from student";
        PreparedStatement statement = connection.prepareStatement(sql);

        //执行sql
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()){
            //获取”id“这一列的数值
            int id = resultSet.getInt("id");
            //获取”name“这一列的数值
            String name = resultSet.getString("name");
            System.out.println("id: "+id);
            System.out.println("name: "+name);
        }

        statement.close();
        connection.close();
    }
}
