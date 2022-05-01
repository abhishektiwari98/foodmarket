package com.foodmarket.controller;

import com.foodmarket.common.Constants;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

public class CustomErrorController implements ErrorController {

    @RequestMapping(value = Constants.ERROR_ENDPOINT)
    public String handleError(Model model, HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());
            model.addAttribute("error_code" ,statusCode);
        }

        return Constants.ERROR_PAGE_VIEW_NAME;
    }
}
