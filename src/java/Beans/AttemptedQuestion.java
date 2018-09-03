/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author eshangill
 */
public class AttemptedQuestion {
    private int AQId, QuestionId, OptionId,ConductedTestId;

    public int getAQId() {
        return AQId;
    }

    public void setAQId(int AQId) {
        this.AQId = AQId;
    }

    public int getQuestionId() {
        return QuestionId;
    }

    public void setQuestionId(int QuestionId) {
        this.QuestionId = QuestionId;
    }

    public int getOptionId() {
        return OptionId;
    }

    public void setOptionId(int OptionId) {
        this.OptionId = OptionId;
    }

    public int getConductedTestId() {
        return ConductedTestId;
    }

    public void setConductedTestId(int ConductedTestId) {
        this.ConductedTestId = ConductedTestId;
    }

    
}
