package com.foodmarket.controller;

import com.foodmarket.common.Constants;
import com.foodmarket.common.Utils;
import com.foodmarket.model.User;
import com.foodmarket.service.UserService;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = Constants.REGISTER_ENDPOINT)
    public String register(Model model, HttpServletRequest request) {
        String firstName = request.getParameter("fName");
        String lastName = request.getParameter("lName");
        String pwd = request.getParameter("pwd");
        String confirmPwd = request.getParameter("cnfpwd");
        String email = request.getParameter("email");
        String city = request.getParameter("city");
        String country = request.getParameter("country");
        String zipCode = request.getParameter("zipCode");

        // server side validations
        if (!validateRequest(firstName, lastName, pwd, confirmPwd, email, city, country, zipCode)) {
            return Constants.ERROR_PAGE_VIEW_NAME;
        }

        String encryptedPass = Utils.getPasswordHash(pwd);
        User newUser = new User();
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setPassword(encryptedPass);
        newUser.setEmail(email);
        newUser.setCity(city);
        newUser.setCountry(country);
        newUser.setZipCode(Integer.parseInt(zipCode));

        userService.createNewUser(newUser);

        return Constants.INDEX_PAGE_VIEW_NAME;
    }

    @PostMapping(path = Constants.LOGIN_ENDPOINT)
    public String login(@RequestParam("email") String email,
                      @RequestParam("pwd") String password,
                      HttpServletRequest request,
                      Model model) {
        User userInSession = (User) request.getSession().getAttribute(Constants.SESSION_AUTH_KEY);
        if (userInSession != null) {
            // user is already logged in
            return setUserInfoInView(userInSession, model);
        }

        User user = userService.validateUser(email, password);
        if (user != null) {
            // store user in the session
            request.getSession().setAttribute(Constants.SESSION_AUTH_KEY, user);
            return setUserInfoInView(user, model);
        } else {
            return Constants.INDEX_PAGE_VIEW_NAME;
        }
    }

    private String setUserInfoInView(User user, Model model) {
        model.addAttribute("user", user);
        return "home";
    }


    @RequestMapping(path = Constants.LOGOUT_ENDPOINT)
    public String destroySession(HttpServletRequest request, Model model) {
        //invalidate the session and redirect the user to home page
        request.getSession().invalidate();
        return Constants.HOME_REDIRECT;
    }

    private boolean validateRequest(String fName, String lName, String pwd, String cnfPwd, String email, String city, String country, String zipCode) {
        try {
            Preconditions.checkArgument(fName != null && !fName.isEmpty());
            Preconditions.checkArgument(lName != null && !lName.isEmpty());
            Preconditions.checkArgument(pwd != null && !pwd.isEmpty());
            Preconditions.checkArgument(cnfPwd != null && !cnfPwd.isEmpty());
            Preconditions.checkArgument(email != null && !email.isEmpty());
            Preconditions.checkArgument(city != null && !city.isEmpty());
            Preconditions.checkArgument(country != null && !country.isEmpty());
            Preconditions.checkArgument(zipCode != null && !zipCode.isEmpty());

            Preconditions.checkArgument(pwd.equals(cnfPwd));
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
