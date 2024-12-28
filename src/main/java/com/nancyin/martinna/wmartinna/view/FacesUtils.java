/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nancyin.martinna.wmartinna.view;

import java.util.MissingResourceException;
import java.util.ResourceBundle;
import javax.el.ELContext;
import javax.faces.FactoryFinder;
import javax.faces.application.Application;
import javax.faces.application.ApplicationFactory;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author 91894
 */
public class FacesUtils {
    public static Object getManagedBean(final FacesContext context, final String name) {
        if (context == null) {
            throw new NullPointerException("context must not be null");
        }
        if (name == null) {
            throw new NullPointerException("name must not be null");
        }

        final ELContext elcontext = context.getELContext();
        final Application application = context.getApplication();

        return application.getELResolver().getValue(elcontext, null, name);
    }

    public static Object getManagedBean(final String name) {
        if (FacesContext.getCurrentInstance() == null) {
            return null;
        }
        return FacesUtils.getManagedBean(FacesContext.getCurrentInstance(), name);
    }

    public static Object getManagedBean(Class<?> clazz) {
        return FacesUtils.getManagedBean(getManagedBeanName(clazz));
    }

    public static String getManagedBeanName(Class<?> clazz) {
        String className = clazz.getSimpleName();
        className = className.substring(0, 1).toLowerCase() + className.substring(1);
        return className;
    }

    /**
     * returns the request param value for a given param
     *
     * @param context the faces context
     * @param param the param name
     * @return the param value
     */
    public static String getRequestParam(final FacesContext context, final String param) {
        return context.getExternalContext().getRequestParameterMap().get(param);
    }

    /**
     * returns the request param value for a given param
     *
     * @param param the param name
     * @return the param value
     */
    public static String getRequestParam(final String param) {
        return FacesUtils.getRequestParam(FacesContext.getCurrentInstance(), param);
    }

    /**
     * Add information message.
     *
     * @param msg the information message
     */
    public static void addInfoMessage(String msg) {
        FacesUtils.addInfoMessage(null, msg);
    }

    /**
     * Add information message to a specific client.
     *
     * @param clientId the client id
     * @param msg the information message
     */
    public static void addInfoMessage(String clientId, String msg) {
        FacesContext.getCurrentInstance().addMessage(clientId, new FacesMessage(FacesMessage.SEVERITY_INFO, "PA-CO.", msg));
    }

    /**
     * Add error message.
     *
     * @param msg the error message
     */
    public static void addErrorMessage(String msg) {
        FacesUtils.addErrorMessage(null, msg);
    }

    /**
     * Add error message to a specific client.
     *
     * @param clientId the client id
     * @param msg the error message
     */
    public static void addErrorMessage(String clientId, String msg) {
        FacesContext.getCurrentInstance().addMessage(clientId, new FacesMessage(FacesMessage.SEVERITY_ERROR, "PA-CO.", msg));
    }

    public static void addErrorDetailMessage(String msg, String detail) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "PA-CO.", detail));
    }

    public static void addWarningMessage(String msg) {
        FacesUtils.addWarningMessage(null, msg);
    }

    /**
     * Add error message to a specific client.
     *
     * @param clientId the client id
     * @param msg the error message
     */
    public static void addWarningMessage(String clientId, String msg) {
        FacesContext.getCurrentInstance().addMessage(clientId, new FacesMessage(FacesMessage.SEVERITY_WARN, "PA-CO", msg));
    }

    public static Application getFacesApplication() {
        ApplicationFactory appFactory = (ApplicationFactory) FactoryFinder.getFactory(FactoryFinder.APPLICATION_FACTORY);
        return appFactory.getApplication();
    }

    public static String getMessageForKey(String messageKey) {
        // if translation available, use it
        try {
            return ResourceBundle.getBundle("lang.messages").getString(messageKey);
        } catch (MissingResourceException mre) {
        }
        return "!!!" + messageKey;
    }
}
