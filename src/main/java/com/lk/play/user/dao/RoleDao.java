package com.lk.play.user.dao;

import java.util.List;

import com.lk.play.user.entity.Role;
/**
 * ╫ги╚╫с©з
 * @author Administrator
 *
 */
public interface RoleDao {
    public void insert(Role role);
    
    public void delete(Role role);
    
    public Role get(Role role);
    
    public List<Role> getAll();
    
    public void insertRoleMenu(Role role);
    
    public void update(Role role);
    
    public String getRole(String id);

}
