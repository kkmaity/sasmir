package com.netflairs.sasmirapp.restService

import com.netflairs.sasmirapp.constants.Constants
import com.netflairs.sasmirapp.model.LoginResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface RestInterface {
    @GET("vkws/services.php?service=InspectorLogin")
    fun login(@Query("username") username: String, @Query("password") password: String): Call<LoginResponse>

    /*@FormUrlEncoded
    @POST("api/v1/validateOTP")
    Call<ResponseBody> validateOTP(@FieldMap Map<String, String> params);*/


    /*
    //============ No Authorization===============

    .antMatchers("/api/v1/login").permitAll()
        .antMatchers("/api/v1/register").permitAll()
        .antMatchers("/api/v1/forgotpassword_sendotp").permitAll()
        .antMatchers("/api/v1/setpassword").permitAll()
        .antMatchers("/api/v1/resend_otp").permitAll()
    */


    @FormUrlEncoded
    @POST("api/v1/validateOTP")
    fun validateOTP(
        @Header("Authorization") token: String, @Field("user_id") user_id: Int?,
        @Field("otp") otp: String
    ): Call<ResponseBody>


    @FormUrlEncoded
    @POST("api/v1/getGreetingsCategory")
    fun getGreetingsCategory(@Header("Authorization") token: String, @FieldMap params: Map<String, Long>): Call<ResponseBody>

    @FormUrlEncoded
    @POST("api/v1/getGreetings")
    fun getGreetings(@Header("Authorization") token: String, @FieldMap params: Map<String, Long>): Call<ResponseBody>

    @FormUrlEncoded
    @POST("api/v1/subcription")
    fun getSubcription(@Header("Authorization") token: String, @FieldMap params: Map<String, Int>): Call<ResponseBody>

    @FormUrlEncoded
    @POST("api/v1/subscription_status")
    fun subscription_status(@Header("Authorization") token: String, @FieldMap params: Map<String, Int>): Call<ResponseBody>

    @FormUrlEncoded
    @POST("api/v1/purchase")
    fun purchase(
        @Header("Authorization") token: String, @Field("user_id") user_id: Int?, @Field("subcription_id") subcription: Int?,
        @Field("paymentresponse") paymentresponse: String
    ): Call<ResponseBody>

    @FormUrlEncoded
    @POST("api/v1/redeem")
    fun redeem(
        @Header("Authorization") token: String,
        @Field("user_id") user_id: Int?,
        @Field("value") subcription_id: Int?,
        @Field("response") response: String,
        @Field("is_kyc_verified") is_kyc_verified: Boolean?,
        @Field("mobile") mobileNumber: String
    ): Call<ResponseBody>

    @FormUrlEncoded
    @POST("api/v1/resetpassword")
    fun resetpassword(
        @Header("Authorization") token: String,
        @Field("user_id") user_id: Int?,
        @Field("newpassword") newpassword: String,
        @Field("oldpassword") oldpassword: String
    ): Call<ResponseBody>

    @FormUrlEncoded
    @POST("api/v1/forgotpassword_sendotp")
    fun forgotpassword_sendotp(@Field("phone") phone: String): Call<ResponseBody>

    @FormUrlEncoded
    @POST("api/v1/resend_otp")
    fun resend_otp(@Field("phone") phone: String): Call<ResponseBody>


    @Multipart
    @POST("api/v1/addOrEditBusinessCard")
    fun addOrEditBusinessCard(
        @Header("Authorization") token: String,
        @Part("id") id: RequestBody,
        @Part("user_id") user_id: RequestBody,
        @Part("templet_id") templet_id: RequestBody,
        @Part("company_name") company_name: RequestBody,
        @Part("tag_line") tag_line: RequestBody,
        @Part("address") address: RequestBody,
        @Part("website") website: RequestBody,
        @Part("email") email: RequestBody,
        @Part("phone") phone: RequestBody,
        @Part("name") name: RequestBody,
        @Part("designation") designation: RequestBody,
        @Part file: MultipartBody.Part
    ): Call<ResponseBody>


    @FormUrlEncoded
    @POST("api/v1/app_info")
    fun app_info(@Header("Authorization") token: String, @FieldMap params: Map<String, Long>): Call<ResponseBody>


    @Multipart
    @POST("api/v1/resume_add_or_edit")
    fun saveEditResume(
        @Header("Authorization") token: String,
        @Part("id") id: RequestBody,
        @Part("user_id") user_id: RequestBody,
        @Part("templet_id") templet_id: RequestBody,
        @Part("resume") resume: RequestBody,
        @Part("resume_name") resume_name: RequestBody,
        @Part file: MultipartBody.Part
    ): Call<ResponseBody>

    // http://18.221.29.177:8080/quizapp/api/v1/cut_cut
    @Multipart
    @POST("api/v1/cut_cut")
    fun cut_cut(@Header("Authorization") token: String, @Part file: MultipartBody.Part): Call<ResponseBody>

    companion object {
        //String BASE_URL = "http://203.163.248.214:1350/api/";
        val BASE_URL = Constants.BASE_URL
    }


}
