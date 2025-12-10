import com.mysql.jdbc.Util;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.*;

public class HomeWork1 {
    public static void main(String[] args) {
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource) dataSource).setUrl("jdbc:mysql://127.0.0.1:3306/javasql?characterEncoding=utf8&&useSSL=false");
        ((MysqlDataSource) dataSource).setUser("root");
        ((MysqlDataSource) dataSource).setPassword("1234");

        try (Connection connection = dataSource.getConnection()) {
            String sql = "select book.name as book_name, book.author as book_authpr,"+
                    "student.name as student_name, borrow_info.start_time, borrow_info.end_time "+
                    "from borrow_info join book on borrow_info.book_id = book.id " +
                    "join category on book.category_id = category.id " +
                    "join student on borrow_info.student_id = student.id "+
                    "where category.name = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, "计算机");
                System.out.println(preparedStatement);

                ResultSet resultSet = preparedStatement.executeQuery();
                while(resultSet.next()){
                    String name = resultSet.getString("book_name");
                    String author = resultSet.getString("book_author");
                    String name1 = resultSet.getString("student_name");
                    Timestamp start_time = resultSet.getTimestamp("start_time");
                    Timestamp end_time = resultSet.getTimestamp("end_time");
                    System.out.println(String.format("书名：%s，作者：%s，借阅者：%s，" +
                                    "借阅起始日期：%s，结束日期：%s",
                                    name, author, name1, start_time, end_time));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

