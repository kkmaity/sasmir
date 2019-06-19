package com.netflairs.sasmirapp.constants


import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

/**
 * Created by Sumanta on 12/23/2015.
 */
class Preference(context: Context) {

    private var context: Context? = null
    val prefName = "Eutigo"
    private val profileImageURL: String? = null
    private val appName: String? = null

    var userId: String
        get() = getString("UserId", null)
        set(UserId) = setString("UserId", UserId)

    var userName: String
        get() = getString("getUserName", null)
        set(UserName) = setString("getUserName", UserName)

    var paymetVerified: String
        get() = getString("setPaymetVerified", null)
        set(isVerified) = setString("setPaymetVerified", isVerified)

    var accessToken: String
        get() = getString("AccessToken", null)
        set(AccessToken) = setString("AccessToken", AccessToken)

    var isProUser: String
        get() = getString("proUser", "")
        set(ispro) = setString("proUser", ispro)

    var name: String
        get() = getString("Name", "")
        set(Name) = setString("Name", Name)

    var referralCode: String
        get() = getString("referralCode", "")
        set(Name) = setString("referralCode", Name)

    var installreferr: String
        get() = getString("setInstallreferr", "")
        set(Name) = setString("setInstallreferr", Name)

    val theme: String
        get() = getString("theme", "")

    var email: String
        get() = getString("Email", "")
        set(Email) = setString("Email", Email)

    var recipientID: String
        get() = getString("rec_id", "")
        set(Email) = setString("rec_id", Email)

    var userType: String
        get() = getString("usertype", "")
        set(UserType) = setString("usertype", UserType)

    var phone: String
        get() = getString("Phone", "")
        set(Phone) = setString("Phone", Phone)

    var isAdmin: String
        get() = getString("isAdmin", "")
        set(Phone) = setString("isAdmin", Phone)

    var profImage: String
        get() = getString("ProfImage", "")
        set(ProfImage) = setString("ProfImage", ProfImage)

    var userStatus: String
        get() = getString("setUserStatus", "")
        set(setUserStatus) = setString("UserStatus", setUserStatus)

    var lat: String
        get() = getString("lat", "")
        set(lat) = setString("lat", lat)

    var lng: String
        get() = getString("lng", "")
        set(lng) = setString("lng", lng)

    var deviceToken: String
        get() = getString("DeviceId", "")
        set(DeviceToken) = setString("DeviceId", DeviceToken)

    val isOTPVerified: Boolean
        get() = getBoolean("isOtpVerified")

    var gender: String
        get() = getString("gender", "")
        set(gender) = setString("gender", gender)

    var age: String
        get() = getString("age", "")
        set(age) = setString("age", age)

    var weightInKg: String
        get() = getString("weightInKg", "")
        set(weightInKg) = setString("weightInKg", weightInKg)

    var weightInLbs: String
        get() = getString("weightInLbs", "")
        set(weightInLbs) = setString("weightInLbs", weightInLbs)

    var heightInCm: String
        get() = getString("heightInCm", "")
        set(heightInCm) = setString("heightInCm", heightInCm)

    var heightInFt: String
        get() = getString("heightInFt", "")
        set(heightInFt) = setString("heightInFt", heightInFt)

    var bodyFatPercentage: String
        get() = getString("bodyfat", "")
        set(bodyfat) = setString("bodyfat", bodyfat)

    var targetBodyFatPercentage: String
        get() = getString("targetfat", "")
        set(targetfat) = setString("targetfat", targetfat)

    var goal: String
        get() = getString("getGoal", "")
        set(goal) = setString("getGoal", goal)

    var workoutList: String
        get() = getString("workoutList", "")
        set(workList) = setString("workoutList", workList)

    var isPremiumMenber: Boolean
        get() = getBoolean("isPremiumMenber")
        set(status) = setBoolean("isPremiumMenber", status)

    var contactInfo: String
        get() = getString("ContactInfo", "")
        set(ContactInfo) = setString("ContactInfo", ContactInfo)

    var academic: String
        get() = getString("Academic", "")
        set(Academic) = setString("Academic", Academic)

    var resumeName: String
        get() = getString("ResumeName", "")
        set(ResumeName) = setString("ResumeName", ResumeName)

    var templetId: String
        get() = getString("TempletId", "")
        set(TempletId) = setString("TempletId", TempletId)


    var resumeBuilder: String
        get() = getString("ResumeBuilder", "")
        set(ResumeBuilder) = setString("ResumeBuilder", ResumeBuilder)

    var workingExp: String
        get() = getString("WorkingExp", "")
        set(WorkingExp) = setString("WorkingExp", WorkingExp)

    var project: String
        get() = getString("Project", "")
        set(Project) = setString("Project", Project)

    var reference: String
        get() = getString("Reference", "")
        set(Reference) = setString("Reference", Reference)

    var careerObj: String
        get() = getString("CareerObj", "")
        set(CareerObj) = setString("CareerObj", CareerObj)

    var coverLetter: String
        get() = getString("CoverLetter", "")
        set(CoverLetter) = setString("CoverLetter", CoverLetter)

    var skills: String
        get() = getString("Skills", "")
        set(Skills) = setString("Skills", Skills)

    var achievements: String
        get() = getString("Achievements", "")
        set(Achievements) = setString("Achievements", Achievements)

    var resumeImage: String
        get() = getString("ResumeImage", "")
        set(ResumeImage) = setString("ResumeImage", ResumeImage)

    var resumeId: String
        get() = getString("ResumeId", "")
        set(ResumeId) = setString("ResumeId", ResumeId)

    var appDownloadLink: String
        get() = getString("getAppDownloadLink", "")
        set(AppDownloadLink) = setString("getAppDownloadLink", AppDownloadLink)

    init {
        this.context = context
    }

    fun getString(key: String, def: String?): String {
        val prefs = PreferenceManager
            .getDefaultSharedPreferences(context)
        return prefs.getString(key, def)
    }

    fun setString(key: String, `val`: String) {
        val prefs = PreferenceManager
            .getDefaultSharedPreferences(context)
        val e = prefs.edit()
        e.putString(key, `val`)
        e.commit()
    }

    fun setBoolean(key: String, `val`: Boolean) {
        val prefs = PreferenceManager
            .getDefaultSharedPreferences(context)
        val e = prefs.edit()
        e.putBoolean(key, `val`)
        e.commit()
    }

    fun getBoolean(key: String): Boolean {
        val prefs = PreferenceManager
            .getDefaultSharedPreferences(context)
        return prefs.getBoolean(key, false)
    }


    fun clearData() {
        val prefs = PreferenceManager
            .getDefaultSharedPreferences(context)
        val e = prefs.edit()
        e.clear()
        e.commit()


    }

    fun setTheme(themeCode: Int) {
        setString("theme", "" + themeCode)
    }

    fun setOTPVerified(flag: Boolean?) {
        setBoolean("isOtpVerified", flag!!)
    }


    /*--ProviderState--*//*
    public void setProviderState(String ProviderState) {
        setString("ProviderState", ProviderState);
    }

    public String getProviderState() {
        return getString("ProviderState", "");
    }


    *//*--DeviceId--*//*
    public void setDeviceId(String DeviceId) {
        setString("DeviceId", DeviceId);
    }

    public String getDeviceId() {
        return getString("DeviceId", "");
    }


    *//*--Latitude--*//*
    public void setLatitude(Double Latitude) {
        setString("Latitude", String.valueOf(Latitude));
    }

    public Double getLatitude() {
//        return Double.parseDouble(getString("Latitude", "0.0"));
        String latitude = getString("Latitude", null);
        if (latitude != null) {
            return Double.parseDouble(latitude);
        }else{
            return null;
        }
    }

    *//*--Longitude--*//*
    public void setLongitude(Double Longitude) {
        setString("Longitude", String.valueOf(Longitude));
    }

    public Double getLongitude() {
        String longitude = getString("Longitude", null);
        if (longitude != null) {
            return Double.parseDouble(longitude);
        }else{
            return null;
        }
    }

    *//*--CustId--*//*
    public void setUserId(String UserId) {
        setString("UserId", UserId);
    }

    public String getUserId() {
        return getString("UserId", null);
    }
    public void setUserType(String UserId) {
        setString("user_type", UserId);
    }

    public String getUserType() {
        return getString("user_type", null);
    }



    public void setUserName(String UserId) {
        setString("username", UserId);
    }

    public String getUserName() {
        return getString("username", null);
    }

    public void setLoginType(String UserId) {
        setString("login_type", UserId);
    }

    public String getLoginType() {
        return getString("login_type", null);
    }


    *//*--SessionToken--*//*
    public void setSessionToken(String SessionToken) {
        setString("SessionToken", SessionToken);
    }

    public String getSessionToken() {
        return getString("SessionToken", null);
    }

    *//*--Email--*//*
    public void setEmail(String Email) {
        setString("Email", Email);
    }

    public String getEmail() {
        return getString("Email", "");
    }


    *//*--Name--*//*
    public void setName(String Name) {
        setString("Name", Name);
    }

    public String getName() {
        return getString("Name", "");
    }

    *//*CustAddress*//*
    public void setCustAddress(String CustAddress) {
        setString("CustAddress", CustAddress);
    }

    public String getCustAddress() {
        return getString("CustAddress", "");
    }

    *//*--CustDrivingLincese--*//*
    public void setCustDrivingLincese(String CustDrivingLincese) {
        setString("CustDrivingLincese", CustDrivingLincese);
    }

    public String getCustDrivingLincese() {
        return getString("CustDrivingLincese", "");
    }

    *//*--CustDrivingLincese--*//*
    public void setCustDrivingLinceseNo(String CustDrivingLinceseNo) {
        setString("CustDrivingLinceseNo", CustDrivingLinceseNo);
    }

    public String getCustDrivingLinceseNo() {
        return getString("CustDrivingLinceseNo", "");
    }


    *//*--CustImage--*//*
    public void setCustImage(String CustImage) {
        setString("CustImage", CustImage);
    }

    public String getCustImage() {
        return getString("CustImage", "");
    }

    *//*--CustPhNo--*//*
    public void setCustPhNo(String CustPhNo) {
        setString("CustPhNo", CustPhNo);
    }

    public String getCustPhNo() {
        return getString("CustPhNo", "");
    }

    *//*--SocialUser--*//*
    public void setIsSocialUser(String IsSocialUser) {
        setString("IsSocialUser", IsSocialUser);
    }

    public String getIsSocialUser() {
        return getString("IsSocialUser", "");
    }


    *//*--StartTime--*//*
    public void setStartTime(String StartTime) {
        setString("StartTime", StartTime);
    }

    public String getStartTime() {
        return getString("StartTime", "");
    }


    *//*--EndTime--*//*
    public void setEndTime(String EndTime) {
        setString("EndTime", EndTime);
    }

    public String getEndTime() {
        return getString("EndTime", "");
    }

    *//*--PinCode--*//*
    public void setPinCode(String PinCode) {
        setString("PinCode", PinCode);
    }

    public String getPinCode() {
        return getString("PinCode", "");
    }


    *//*--Date Of Birth--*//*
    public void setDOB(String DOB) {
        setString("DOB", DOB);
    }

    public String getDOB() {
        return getString("DOB", "");
    }


    *//*--Date Of Birth--*//*
    public void setPremiumMenber(boolean status) {
        setBoolean("HomeDelivery", status);
    }

    public boolean isPremiumMenber() {
        return getBoolean("HomeDelivery");
    }


    *//*--DeviceId--*//*
    public void setProfileImageURL(String profileImageURL) {
        setString("ImageURL", profileImageURL);
    }

    public String getProfileImageURL() {
        return getString("ImageURL", "");
    }

    public void setFullName(String volume) {
        setString("full_name", volume);
    }

    public String getFullName() {
        return getString("full_name", "");
    }
    public void setVolumeLavel(String volume) {
        setString("volume_level", volume);
    }

    public String getVolumeLavel() {
        return getString("volume_level", "");
    }


    public void setAppName(String appName) {
        setString("app_name", appName);
    }
    public String getAppName() {
        return getString("app_name", "");
    }

    public void setDeviceToken(String deviceToken) {
        setString("device_token", deviceToken);
    }
    public String getDeviceToken() {
        return getString("device_token", "");
    }*/
}

