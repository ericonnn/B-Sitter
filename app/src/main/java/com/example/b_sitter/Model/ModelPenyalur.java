package com.example.b_sitter.Model;

public class ModelPenyalur {
    private String namaPylr;
    private String emailPylr;
    private String pwdPylr;
    private String noTelpPylr;
    private String kotaPylr;
    private String provinsiPylr;
    private String alamatPylr;
    private String kodePosPylr;
    private String namaPerusahaanPylr;
    private String status;

    public ModelPenyalur() {
    }

    public ModelPenyalur(String namaPylr, String emailPylr, String pwdPylr, String noTelpPylr, String kotaPylr, String provinsiPylr, String alamatPylr, String kodePosPylr, String namaPerusahaanPylr, String status) {
        this.namaPylr = namaPylr;
        this.emailPylr = emailPylr;
        this.pwdPylr = pwdPylr;
        this.noTelpPylr = noTelpPylr;
        this.kotaPylr = kotaPylr;
        this.provinsiPylr = provinsiPylr;
        this.alamatPylr = alamatPylr;
        this.kodePosPylr = kodePosPylr;
        this.namaPerusahaanPylr = namaPerusahaanPylr;
        this.status = status;
    }

    public String getNamaPylr() {
        return namaPylr;
    }

    public void setNamaPylr(String namaPylr) {
        this.namaPylr = namaPylr;
    }

    public String getEmailPylr() {
        return emailPylr;
    }

    public void setEmailPylr(String emailPylr) {
        this.emailPylr = emailPylr;
    }

    public String getPwdPylr() {
        return pwdPylr;
    }

    public void setPwdPylr(String pwdPylr) {
        this.pwdPylr = pwdPylr;
    }

    public String getNoTelpPylr() {
        return noTelpPylr;
    }

    public void setNoTelpPylr(String noTelpPylr) {
        this.noTelpPylr = noTelpPylr;
    }

    public String getKotaPylr() {
        return kotaPylr;
    }

    public void setKotaPylr(String kotaPylr) {
        this.kotaPylr = kotaPylr;
    }

    public String getProvinsiPylr() {
        return provinsiPylr;
    }

    public void setProvinsiPylr(String provinsiPylr) {
        this.provinsiPylr = provinsiPylr;
    }

    public String getAlamatPylr() {
        return alamatPylr;
    }

    public void setAlamatPylr(String alamatPylr) {
        this.alamatPylr = alamatPylr;
    }

    public String getKodePosPylr() {
        return kodePosPylr;
    }

    public void setKodePosPylr(String kodePosPylr) {
        this.kodePosPylr = kodePosPylr;
    }

    public String getNamaPerusahaanPylr() {
        return namaPerusahaanPylr;
    }

    public void setNamaPerusahaanPylr(String namaPerusahaanPylr) {
        this.namaPerusahaanPylr = namaPerusahaanPylr;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
