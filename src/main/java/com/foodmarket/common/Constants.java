package com.foodmarket.common;

public final class Constants {
    public static final String HOME_PAGE_VIEW_NAME = "home";
    public static final String INDEX_PAGE_VIEW_NAME = "index";
    public static final String SIGNUP_PAGE_VIEW_NAME = "signup";
    public static final String ERROR_PAGE_VIEW_NAME = "error";
    public static final String FOOD_GROUPS_VIEW_NAME = "food-groups";
    public static final String FOOD_GROUP_ITEMS_VIEW_NAME = "food-group-details";

    public static final String SESSION_AUTH_KEY = "authenticated";
    public static final String REDIRECT_PREFIX = "redirect:";
    public static final String INDEX_ENDPOINT = "/";
    public static final String HOME_ENDPOINT = "/home";
    public static final String LOGIN_ENDPOINT = "/login";
    public static final String ERROR_ENDPOINT = "/error";
    public static final String REGISTER_ENDPOINT = "/register";
    public static final String LOGOUT_ENDPOINT = "/logout";

    public static final String INDEX_REDIRECT = REDIRECT_PREFIX + INDEX_ENDPOINT;
    public static final String HOME_REDIRECT = REDIRECT_PREFIX + HOME_ENDPOINT;
}
