package com.laitram.jpa;

import javax.enterprise.context.Dependent;
import javax.persistence.Embeddable;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

@Dependent
@Embeddable
public class ResultStatus {

    @Transient
    private String status;

    @Transient
    private List<String> errors;

    public ResultStatus()
    {
        status = "OK";
        errors = new ArrayList<>();
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public List<String> getErrors()
    {
        return errors;
    }

    public void setErrors(List<String> errors)
    {
        this.errors = errors;
    }

    public void addError(String error)
    {
        this.errors.add(error);
        this.status = "ERROR";
    }
}
