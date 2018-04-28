/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectplannerdbAPI;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author aleks
 */
@Entity
@Table(name = "usertask")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usertask.findAll", query = "SELECT u FROM Usertask u")
    , @NamedQuery(name = "Usertask.findByUserID", query = "SELECT u FROM Usertask u WHERE u.usertaskPK.userID = :userID")
    , @NamedQuery(name = "Usertask.findByTaskID", query = "SELECT u FROM Usertask u WHERE u.usertaskPK.taskID = :taskID")
    , @NamedQuery(name = "Usertask.findByRole", query = "SELECT u FROM Usertask u WHERE u.role = :role")})
public class Usertask implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsertaskPK usertaskPK;
    @Column(name = "Role")
    private Integer role;
    @JoinColumn(name = "TaskID", referencedColumnName = "TaskID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Tasks tasks;
    @JoinColumn(name = "UserID", referencedColumnName = "UserID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Users users;

    public Usertask() {
    }

    public Usertask(UsertaskPK usertaskPK) {
        this.usertaskPK = usertaskPK;
    }

    public Usertask(int userID, int taskID) {
        this.usertaskPK = new UsertaskPK(userID, taskID);
    }

    public UsertaskPK getUsertaskPK() {
        return usertaskPK;
    }

    public void setUsertaskPK(UsertaskPK usertaskPK) {
        this.usertaskPK = usertaskPK;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Tasks getTasks() {
        return tasks;
    }

    public void setTasks(Tasks tasks) {
        this.tasks = tasks;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usertaskPK != null ? usertaskPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usertask)) {
            return false;
        }
        Usertask other = (Usertask) object;
        if ((this.usertaskPK == null && other.usertaskPK != null) || (this.usertaskPK != null && !this.usertaskPK.equals(other.usertaskPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "projectplannerdbAPI.Usertask[ usertaskPK=" + usertaskPK + " ]";
    }
    
}
