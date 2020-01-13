package com.cn.aop.service.Impl;

import com.cn.aop.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created on 2020/1/13.
 */
@Service
public class UserServiceImpl implements IUserService {
    @Override
    public void add() {
        System.out.println(new Date());
        System.out.println("我是add方法。。。。");
    }
}
