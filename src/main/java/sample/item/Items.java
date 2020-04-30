package sample.item;


public class Items {
    public Integer nr_crt;
    public String name;
    public String data_exp;
    public String pret;
    public String gramaj;

    public Items(Integer nr_crt, String name, String data_exp, String pret, String gramaj) {
        this.nr_crt = nr_crt;
        this.name = name;
        this.data_exp = data_exp;
        this.pret = pret;
        this.gramaj = gramaj;
    }

    public Integer getNr_crt() {
        return nr_crt;
    }

    public void setNr_crt(Integer nr_crt) {
        this.nr_crt = nr_crt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData_exp() {
        return data_exp;
    }

    public void setData_exp(String data_exp) {
        this.data_exp = data_exp;
    }

    public String getPret() {
        return pret;
    }

    public void setPret(String pret) {
        this.pret = pret;
    }

    public String getGramaj() {
        return gramaj;
    }

    public void setGramaj(String gramaj) {
        this.gramaj = gramaj;
    }

}
