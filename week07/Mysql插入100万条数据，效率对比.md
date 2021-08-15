# Mysql插入100万条数据，效率对比

## 测试环境

首先我的机器性能比较差，只供参考。下面是我机器的参数。

![image-20210814101048298](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210814101048298.png)

## 存储过程

1.首先关闭Mysql对存储过程的限制。

```
set global log_bin_trust_function_creators = 0;
```

2.创建存储过程

```
drop procedure if exists prepare_test_data;
DELIMITER $$
CREATE PROCEDURE prepare_test_data(IN repeat_times INT(10))
BEGIN
    DECLARE i INT DEFAULT 0;
    loopname:
    LOOP
        SET i = i + 1;

        INSERT INTO `order`
            (id, order_no, user_id, total_price, total_count, create_time,
             delete_time, expired_time, placed_time, update_time, snap_img,
             snap_title, snap_items, snap_address, prepay_id, final_total_price,
             status) VALUES
        (i, 10+i, 10, 20.0, 200, sysdate(), null, null, null, null, '', 'test_data',
         '', null, 10, 200.00, 1);

        IF i = repeat_times THEN
            LEAVE loopname;
        END IF;
    END LOOP loopname;
END $$;
```

3.调用存储过程

```
-- 把order表数据量变成原先的2^10倍
call prepare_test_data(10);
```

结果：

![image-20210814104220220](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20210814104220220.png)