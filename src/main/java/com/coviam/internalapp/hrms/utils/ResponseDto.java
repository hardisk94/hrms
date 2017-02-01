package com.coviam.internalapp.hrms.utils;

/**
 * Created by Coviam on 29/01/17.
 */
public class ResponseDto {
    private Integer status;
    private Object result;

    public ResponseDto() {
    }

    public ResponseDto(Integer status, Object object) {
        this.status = status;
        this.result = object;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object object) {
        this.result = object;
    }
}
