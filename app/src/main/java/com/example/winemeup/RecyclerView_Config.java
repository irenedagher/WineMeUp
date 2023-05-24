package com.example.winemeup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Text;

import java.net.ContentHandler;

public class RecyclerView_Config {
    private Context mContext;
    private WinesAdapter mWinesAdapter;
    public void setConfig(RecyclerView recyclerView, Context context, List<Wine> wines, List<String> keys){
        mContext = context;
        mWinesAdapter = new WinesAdapter(wines, keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mWinesAdapter);
    }

    class WineItemView extends RecyclerView.ViewHolder {
        private TextView mColour;
        private TextView mCountry;
        private TextView mDescription;
        private TextView mNameDish;
        private TextView mDomain;
        private TextView mPrice;
        private TextView mRegion;
        private TextView mYear;

        private String key;

        public WineItemView(ViewGroup parent) {
            super(LayoutInflater.from(mContext).inflate(R.layout.wine_list_item, parent, false));

            mColour = (TextView) itemView.findViewById(R.id.colour_txtView);
            mCountry = (TextView) itemView.findViewById(R.id.country_txtView);
            mDescription = (TextView) itemView.findViewById(R.id.description_txtView);
            mNameDish = (TextView) itemView.findViewById(R.id.nameDish_txtView);
            mDomain = (TextView) itemView.findViewById(R.id.domain_txtView);
            mPrice = (TextView) itemView.findViewById(R.id.price_txtView);
            mRegion = (TextView) itemView.findViewById(R.id.region_txtView);
            mYear = (TextView) itemView.findViewById(R.id);
            //Missing PART !
        }
        public void bind(Wine wine, String key){
            mColour.setText(wine.getColour());
            mDescription.setText(wine.getDescription());
            mCountry.setText(wine.getCountry());
            this.key = key;
        }
    }
    class WinesAdapter extends RecyclerView.Adapter<WineItemView> {
        private List<Wine> mWineList;
        private List<String> mKeys;

        public WinesAdapter(List<Wine> mWineList, List<String> mKeys) {
            this.mWineList = mWineList;
            this.mKeys = mKeys;
        }

        @NonNull
        @Override
        public WineItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new WineItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull WineItemView holder, int position) {
            holder.bind(mWineList.get(position), mKeys.get(position));
        }

        @Override
        public int getItemCount() {
            return mWineList.size();
        }
    }
}
