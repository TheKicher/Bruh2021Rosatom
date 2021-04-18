package com.hfad.bruh2021rosatom.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import com.hfad.bruh2021rosatom.model.ModelInternshipResponseRequest;
import com.hfad.bruh2021rosatom.model.ModelInternshipment;
import com.hfad.bruh2021rosatom.model.ModelJob;
import com.hfad.bruh2021rosatom.model.ModelJobResponseRequest;
import com.hfad.bruh2021rosatom.model.ModelResponseInternship;
import com.hfad.bruh2021rosatom.model.ModelResponseJob;
import com.hfad.bruh2021rosatom.model.ModelResume;


public interface Api {


    @GET("internships")
    Call<List<ModelInternshipment>> getInternshipments();

//    @GET("users/1")
//    Call<ModelResponseJob> getResponsesJob();

    @GET("users/1")
    Call<ModelResponseInternship> getResponseInternship();

    @GET("users/1")
    Call<ModelResume> getResume();

//    @POST("job_responses")
//    Call<Object> createJobResponse(@Body ModelJobResponseRequest model);

    @POST("internship_responses")
    Call<Object> createInternshipResponse(@Body ModelInternshipResponseRequest model);
}
