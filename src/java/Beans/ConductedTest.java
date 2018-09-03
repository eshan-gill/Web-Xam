/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.util.ArrayList;

/**
 *
 * @author eshangill
 */
public class ConductedTest {
    private int ConductedTestId, TestId, CandidateId;
    
    public ArrayList<AttemptedQuestion> AllAQuestions= new ArrayList<AttemptedQuestion>();

    public int getConductedTestId() {
        return ConductedTestId;
    }

    public void setConductedTestId(int ConductedTestId) {
        this.ConductedTestId = ConductedTestId;
    }

    public int getTestId() {
        return TestId;
    }

    public void setTestId(int TestId) {
        this.TestId = TestId;
    }

    public int getCandidateId() {
        return CandidateId;
    }

    public void setCandidateId(int CandidateId) {
        this.CandidateId = CandidateId;
    }
    
}
