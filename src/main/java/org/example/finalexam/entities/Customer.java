package org.example.finalexam.entities;

public class Customer {
    private int id;
    private String Number;
    private String cname;




    private double idepo;
    private int noy;
    private String tos;

    // Default constructor
    public Customer() {
    }
    public void setIdepo(double idepo) {
        this.idepo = idepo;
    }


    public double getIdepo() {
        return idepo;
    }
    public void setNoy(int noy) {
        this.noy = noy;
    }

    public int getNoy() {
        return noy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }





    public String getTos() {
        return tos;
    }

    public void setTos(String tos) {
        this.tos = tos;
    }

    // Getters and setters

}
