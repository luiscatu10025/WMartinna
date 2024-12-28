/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nancyin.martinna.wmartinna.utils;

/**
 *
 * @author luisc
 */
public class NancysException extends Exception{

    public NancysException() {
    }

    public NancysException(String message) {
        super(message);
    }

    public NancysException(String message, Throwable cause) {
        super(message, cause);
    }

    public NancysException(Throwable cause) {
        super(cause);
    }

    public NancysException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
