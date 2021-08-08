package com.expenseAndDebt.core.managedbean;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class BaseManagedBean {
    public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }

    public void showInfo(String summary, String detail) {
        addMessage(FacesMessage.SEVERITY_INFO, summary, detail);
    }

    public void showWarn(String summary, String detail) {
        addMessage(FacesMessage.SEVERITY_WARN, summary, detail);
    }

    public void showError(String summary, String detail) {
        addMessage(FacesMessage.SEVERITY_ERROR, summary, detail);
    }

    public void showSticky(String summary, String detail) {
        FacesContext.getCurrentInstance().addMessage("sticky-key", new FacesMessage(FacesMessage.SEVERITY_INFO, summary, "Message Content"));
    }
}
