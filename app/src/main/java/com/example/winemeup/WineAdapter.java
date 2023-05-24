package com.example.winemeup;

import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

//import com.github.ivbaranov.mli.MaterialLetterIcon;

import java.util.List;
import java.util.Locale;
import java.util.Random;

import static com.example.winemeup.Utils.searchString;

public class WineAdapter extends RecyclerView.Adapter<WineAdapter.ViewHolder>{

    private Context c;
    private int mBackground;
    private int[] mMaterialColors;
    public List<Wine> wines;

    interface ItemClickListener {
        void onItemClick(int pos);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements
            View.OnClickListener {
        private final TextView mdomainTxt, mPrice,mDish;
        private final ImageView mImageWine;
        private ItemClickListener itemClickListener;

        ViewHolder(View itemView) {
            super(itemView);
            mDish = itemView.findViewById(R.id.mDish);
            mdomainTxt = itemView.findViewById(R.id.mdomainTxt); //nameTxt mNameTxt
            mImageWine = itemView.findViewById(R.id.mImageWine);//mDescriptionTxt
            mPrice = itemView.findViewById(R.id.mPrice);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            this.itemClickListener.onItemClick(this.getLayoutPosition());
        }

        void setItemClickListener(ItemClickListener itemClickListener) {
            this.itemClickListener = itemClickListener;
        }
    }

    public WineAdapter(List<Wine> wines) {
        this.wines = wines;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        this.c = parent.getContext();
        View view = LayoutInflater.from(c).inflate(R.layout.wine_list_item, parent, false);
        view.setBackgroundResource(mBackground);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //get current scientist
        final Wine s = wines.get(position);

        //bind data to widgets
        holder.nameTxt.setText(s.getName());
        holder.mDescriptionTxt.setText(s.getDescription());
        holder.galaxyTxt.setText(s.getGalaxy());
        holder.mIcon.setInitials(true);
        holder.mIcon.setInitialsNumber(2);
        holder.mIcon.setLetterSize(25);
        holder.mIcon.setShapeColor(mMaterialColors[new Random().nextInt(
                mMaterialColors.length)]);
        holder.mIcon.setLetter(s.getName());

        if(position % 2 == 0){
            holder.itemView.setBackgroundColor(Color.parseColor("#efefef"));
        }

        //get name and galaxy
        String name = s.getName().toLowerCase(Locale.getDefault());

        //highlight name text while searching
        if (name.contains(searchString) && !(searchString.isEmpty())) {
            int startPos = name.indexOf(searchString);
            int endPos = startPos + searchString.length();

            Spannable spanString = Spannable.Factory.getInstance().
                    newSpannable(holder.nameTxt.getText());
            spanString.setSpan(new ForegroundColorSpan(Color.RED), startPos, endPos,
                    Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            holder.nameTxt.setText(spanString);
        } else {
            //Utils.show(ctx, "Search string empty");
        }

        //open detailactivity when clicked
        holder.setItemClickListener(pos -> Utils.sendScientistToActivity(c, s,
                DetailActivity.class));
    }

    @Override
    public int getItemCount() {
        return scientists.size();
    }

}
//end
