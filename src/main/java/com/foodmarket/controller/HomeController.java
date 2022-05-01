package com.foodmarket.controller;

import com.foodmarket.common.Constants;
import com.foodmarket.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


/**
 * Home page for both logged in and guest users.
 */
@Controller
public class HomeController {
    /**
     * Handles guest users, who visit the home page.
     * @return
     */
    @RequestMapping(Constants.INDEX_ENDPOINT)
    public String index(HttpServletRequest request, Model model) {
        User value = (User) request.getSession().getAttribute(Constants.SESSION_AUTH_KEY);
        if (value != null) {
            return Constants.HOME_REDIRECT;
        }

        return Constants.INDEX_PAGE_VIEW_NAME;
    }

    /**
     * Handles authenticated/logged-in users.
     * @return
     */
    @RequestMapping(Constants.HOME_ENDPOINT)
    public String home(HttpServletRequest request, Model model) {
        return processIndexRequest(request, model);
    }

    private String processIndexRequest(HttpServletRequest request, Model model) {
        User value = (User) request.getSession().getAttribute(Constants.SESSION_AUTH_KEY);
        if (value == null) {
            return Constants.INDEX_REDIRECT;
        }

        model.addAttribute("user", value);
        return Constants.HOME_PAGE_VIEW_NAME;
    }
}
