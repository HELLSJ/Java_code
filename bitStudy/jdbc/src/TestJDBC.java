import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TestJDBC {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入学号：");
        int id = scanner.nextInt();
        System.out.println("请输入姓名：");
        String name = scanner.next();
        //1.创建数据源，数据源描述了你要操作的数据库在哪里
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource) dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/javasql?characterEncoding=utf8&&useSSL=false");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("1234");

        //2.和数据库服务器建立连接
        Connection connection = dataSource.getConnection();

        //3.构造一个sql,需要把sql转成String对象
        String sql = "insert into student values(?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.setString(2, name);

        //4.把构造好的sql发送给服务器执行
        int n = statement.executeUpdate();
        System.out.println("n= " + n);

        //5.释放必要的资源
        statement.close();
        connection.close();
    }
}
