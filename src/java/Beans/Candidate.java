/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author eshangill
 */
public class Candidate {
    private int CandidateId, TestId;
    private String Name, Gender, DOB, FatherName, HigherQualification, Address, ContactNo, EmailId;

    public int getCandidateId() {
        return CandidateId;
    }

    public void setCandidateId(int CandidateId) {
        this.CandidateId = CandidateId;
    }

    public int getTestId() {
        return TestId;
    }

    public void setTestId(int TestId) {
        this.TestId = TestId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getFatherName() {
        return FatherName;
    }

    public void setFatherName(String FatherName) {
        this.FatherName = FatherName;
    }

    public String getHigherQualification() {
        return HigherQualification;
    }

    public void setHigherQualification(String HigherQualification) {
        this.HigherQualification = HigherQualification;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getContactNo() {
        return ContactNo;
    }

    public void setContactNo(String ContactNo) {
        this.ContactNo = ContactNo;
    }

    public String getEmailId() {
        return EmailId;
    }

    public void setEmailId(String EmailId) {
        this.EmailId = EmailId;
    }
}
