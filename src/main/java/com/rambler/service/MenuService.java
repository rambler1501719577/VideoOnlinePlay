package com.rambler.service;

import com.rambler.config.Response;
import com.rambler.dao.UserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author rambler
 * @since 2020-02-03 16:41
 */
@Service
public class MenuService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    public Response searchMenuByRole(HttpServletRequest request) {
        return null;
    }
}
