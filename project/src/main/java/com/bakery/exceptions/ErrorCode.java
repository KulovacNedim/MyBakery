package com.bakery.exceptions;

public enum ErrorCode {
    //Database Error codes (x)
    DATABASE(0, "A database error has occured."),

    //Product Error codes (1X)
    PRODUCT_NOT_FOUND(10, "Product is not found."),
    DUPLICATE_PRODUCT(11, "Product already exists."),
    UPDATE_PRODUCT_ERROR(12, "Product is not updated."),
    DELETE_PRODUCT_ERROR(13, "Product is not deleted."),
    SAVE_PRODUCT_ERROR(14, "Product is not saved."),
    GET_PRODUCTS_ERROR(15, "Error during loading products."),

    //Product Category Error codes (2X)
    PRODUCT_CATEGORY_NOT_FOUND(20, "Product Category is not found."),
    DUPLICATE_PRODUCT_CATEGORY(21, "Product Category already exists."),
    UPDATE_PRODUCT_CATEGORY_ERROR(22, "Product Category is not updated."),
    DELETE_PRODUCT_CATEGORY_ERROR(23, "Product Category is not deleted."),
    SAVE_PRODUCT_CATEGORY_ERROR(24, "Product Category is not saved."),
    GET_PRODUCT_CATEGORY_ERROR(25, "Error during loading product categories."),

    USER_NOT_FOUND(30, "User is not found."),
    DUPLICATE_USER(31, "User already exists."),
    UPDATE_USER_ERROR(32, "User is not updated."),
    DELETE_USER_ERROR(33, "User is not deleted."),
    SAVE_USER_ERROR(34, "User is not saved."),
    GET_USER_ERROR(35, "Error during loading users"),

    ROLE_NOT_FOUND(30, "Role is not found."),
    DUPLICATE_ROLE(31, "Role already exists."),
    UPDATE_ROLE_ERROR(32, "Role is not updated."),
    DELETE_ROLE_ERROR(33, "Role is not deleted."),
    SAVE_ROLE_ERROR(34, "Role is not saved."),
    GET_ROLE_ERROR(35, "Error during loading roles");



    private final int code;
    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "ErrorCode{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
