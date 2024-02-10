package com.stms.service;

import com.stms.bean.Orders;
import com.stms.repo.OrdersRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class OrdersService {

    @Autowired
    private OrdersRepo ordersDao;

    public boolean saveOrUpdateOrder(Orders order) {
        ordersDao.save(order);
        return true;
    }

    public boolean deleteOrderById(Long orderId) {
        ordersDao.deleteById(orderId);
        return true;
    }

    public List<Orders> getAllOrders() {
        Iterator<Orders> iterator = ordersDao.findAll().iterator();
        List<Orders> orderList = new ArrayList<>();
        while (iterator.hasNext()) {
            orderList.add(iterator.next());
        }
        return orderList;
    }
}

