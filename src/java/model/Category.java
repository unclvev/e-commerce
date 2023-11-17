package model;

public class Category {
    private int cid;
    private String cname;
    private int productCount;
    private boolean checked;

    public Category(int cid, String cname, int productCount, boolean checked) {
        this.cid = cid;
        this.cname = cname;
        this.productCount = productCount;
        this.checked = checked;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public Category(int cid, String cname) {
        this.cid = cid;
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "Category{" + "cid=" + cid + ", cname=" + cname + ", productCount=" + productCount + '}';
    }

    public Category() {
    }

    public Category(int cid, String cname, int productCount) {
        this.cid = cid;
        this.cname = cname;
        this.productCount = productCount;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }
}
