package com.mttsui.mybatisplus.service.impl;

import com.mttsui.mybatisplus.entity.User;
import com.mttsui.mybatisplus.mapper.UserMapper;
import com.mttsui.mybatisplus.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2018-08-01
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
