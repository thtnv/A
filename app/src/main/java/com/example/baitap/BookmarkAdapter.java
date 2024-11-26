package com.example.baitap;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BookmarkAdapter extends RecyclerView.Adapter<BookmarkAdapter.ViewHolder> {

    private List<BookmarkItem> data;

    public BookmarkAdapter(List<BookmarkItem> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bookmark, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BookmarkItem item = data.get(position);
        holder.tvTitle.setText(item.getTitle());
        holder.tvDescription.setText(item.getDescription());
        holder.ivProductImage.setImageResource(item.getImageResId());

        // Xử lý sự kiện Buy Now
        holder.btnBuyNow.setOnClickListener(v -> {
            // Thực hiện hành động mua
        });

        // Xử lý sự kiện Delete
        holder.btnDelete.setOnClickListener(v -> {
            data.remove(holder.getAdapterPosition()); // Lấy vị trí chính xác
            notifyItemRemoved(holder.getAdapterPosition());

            // Kiểm tra nếu danh sách trống, thông báo giao diện
            if (data.isEmpty()) {
                notifyDataSetChanged(); // Cập nhật lại RecyclerView để hiển thị trạng thái trống
            }
        });
        if (BookmarkItem.isSaved()) {
            holder.saveIcon.setImageResource(R.drawable.bookmark_circle_filled);
        } else {
            holder.saveIcon.setImageResource(R.drawable.bookmark_circle);
        }

        holder.saveIcon.setOnClickListener(v -> {

            ObjectAnimator rotationOut = ObjectAnimator.ofFloat(holder.saveIcon, "rotationX", 0f, 90f);
            ObjectAnimator rotationIn = ObjectAnimator.ofFloat(holder.saveIcon, "rotationX", -90f, 0f);

            rotationOut.setDuration(150);
            rotationIn.setDuration(150);

            rotationOut.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    // Chuyển đổi trạng thái lưu
                    BookmarkItem.setSaved(!BookmarkItem.isSaved());

                    // Cập nhật hình ảnh khi xoay xong một nửa
                    if (BookmarkItem.isSaved()) {
                        holder.saveIcon.setImageResource(R.drawable.bookmark_circle_filled);
                    } else {
                        holder.saveIcon.setImageResource(R.drawable.bookmark_circle);
                    }
                    // Bắt đầu xoay ngược lại
                    rotationIn.start();
                }
            });

            // Bắt đầu hiệu ứng xoay
            rotationOut.start();
        });
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        TextView tvDescription;
        ImageView ivProductImage;
        Button btnBuyNow;
        ImageView btnDelete;
        ImageView saveIcon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            ivProductImage = itemView.findViewById(R.id.ivProductImage);
            btnBuyNow = itemView.findViewById(R.id.btnBuyNow);
            btnDelete = itemView.findViewById(R.id.btnDelete);
            saveIcon = itemView.findViewById(R.id.save_icon);
        }
    }
}

