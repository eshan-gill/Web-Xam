/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author eshangill
 */
public class Test {
    private int TestId, DepartmentId, JobId, PassingScore, Duration;
    private String TestDate, JobName,DepartmentName;

    public String getDepartmentName() {
        return DepartmentName;
    }

    public void setDepartmentName(String DepartmentName) {
        this.DepartmentName = DepartmentName;
    }

    public String getJobName() {
        return JobName;
    }

    public void setJobName(String JobName) {
        this.JobName = JobName;
    }

    public int getTestId() {
        return TestId;
    }

    public void setTestId(int TestId) {
        this.TestId = TestId;
    }

    public int getDepartmentId() {
        return DepartmentId;
    }

    public void setDepartmentId(int DepartmentId) {
        this.DepartmentId = DepartmentId;
    }

    public int getJobId() {
        return JobId;
    }

    public void setJobId(int JobId) {
        this.JobId = JobId;
    }

    public int getPassingScore() {
        return PassingScore;
    }

    public void setPassingScore(int PassingScore) {
        this.PassingScore = PassingScore;
    }

    public int getDuration() {
        return Duration;
    }

    public void setDuration(int Duration) {
        this.Duration = Duration;
    }

    public String getTestDate() {
        return TestDate;
    }

    public void setTestDate(String TestDate) {
        this.TestDate = TestDate;
    }
    
}
