/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author eshangill
 */
public class Option {
    private int OptionId, QuestionId;
    private String OptionText;
    private Byte IsAnswer;

    public int getOptionId() {
        return OptionId;
    }

    public void setOptionId(int OptionId) {
        this.OptionId = OptionId;
    }

    public int getQuestionId() {
        return QuestionId;
    }

    public void setQuestionId(int QuestionId) {
        this.QuestionId = QuestionId;
    }

    public String getOptionText() {
        return OptionText;
    }

    public void setOptionText(String OptionText) {
        this.OptionText = OptionText;
    }

    public Byte getIsAnswer() {
        return IsAnswer;
    }

    public void setIsAnswer(Byte IsAnswer) {
        this.IsAnswer = IsAnswer;
    }
}
