/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author eshangill
 */
public class Report {
    private String Name;
    private int Attempted, Correct, Incorrect,Score;
    private int CandidateId;
    private String Gender, DOB, FatherName, EmailId, ContactNo;

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getAttempted() {
        return Attempted;
    }

    public void setAttempted(int Attempted) {
        this.Attempted = Attempted;
    }

    public int getCorrect() {
        return Correct;
    }

    public void setCorrect(int Correct) {
        this.Correct = Correct;
    }

    public int getIncorrect() {
        return Incorrect;
    }

    public void setIncorrect(int Incorrect) {
        this.Incorrect = Incorrect;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int Score) {
        this.Score = Score;
    }

    public int getCandidateId() {
        return CandidateId;
    }

    public void setCandidateId(int CandidateId) {
        this.CandidateId = CandidateId;
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

    public String getEmailId() {
        return EmailId;
    }

    public void setEmailId(String EmailId) {
        this.EmailId = EmailId;
    }

    public String getContactNo() {
        return ContactNo;
    }

    public void setContactNo(String ContactNo) {
        this.ContactNo = ContactNo;
    }
    
}
