package Sample12;

import java.util.ArrayList;
import java.util.Scanner;

public class Customer{



    Scanner sc = new Scanner(System.in);

    public Account account() {
        return account;
    }

    public Customer setAccount(Account account) {
        this.account = account;
        return this;
    }

    private Account account;

    private String ID;
    private String password;
    private String name;
    private String pNum;
    private String address;

    public Customer(){};

    public Customer(String ID, String password, String name, String pNum, String address){
        this.ID = ID;
        this.password = password;
        this.name = name;
        this.pNum = pNum;
        this.address = address;
    }
    public String ID() {
        return ID;
    }


    public String password() {
        return password;
    }

    public Customer setPassword(String password) {
        this.password = password;
        return this;
    }

    public String name() {
        return name;
    }

    public Customer setName(String name) {
        this.name = name;
        return this;
    }

    public String pNum() {
        return pNum;
    }

    public Customer setpNum(String pNum) {
        this.pNum = pNum;
        return this;
    }

    public String address() {
        return address;
    }

    public Customer setAddress(String address) {
        this.address = address;
        return this;
    }


    public String toString(){
        return ID + " " + password + " " + name + " " + pNum + " " + address  ;
    }




}
