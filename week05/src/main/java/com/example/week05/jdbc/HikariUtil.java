
package com.example.week05.jdbc;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;

import javax.sql.DataSource;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Objects;
import java.util.Properties;

/**
 * Hikari连接池
 */
@Slf4j
public class HikariUtil {

    private final static HikariUtil HIKARI_CP_UTI = new HikariUtil();

    private static Properties properties = null;
    private static HikariDataSource dataSource = null;


    private HikariUtil() {

    }

    /**
     * 1.配置和获取数据库连接配置信息
     * 2.扩展HikariCP功能,进行配置
     * 3.获取数据库连接,提供对外获取数据库资源的方法
     */

    private void initConfig() throws IOException {
        String filePath = Objects.requireNonNull(HikariUtil.class.getClassLoader().getResource("hikaricp.properties")).getFile();
        FileReader fileReader = new FileReader(filePath);
        properties = new Properties();
        properties.load(fileReader);
        properties.forEach((k, v) -> {
            log.debug(String.format("key:%s value:%S", k, v));
        });
        log.info("初始化配置文件成功.....");
    }

    private void registerHikariCP() {
        if (null != dataSource) {
            return;
        }
        HikariConfig config = new HikariConfig(properties);
        dataSource = new HikariDataSource(config);
    }

    //2.提供对外 获取 HikariCPDatasource 的方法
    public static DataSource getHikariCPDataSource() {
        if (null != dataSource) {
            return dataSource;
        }
        try {
            HIKARI_CP_UTI.initConfig();
            HIKARI_CP_UTI.registerHikariCP();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataSource;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                DataSource dataSource = HikariUtil.getHikariCPDataSource();
                System.out.println(Thread.currentThread().getName() + " dataSource = " + dataSource);
            }).start();
        }
        /**
         * 测试和验证 datasource 的准确性
         */
        String sql = "SELECT NOW() nowDate, ROUND(( RAND()* 100 )) randVal;";
        // 获取数据库资源
        DataSource dataSource = HikariUtil.getHikariCPDataSource();

        // 使用 try-resource-catch 方式,自动关闭资源
        try (
                //获取数据库连接
                Connection connection = dataSource.getConnection();
                //预编译
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                //获取结果
                ResultSet resultSet = preparedStatement.executeQuery();
        ) {
            ResultSetMetaData metaData = preparedStatement.getMetaData();
            while (resultSet.next()) {
                int columnCount = metaData.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    log.info(metaData.getColumnName(i) + " : " + resultSet.getObject(i));
                }
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
