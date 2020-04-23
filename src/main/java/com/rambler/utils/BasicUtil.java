package com.rambler.utils;

import com.rambler.beans.User;
import com.rambler.config.Variable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author rambler
 * @since 2020-02-06 19:35
 */
public class BasicUtil {
    public static User getCurrentUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return (User) session.getAttribute(Variable.CURRENT_USER);
    }
}
