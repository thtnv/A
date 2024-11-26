package com.example.baitap;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class BookmarkFragment extends Fragment {

    private RecyclerView recyclerView;

    public BookmarkFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bookmark, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Dummy data
        List<BookmarkItem> data = new ArrayList<>();
        data.add(new BookmarkItem("Product 1", "Description 1", R.drawable.image_product1));
        data.add(new BookmarkItem("Product 2", "Description 2", R.drawable.image_product2));
        data.add(new BookmarkItem("Product 3", "Description 3", R.drawable.image_product3));
        data.add(new BookmarkItem("Product 4", "Description 4", R.drawable.image_product1));
        data.add(new BookmarkItem("Product 5", "Description 5", R.drawable.image_product2));
        data.add(new BookmarkItem("Product 6", "Description 6", R.drawable.image_product3));
        data.add(new BookmarkItem("Product 7", "Description 7", R.drawable.image_product1));
        data.add(new BookmarkItem("Product 8", "Description 8", R.drawable.image_product2));
        data.add(new BookmarkItem("Product 9", "Description 9", R.drawable.image_product3));

        BookmarkAdapter adapter = new BookmarkAdapter(data);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
