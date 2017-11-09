package xal.cn.com.kaishu_story.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import xal.cn.com.kaishu_story.R;
import xal.cn.com.kaishu_story.model.biz.entity.Taletell_list_bean;


/**
 * Created by lenovo on 2017/10/31.
 */

public class List_recycler_Adapter2 extends RecyclerView.Adapter<List_recycler_Adapter2.ViewHolder> {

        private Context context;
        private  List<Taletell_list_bean.ResultBean.ListBean.ContentBean> content;
    public List_recycler_Adapter2(Context context, List<Taletell_list_bean.ResultBean.ListBean.ContentBean> content) {
        this.context=context;
        this.content=content;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = View.inflate(context, R.layout.tale_item_grid_item2, null);
        ViewHolder holder = new ViewHolder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
            if ((content.get(position+1).getContenttype()).equals("ablum")) {
                holder.tale_title.setText(content.get(position+1 ).getAblum().getAblumname());
                holder.tale_content.setText(content.get(position+1 ).getAblum().getSubhead());
                if ((content.get(position+1).getAblum().getFeetype()).equals("00")) {
                    holder.price.setVisibility(View.GONE);
                } else if ((content.get(position+1).getAblum().getFeetype()).equals("01")) {
                    holder.price.setText(content.get(position+1).getAblum().getProduct().getShowprice() + "元");
                }
                Glide.with(context).load(content.get(position+1 ).getCoverurl()).into(holder.item_img);
            } else if ((content.get(position+1).getContenttype()).equals("story")) {
                holder.tale_title.setText(content.get(position+1 ).getStory().getStoryname());
                holder.tale_content.setText(content.get(position+1).getStory().getSubhead());
                Glide.with(context).load(content.get(position+1 ).getCoverurl()).into(holder.item_img);
                if((content.get(position+1).getStory().getFeetype()).equals("00")){
                    holder.price.setVisibility(View.GONE);
                }else if((content.get(position+1).getStory().getFeetype()).equals("01")){
                    holder.price.setText(content.get(position+1).getStory().getProduct().getShowprice()+"元");
                }
//                setText(content.get(position ).getAblum().getProduct().getShowprice()+"元");
            }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linsern.onclick(position);

            }
        });


    }
    public void setOnClickLinser(Linsern linsers){
        this.linsern =linsers;
    }

    @Override
    public int getItemCount() {
        return content.size()-1;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView item_img;
        public TextView tale_title;
        public TextView tale_content;
        public TextView price;

        public ViewHolder(View itemView) {
            super(itemView);
            item_img = (ImageView) itemView.findViewById(R.id.item_img);
            tale_title = (TextView) itemView.findViewById(R.id.tale_title);
            tale_content = (TextView) itemView.findViewById(R.id.tale_content);
            price = (TextView) itemView.findViewById(R.id.price);
        }
    }


    Linsern linsern;
    public interface Linsern{
        void onclick(int position);
    }

}
