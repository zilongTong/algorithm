package dbconnect;

import java.sql.*;

/**
 * @ClassName DBConnection
 * @Author Leo
 * @Description //TODO
 * @Date: 2018/12/19 19:24
 **/
public class DBConnection {

    private Connection con;            //定义数据库连接类对象
    private PreparedStatement pstm;
    private String user = "root";        //连接数据库用户名
    private String password = "root";        //连接数据库密码
    private String driverName = "com.mysql.jdbc.Driver";    //数据库驱动
    private String url = "jdbc:mysql://127.0.0.1:3307/sharding_db";

    //连接数据库的URL,后面的是为了防止插入数据 库出现乱码，?useUnicode=true&characterEncoding=UTF-8
//构造函数
    public DBConnection() {

    }

    public static void main(String[] args) {
        System.out.println(111111);
        Connection mConnection = new DBConnection().getConnection();
        if (mConnection != null) {
            try {
                String sql = "select * from t_order";
                PreparedStatement pstm = mConnection.prepareStatement(sql);
                ResultSet rs = pstm.executeQuery();
                while (rs.next()) {
                    System.out.println(rs.getInt(0));
                }
                rs.close();
                pstm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (mConnection != null) {
                        mConnection.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 创建数据库连接
     */
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("加载数据库驱动失败！");
            e.printStackTrace();
        }
        try {
            con = DriverManager.getConnection(url, user, password);        //获取数据库连接
        } catch (SQLException e) {
            System.out.println("创建数据库连接失败！");
            con = null;
            e.printStackTrace();
        }
        return con;                    //返回数据库连接对象
    }

    public void test() {
        //    List<Shop> mShopList = new ArrayList<Shop>();
        Connection mConnection = new DBConnection().getConnection();
        if (mConnection != null) {
            try {
                String sql = "select * from shop";
                PreparedStatement pstm = mConnection.prepareStatement(sql);
                ResultSet rs = pstm.executeQuery();
                while (rs.next()) {

                }
                rs.close();
                pstm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (mConnection != null) {
                        mConnection.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}