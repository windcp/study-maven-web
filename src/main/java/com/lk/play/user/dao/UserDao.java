package com.lk.play.user.dao;

import java.util.List;

import com.lk.play.user.entity.User;

/**
 * 用户接口
 * @author Administrator
 *
 */
public interface UserDao {
    public void insert(User user);
    
    public void delete(User user);
    
    public User get(User user);
    
    public void update(User user);
    
    public List<User> findAllList();
    
    public User getByUserName(String name);
    
    public void insertUserRole(User user);
    
    public void deleteUserRole(User user);
    
    public void updateUserRole(User user);

}
