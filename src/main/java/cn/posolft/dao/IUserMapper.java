package cn.posolft.dao;

import org.springframework.stereotype.Repository;

import cn.posolft.pojo.User;

@Repository
public interface IUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}