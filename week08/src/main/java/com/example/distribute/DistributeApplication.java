package com.example.distribute;

import com.example.distribute.configuration.TransactionConfiguration;
import com.example.distribute.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import javax.annotation.PostConstruct;

@SpringBootApplication
@Import(TransactionConfiguration.class)
public class DistributeApplication {

    public static void main(String[] args) {
        SpringApplication.run(DistributeApplication.class, args);
    }


    @Autowired
    private OrderService orderService;

    // 该类构造完成之后执行
    @PostConstruct
    public void executeOrderService() {
        System.err.println("开始执行Service方法.......");
        orderService.insert();
    }
}
