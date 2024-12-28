/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nancyin.martinna.wmartinna.view;

import com.nancyin.martinna.wmartinna.utils.FileUtil;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.file.UploadedFile;

/**
 *
 * @author 91894
 */
@ManagedBean
@ViewScoped
public class FileUpload implements Serializable {

    private List<String> keys;
    private UploadedFile file;
    

    public String upload() {
        if (file != null) {
            FacesMessage message = new FacesMessage("Successful", file.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
            FileUtil fileUtil = new FileUtil();

            try {
                fileUtil.getAKeys(file.getInputStream());
                keys = fileUtil.getList();
                Procesador p=(Procesador) FacesUtils.getManagedBean("procesador");
                p.setKeys(keys);

            } catch (Exception e) {
                e.printStackTrace();
                message = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getCause().toString());
                FacesContext.getCurrentInstance().addMessage(null, message);
                return null;
            }

        }
        return "procesador";
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public List<String> getKeys() {
        return keys;
    }

    public void setKeys(List<String> keys) {
        this.keys = keys;
    }

}
