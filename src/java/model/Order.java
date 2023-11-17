/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author viet2
 */
public class Order {
    private int id;
    private String date;
    private int cid;
    private double totalMoney;
    private String userName; // Thêm thuộc tính userName
    private int isSell; // Thêm thuộc tính isSell

    public Order() {
    }

    public Order(int id, String date, int cid, double totalMoney, String userName, int isSell) {
        this.id = id;
        this.date = date;
        this.cid = cid;
        this.totalMoney = totalMoney;
        this.userName = userName;
        this.isSell = isSell;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getIsSell() {
        return isSell;
    }

    public void setIsSell(int isSell) {
        this.isSell = isSell;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", date=" + date + ", cid=" + cid + ", totalMoney=" + totalMoney + '}';
    }

    
}
