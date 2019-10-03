package com.mready.presentation.screens.feed;

import com.mready.api.BackendService;
import com.mready.api.RetrofitInit;
import com.mready.models.PublicRepositories;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements MainContract.Presenter {
    private MainContract.View view;

    public MainPresenter(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void getRepos() {
        BackendService backendService = RetrofitInit.initRetrofit().create(BackendService.class);
        Call call = backendService.getRepositories();
         call.enqueue(new Callback() {
             @Override
             public void onResponse(Call call, Response response) {
                 if(response.body()!=null){
                     view.showRepos((PublicRepositories) response.body());
                 }
             }

             @Override
             public void onFailure(Call call, Throwable t) {
                 view.showError(t.getMessage());

             }
         });
    }
}
