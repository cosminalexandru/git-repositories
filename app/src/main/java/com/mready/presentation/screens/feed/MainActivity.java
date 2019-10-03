package com.mready.presentation.screens.feed;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mready.R;
import com.mready.models.Item;
import com.mready.models.PublicRepositories;
import com.mready.presentation.screens.single_repo.SingleRepoActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View, OnRepoClickListener {

    private RecyclerView rvRepos;
    private RepoAdapter adapter;
    private MainPresenter presenter;
    private int currentPage = 0;
    private List<Item> repos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvRepos = findViewById(R.id.rvRepos);
        adapter = new RepoAdapter(this);
        presenter = new MainPresenter(this);
        rvRepos.setAdapter(adapter);
        rvRepos.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        presenter.getRepos(currentPage);

        rvRepos.addOnScrollListener(new PaginationListener(new LinearLayoutManager(this)) {
            @Override
            protected void loadMoreItems() {
                currentPage++;
                presenter.getRepos(currentPage);
            }

            @Override
            public boolean isLastPage() {
                return false;
            }

            @Override
            public boolean isLoading() {
                return false;
            }
        });
    }

    @Override
    public void onRepoClick(Item item) {
        startActivity(SingleRepoActivity.makeIntent(this, item));

    }

    @Override
    public void showRepos(PublicRepositories result) {
        repos.addAll(result.getItems());
        adapter.setItems(repos);
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();

    }
}
