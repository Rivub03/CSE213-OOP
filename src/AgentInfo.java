/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.Serializable;

/**
 *
 * @author bhatt
 */
public class AgentInfo implements Serializable {
    private String  agentId, agentName, agentEmail, agentContactNo, agentCompany;
    private Cast cast; 
    
   

    public AgentInfo(String agentId, String agentName, String agentEmail, String agentContactNo, String agentCompany) {
        this.agentId = agentId;
        this.agentName = agentName;
        this.agentEmail = agentEmail;
        this.agentContactNo = agentContactNo;
        this.agentCompany = agentCompany;
        this.cast = cast.getLoggedInCast();
    }

    public AgentInfo() {
    }
    
    public String getAgentId() {
        return agentId;
    }
    public void setAgentId(String agentId) { 
        this.agentId = agentId;
    }
    
    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public String getAgentEmail() {
        return agentEmail;
    }

    public void setAgentEmail(String agentEmail) {
        this.agentEmail = agentEmail;
    }

    public String getAgentContactNo() {
        return agentContactNo;
    }

    public void setAgentContactNo(String agentContactNo) {
        this.agentContactNo = agentContactNo;
    }

    public String getAgentCompany() {
        return agentCompany;
    }

    public void setAgentCompany(String agentCompany) {
        this.agentCompany = agentCompany;
    }

    @Override
    public String toString() {
        return "AgentInfo{" + "agentId=" + agentId + ", agentName=" + agentName + ", agentEmail=" + agentEmail + ", agentContactNo=" + agentContactNo + ", agentCompany=" + agentCompany + '}';
    }
    
}
