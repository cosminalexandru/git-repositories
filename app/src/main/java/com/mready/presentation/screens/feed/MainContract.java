package com.mready.presentation.screens.feed;

import com.mready.models.PublicRepositories;

public interface MainContract {
    interface View{

        void showRepos(PublicRepositories result);

        void showError(String message);
    }

    interface Presenter{

        void getRepos(int currentPage);
    }

}
