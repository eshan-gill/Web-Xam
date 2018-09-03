/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author eshangill
 */
public class Instruction {
    private int InstructionId, TestId;
    private String InstructionText;

    public int getInstructionId() {
        return InstructionId;
    }

    public void setInstructionId(int InstructionId) {
        this.InstructionId = InstructionId;
    }

    public int getTestId() {
        return TestId;
    }

    public void setTestId(int TestId) {
        this.TestId = TestId;
    }

    public String getInstructionText() {
        return InstructionText;
    }

    public void setInstructionText(String InstructionText) {
        this.InstructionText = InstructionText;
    }
}
