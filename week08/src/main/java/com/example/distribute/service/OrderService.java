
package com.example.distribute.service;

import org.apache.shardingsphere.transaction.annotation.ShardingTransactionType;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.apache.shardingsphere.transaction.core.TransactionTypeHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 订单类实例
 */
@Service
public class OrderService {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Transactional
    @ShardingTransactionType(TransactionType.XA)
    public TransactionType insert() {
        return (TransactionType) jdbcTemplate.execute("INSERT INTO t_order (id, name, num) values (?, ?, ?)",
                (PreparedStatementCallback<Object>) ps-> {
                    this.doInsert(ps);
                    return TransactionTypeHolder.get();
                });
    }


    private void doInsert(PreparedStatement ps) throws SQLException {
        for (int i = 0; i < 100; i++) {
            ps.setInt(1, i);
            ps.setString(2, "name"+i);
            ps.setInt(3, 100);
            ps.executeUpdate();
        }
    }

}
