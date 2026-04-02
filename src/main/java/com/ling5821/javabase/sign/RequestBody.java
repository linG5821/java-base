package com.ling5821.javabase.sign;

public class RequestBody {

    private String fileName;
    private String url;
    private String contractType;

    public RequestBody(String fileName, String url, String contractType) {
        this.fileName = fileName;
        this.url = url;
        this.contractType = contractType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }
}