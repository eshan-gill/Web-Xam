/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

/**
 *
 * @author eshangill
 */
public class Job {
    private int JobId;
    private String JobName, Description;

    public int getJobId() {
        return JobId;
    }

    public void setJobId(int JobId) {
        this.JobId = JobId;
    }

    public String getJobName() {
        return JobName;
    }

    public void setJobName(String JobName) {
        this.JobName = JobName;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
    
}
