package com.mready.presentation.screens.feed;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mready.R;
import com.mready.models.Item;

public class ViewHolderRepo extends RecyclerView.ViewHolder {
    private TextView repoName;
    private TextView repoStars;

    public ViewHolderRepo(@NonNull View itemView) {
        super(itemView);
        repoName = itemView.findViewById(R.id.repo_name);
        repoStars = itemView.findViewById(R.id.repo_stars);
    }

    void bind(final Item item, final OnRepoClickListener listener){
        repoName.setText(item.getName());
        repoStars.setText(item.getStargazersCount().toString());
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onRepoClick(item);
            }
        });
    }
}
