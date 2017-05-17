package xyz.tonimartinez.workshop.app.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import xyz.tonimartinez.workshop.R;
import xyz.tonimartinez.workshop.domain.model.Android;

/**
 * Created by Toni Martinez on 2/12/15.
 * toni.martinez.carballo@gmail.com
 */
public class AndroidsAdapter extends RecyclerView.Adapter<AndroidsAdapter.ContactViewHolder> {

    public interface OnItemClickListener {
        void onClick(Android item);
    }

    private List<Android> mItemList;

    private OnItemClickListener mItemClickListener;

    public AndroidsAdapter(List<Android> items) {
        this.mItemList = items;
    }

    public void setOnItemClickListener(OnItemClickListener itemClickListener) {
        this.mItemClickListener = itemClickListener;
    }

    public Android getItem(int position) {
        return mItemList.get(position);
    }

    public void clear() {
        mItemList.clear();
    }

    public void addAll(List<Android> items) {
        mItemList.addAll(items);
        notifyDataSetChanged();
    }

    @Override
    public ContactViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.android_list_item, parent, false);
        return new ContactViewHolder(v);
    }

    @Override
    public void onBindViewHolder(AndroidsAdapter.ContactViewHolder holder, int position) {
        holder.render(mItemList.get(position));
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }


    public class ContactViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @Bind(R.id.logo) protected ImageView mImageIV;
        @Bind(R.id.name) protected TextView mNameTV;

        public ContactViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (mItemClickListener!=null) {
                mItemClickListener.onClick(getItem(getAdapterPosition()));
            }
        }

        public void render(Android Android) {
            mNameTV.setText(Android.getCodeName());

            Picasso.with(mImageIV.getContext())
                    .load(Android.getLogo())
                    .fit()
                    .centerCrop()
                    .into(mImageIV);
        }
    }

}
