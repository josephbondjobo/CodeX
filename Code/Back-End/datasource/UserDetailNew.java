package cos301.datasource;

import cos301.util.NumericUtil;

public class UserDetailNew {

    private NumericUtil numericutil = new NumericUtil();

    private int idUserDetail = 0;
    private int idCustomerDetail = 0;
    private int idLoginAdd = 0;
    private String userCode = "";
    private String systemUser = "";
    private String userStatus = "";
    private String serverIp = "";
    private String serverUsername = "";
    private String serverPassword = "";
    private String applicationSerialNo = "";
    private String userName = "";
    private String userPassword = "";
    private String serverType = "";
    private String userTelNo = "";
    private String userEmail = "";
    private String userType = "";
    private int wsRepIdSupplier = 0;
    private String appName = "";
    private String appVersion = "";
    private int idUserMessage = 0;
    private int idEmergencyMessage = 0;
    private String contactName = "";
    private int idCloudlog = 0;
//    private String cloudUserName = "";
    private int idBranch = 0;
    private String alfaPharmRepCode = "";
    private String userLevel = "";
    private String lastChanged = "";
    private int flag = 0;



    //----------------------------------------------------numericutil.str2Int(
    /**
     * @return the idUserDetail
     */
    public final int getIdUserDetail() {
        return idUserDetail;
    }
    /**
     * @param idUserDetail the idUserDetail to set
     */
    public final void setIdUserDetail(final int pIdUserDetail) {
        this.idUserDetail = pIdUserDetail;
    }
    public final void setIdUserDetail(final String pIdUserDetail) {
        this.idUserDetail = numericutil.str2Int(pIdUserDetail);
    }
    /**
     * @return the idCustomerDetail
     */
    public final int getIdCustomerDetail() {
        return idCustomerDetail;
    }
    /**
     * @param idCustomerDetail the idCustomerDetail to set
     */
    public final void setIdCustomerDetail(final int pIdCustomerDetail) {
        this.idCustomerDetail = pIdCustomerDetail;
    }
    public final void setIdCustomerDetail(final String pIdCustomerDetail) {
        this.idCustomerDetail = numericutil.str2Int(pIdCustomerDetail);
    }
    /**
     * @return the idLoginAdd
     */
    public final int getIdLoginAdd() {
        return idLoginAdd;
    }
    /**
     * @param idLoginAdd the idLoginAdd to set
     */
    public final void setIdLoginAdd(final int pIdLoginAdd) {
        this.idLoginAdd = pIdLoginAdd;
    }
    public final void setIdLoginAdd(final String pIdLoginAdd) {
        this.idLoginAdd = numericutil.str2Int(pIdLoginAdd);
    }
    /**
     * @return the userCode
     */
    public final String getUserCode() {
        return userCode;
    }
    /**
     * @param userCode the userCode to set
     */
    public final void setUserCode(final String pUserCode) {
        this.userCode = pUserCode;
    }
    /**
     * @return the user
     */
    public final String getSystemUser() {
        return systemUser;
    }
    /**
     * @param systemUser the user to set
     */
    public final void setSystemUser(final String pSystemUser) {
        this.systemUser = pSystemUser;
    }
    /**
     * @return the userStatus
     */
    public final String getUserStatus() {
        return userStatus;
    }
    /**
     * @param userStatus the userStatus to set
     */
    public final void setUserStatus(final String pUserStatus) {
        this.userStatus = pUserStatus;
    }
    /**
     * @return the serverIp
     */
    public final String getServerIp() {
        return serverIp;
    }
    /**
     * @param serverIp the serverIp to set
     */
    public final void setServerIp(final String pServerIp) {
        this.serverIp = pServerIp;
    }
    /**
     * @return the serverUsername
     */
    public final String getServerUsername() {
        return serverUsername;
    }
    /**
     * @param serverUsername the serverUsername to set
     */
    public final void setServerUsername(final String pServerUsername) {
        this.serverUsername = pServerUsername;
    }
    /**
     * @return the serverPassword
     */
    public final String getServerPassword() {
        return serverPassword;
    }
    /**
     * @param serverPassword the serverPassword to set
     */
    public final void setServerPassword(final String pServerPassword) {
        this.serverPassword = pServerPassword;
    }
    /**
     * @return the applicationSerialNo
     */
    public final String getApplicationSerialNo() {
        return applicationSerialNo;
    }
    /**
     * @param applicationSerialNo the applicationSerialNo to set
     */
    public final void setApplicationSerialNo(final String pApplicationSerialNo) {
        this.applicationSerialNo = pApplicationSerialNo;
    }
    /**
     * @return the userName
     */
    public final String getUserName() {
        return userName;
    }
    /**
     * @param userName the userName to set
     */
    public final void setUserName(final String pUserName) {
        this.userName = pUserName;
    }
    /**
     * @return the userPassword
     */
    public final String getUserPassword() {
        return userPassword;
    }
    /**
     * @param userPassword the userPassword to set
     */
    public final void setUserPassword(final String pUserPassword) {
        this.userPassword = pUserPassword;
    }
    /**
     * @return the serverType
     */
    public final String getServerType() {
        return serverType;
    }
    /**
     * @param serverType the serverType to set
     */
    public final void setServerType(final String pServerType) {
        this.serverType = pServerType;
    }
    /**
     * @return the userTelNo
     */
    public final String getUserTelNo() {
        if(userTelNo == null){
            userTelNo = "";
        }
        return userTelNo;
    }
    /**
     * @param userTelNo the userTelNo to set
     */
    public final void setUserTelNo(final String pUserTelNo) {
        this.userTelNo = pUserTelNo;
    }
    /**
     * @return the userEmail
     */
    public final String getUserEmail() {
        return userEmail;
    }
    /**
     * @param userEmail the userEmail to set
     */
    public final void setUserEmail(final String pUserEmail) {
        this.userEmail = pUserEmail;
    }
    /**
     * @return the userType
     */
    public final String getUserType() {
        return userType;
    }
    /**
     * @param userType the userType to set
     */
    public final void setUserType(final String pUserType) {
        this.userType = pUserType;
    }
    /**
     * @return the wsRepIdSupplier
     */
    public final int getWsRepIdSupplier() {
        return wsRepIdSupplier;
    }
    /**
     * @param wsRepIdSupplier the wsRepIdSupplier to set
     */
    public final void setWsRepIdSupplier(final int pWsRepIdSupplier) {
        this.wsRepIdSupplier = pWsRepIdSupplier;
    }
    public final void setWsRepIdSupplier(final String pWsRepIdSupplier) {
        this.wsRepIdSupplier = numericutil.str2Int(pWsRepIdSupplier);
    }
    /**
     * @return the appName
     */
    public final String getAppName() {
        return appName;
    }
    /**
     * @param appName the appName to set
     */
    public final void setAppName(final String pAppName) {
        this.appName = pAppName;
    }
    /**
     * @return the appVersion
     */
    public final String getAppVersion() {
        if (appVersion == null) {
            appVersion = appName;
        }
        return appVersion;
    }
    /**
     * @param appVersion the appVersion to set
     */
    public final void setAppVersion(final String pAppVersion) {
        this.appVersion = pAppVersion;
    }
    /**
     * @return the idUserMessage
     */
    public final int getIdUserMessage() {
        return idUserMessage;
    }
    /**
     * @param idUserMessage the idUserMessage to set
     */
    public final void setIdUserMessage(final int pIdUserMessage) {
        this.idUserMessage = pIdUserMessage;
    }
    public final void setIdUserMessage(final String pIdUserMessage) {
        this.idUserMessage = numericutil.str2Int(pIdUserMessage);
    }
    /**
     * @return the idEmergencyMessage
     */
    public final int getIdEmergencyMessage() {
        return idEmergencyMessage;
    }
    /**
     * @param idEmergencyMessage the idEmergencyMessage to set
     */
    public final void setIdEmergencyMessage(final int pIdEmergencyMessage) {
        this.idEmergencyMessage = pIdEmergencyMessage;
    }
    public final void setIdEmergencyMessage(final String pIdEmergencyMessage) {
        this.idEmergencyMessage = numericutil.str2Int(pIdEmergencyMessage);
    }
    /**
     * @return the contactName
     */
    public final String getContactName() {
        if(contactName == null){
            contactName = "";
        }
        return contactName;
    }
    /**
     * @param contactName the contactName to set
     */
    public final void setContactName(final String pContactName) {
        this.contactName = pContactName;
    }
    /**
     * @return the idcloudlog
     */
    public final int getIdCloudlog() {
        return idCloudlog;
    }
    /**
     * @param idcloudlog the idcloudlog to set
     */
    public final void setIdCloudlog(final int pIdCloudlog) {
        this.idCloudlog = pIdCloudlog;
    }

    /**
     * @return the cloudUserName
     */
 //   public final String getCloudUserName() {
 //       return cloudUserName;
 //   }
    /**
     * @param cloudUserName the cloudUserName to set
     */
 //   public final void setCloudUserName(String cloudUserName) {
  //      this.cloudUserName = cloudUserName;
  //  }

    /**
     * @return the idBranch
     */
    public final int getIdBranch() {
        return idBranch;
    }
    /**
     * @param idBranch the idBranch to set
     */
    public final void setIdBranch(int idBranch) {
        this.idBranch = idBranch;
    }
    /**
     * @return the alfaPharmRepCode
     */
    public final String getAlfaPharmRepCode() {
        if (alfaPharmRepCode == null) {
            alfaPharmRepCode = "";
        }
        return alfaPharmRepCode;
    }
    /**
     * @param alfaPharmRepCode the alfaPharmRepCode to set
     */
    public final void setAlfaPharmRepCode(String alfaPharmRepCode) {
        this.alfaPharmRepCode = alfaPharmRepCode;
    }
    /**
     * @return the userLevel
     */
    public final String getUserLevel() {
        if (userLevel == null || userLevel.trim().equals("")) {
            userLevel = "U";
        }
        return userLevel;
    }
    /**
     * @param userLevel the userLevel to set
     */
    public final void setUserLevel(String userLevel) {
        this.userLevel = userLevel;
    }
    /**
     * @return the lastChanged
     */
    public final String getLastChanged() {
        return lastChanged;
    }
    /**
     * @param lastChanged the lastChanged to set
     */
    public final void setLastChanged(String lastChanged) {
        this.lastChanged = lastChanged;
    }
    /**
     * @return the flag
     */
    public final int getFlag() {
        return flag;
    }
    /**
     * @param flag
     */
    public final void setFlag(int pFlag) {
        this.flag = pFlag;
    }

}
