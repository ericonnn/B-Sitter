package com.example.b_sitter.Model;

public class ModelMajikan {
    private String namaMjkn;
    private String emailMjkn;
    private String pwdMjkn;
    private String noTelpMjkn;
    private String kotaMjkn;
    private String provinsiMjkn;
    private String alamatMjkn;
    private String kodePosMjkn;
    private String status;


    public ModelMajikan() {
    }

    public ModelMajikan(String namaMjkn, String emailMjkn, String pwdMjkn, String noTelpMjkn, String kotaMjkn, String provinsiMjkn, String alamatMjkn, String kodePosMjkn, String status) {
        this.namaMjkn = namaMjkn;
        this.emailMjkn = emailMjkn;
        this.pwdMjkn = pwdMjkn;
        this.noTelpMjkn = noTelpMjkn;
        this.kotaMjkn = kotaMjkn;
        this.provinsiMjkn = provinsiMjkn;
        this.alamatMjkn = alamatMjkn;
        this.kodePosMjkn = kodePosMjkn;
        this.status = status;
    }

    public String getNamaMjkn() {
        return namaMjkn;
    }

    public void setNamaMjkn(String namaMjkn) {
        this.namaMjkn = namaMjkn;
    }

    public String getEmailMjkn() {
        return emailMjkn;
    }

    public void setEmailMjkn(String emailMjkn) {
        this.emailMjkn = emailMjkn;
    }

    public String getPwdMjkn() {
        return pwdMjkn;
    }

    public void setPwdMjkn(String pwdMjkn) {
        this.pwdMjkn = pwdMjkn;
    }

    public String getNoTelpMjkn() {
        return noTelpMjkn;
    }

    public void setNoTelpMjkn(String noTelpMjkn) {
        this.noTelpMjkn = noTelpMjkn;
    }

    public String getKotaMjkn() {
        return kotaMjkn;
    }

    public void setKotaMjkn(String kotaMjkn) {
        this.kotaMjkn = kotaMjkn;
    }

    public String getProvinsiMjkn() {
        return provinsiMjkn;
    }

    public void setProvinsiMjkn(String provinsiMjkn) {
        this.provinsiMjkn = provinsiMjkn;
    }

    public String getAlamatMjkn() {
        return alamatMjkn;
    }

    public void setAlamatMjkn(String alamatMjkn) {
        this.alamatMjkn = alamatMjkn;
    }

    public String getKodePosMjkn() {
        return kodePosMjkn;
    }

    public void setKodePosMjkn(String kodePosMjkn) {
        this.kodePosMjkn = kodePosMjkn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
