/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author eshangill
 */
public class TestCategory {
    private int SerialNo, TestId, CategoryId, NOQ;
    private String CategoryName;

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String CategoryName) {
        this.CategoryName = CategoryName;
    }

    public int getSerialNo() {
        return SerialNo;
    }

    public void setSerialNo(int SerialNo) {
        this.SerialNo = SerialNo;
    }

    public int getTestId() {
        return TestId;
    }

    public void setTestId(int TestId) {
        this.TestId = TestId;
    }

    public int getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(int CategoryId) {
        this.CategoryId = CategoryId;
    }

    public int getNOQ() {
        return NOQ;
    }

    public void setNOQ(int NOQ) {
        this.NOQ = NOQ;
    }
}
