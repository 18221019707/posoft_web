package cn.posolft.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.posolft.dao.IUserMapper;
import cn.posolft.pojo.User;
import cn.posolft.service.IUserService;

@Service("userService")  
public class UserServiceImpl implements IUserService {  
    @Resource  
    private IUserMapper iUserMapper;  
    @Override  
    public User getUserById(int userId) {  
        return this.iUserMapper.selectByPrimaryKey(userId);  
    }  
  
}  

