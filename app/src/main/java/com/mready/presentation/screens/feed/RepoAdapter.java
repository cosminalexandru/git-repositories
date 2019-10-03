package com.mready.presentation.screens.feed;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mready.R;
import com.mready.models.Item;

import java.util.ArrayList;
import java.util.List;

public class RepoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Item> repos = new ArrayList<>();
    private OnRepoClickListener listener;

    public RepoAdapter(OnRepoClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.repository_item, parent, false);
        return new ViewHolderRepo(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ViewHolderRepo) holder).bind(repos.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return repos.size();
    }

    public void setItems(List<Item> repos) {
        this.repos = repos;
        notifyDataSetChanged();
    }
}
