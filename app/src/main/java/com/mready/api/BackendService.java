package com.mready.api;

import com.mready.models.PublicRepositories;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BackendService {
    @GET("/search/repositories?q=ios+language:swift&sort=stars&order=desc")
    Call<PublicRepositories> getRepositories();
}
