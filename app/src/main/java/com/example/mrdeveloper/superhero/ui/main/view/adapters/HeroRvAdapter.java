package com.example.mrdeveloper.superhero.ui.main.view.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mrdeveloper.superhero.R;
import com.example.mrdeveloper.superhero.api.hero.Hero;
import com.example.mrdeveloper.superhero.inject.PerActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by Mr. Developer on 2/28/2018.
 */

@PerActivity
public class HeroRvAdapter extends RecyclerView.Adapter<HeroRvAdapter.MyViewHolder> {

    List<Hero> heroList = new ArrayList<>();
    Context context;

    @Inject
    public HeroRvAdapter(Context context) {
        this.context = context;
    }

    public void updateList(List<Hero> heroList) {
        this.heroList = heroList;
        notifyDataSetChanged();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_row, parent, false);
        return (new MyViewHolder(v));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Hero hero = heroList.get(position);

        holder.setName(hero.getName());
        holder.setRealName(hero.getRealname());
        holder.setTeam(hero.getTeam());
        holder.setAppearance(hero.getFirstappearance());
        holder.setBio(hero.getBio());
        holder.setThumbnail(hero.getImageurl());
    }

    @Override
    public int getItemCount() {
        return heroList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView realName;
        TextView team;
        TextView appearance;
        TextView bio;

        ImageView thumbnail;

        public MyViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name_desc);
            realName = itemView.findViewById(R.id.real_name_desc);
            team = itemView.findViewById(R.id.team_desc);
            appearance = itemView.findViewById(R.id.appearance_desc);
            bio = itemView.findViewById(R.id.bio_desc);

            thumbnail = itemView.findViewById(R.id.thumbnail_img);
        }

        public void setName(String name) {
            this.name.setText(name);
        }

        public void setRealName(String realName) {
            this.realName.setText(realName);
        }

        public void setTeam(String team) {
            this.team.setText(team);
        }

        public void setAppearance(String appearance) {
            this.appearance.setText(appearance);
        }

        public void setBio(String bio) {
            this.bio.setText(bio);
        }

        public void setThumbnail(String url) {
            Picasso.with(context)
                    .load(url)
                    .fit()
                    .centerCrop()
                    .into(thumbnail);
        }
    }
}
