package com.ahuan.sso.service;

import com.ahuan.sso.mapper.PermissionMapper;
import com.ahuan.sso.mapper.UserMapper;
import com.ahuan.sso.model.Permission;
import com.ahuan.sso.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

/***
 * 
* @ClassName: MyUserDetailsService  
* @Description: 
* @author huan  
* @date 2020年1月16日  
*
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

    private Logger logger = LoggerFactory.getLogger(MyUserDetailsService.class);

    @Autowired
    private UserMapper       userService;
    @Autowired
    private PermissionMapper permissionService;

    public UserDetails loadUserByUsername(String username){

        User user = userService.findUserByUserName(username);
        if(user != null) {
            List<Permission> permissions = permissionService.findPermissionByUserId(user.getUserId());
            user.setPermissions(permissions);
            return  user;
        }
        return null;
    }

}
