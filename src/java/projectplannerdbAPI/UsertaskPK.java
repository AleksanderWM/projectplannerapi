/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectplannerdbAPI;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author aleks
 */
@Embeddable
public class UsertaskPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "UserID")
    private int userID;
    @Basic(optional = false)
    @Column(name = "TaskID")
    private int taskID;

    public UsertaskPK() {
    }

    public UsertaskPK(int userID, int taskID) {
        this.userID = userID;
        this.taskID = taskID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) userID;
        hash += (int) taskID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsertaskPK)) {
            return false;
        }
        UsertaskPK other = (UsertaskPK) object;
        if (this.userID != other.userID) {
            return false;
        }
        if (this.taskID != other.taskID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "projectplannerdbAPI.UsertaskPK[ userID=" + userID + ", taskID=" + taskID + " ]";
    }
    
}
