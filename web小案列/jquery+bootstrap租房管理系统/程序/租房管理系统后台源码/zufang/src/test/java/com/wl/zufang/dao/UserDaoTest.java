package com.wl.zufang.dao;

import com.wl.zufang.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author w.z
 * @date 2019/11/24 21:08
 */
@SpringBootTest
@RunWith(SpringRunner.class)
class UserDaoTest {

    @Autowired
    private UserDao userDao;
    @Test
    void insert() {
    }

    @Test
    void getByTelephone() {
        User user = userDao.getByTelephone("15700310046");
        System.out.println(user);
    }

    @Test
    void getByUsername() {
    }
    
}