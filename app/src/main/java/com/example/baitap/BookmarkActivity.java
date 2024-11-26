package com.example.baitap;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BookmarkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookmark);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Hiển thị mặc định HomeFragment khi mở app
        loadFragment(new HomeFragment()); // Thay "HomeFragment" bằng fragment bạn muốn hiển thị mặc định.

        // Xử lý sự kiện khi người dùng nhấn vào icon trong BottomNavigationView
        bottomNavigationView.setOnItemSelectedListener(item -> {
            Fragment selectedFragment = null;

            // Xác định fragment nào cần hiển thị
            if (item.getItemId() == R.id.item_home) {
                selectedFragment = new HomeFragment();
            } else if (item.getItemId() == R.id.item_library) {
                selectedFragment = new LibraryFragment();
            } else if (item.getItemId() == R.id.item_bookmark) {
                selectedFragment = new BookmarkFragment();
            } else if (item.getItemId() == R.id.item_profile) {
                selectedFragment = new ProfileFragment();
            } else if (item.getItemId() == R.id.item_search) {
                selectedFragment = new SearchFragment();
            }


            // Load fragment nếu không null
            if (selectedFragment != null) {
                loadFragment(selectedFragment);
                return true;
            }
            return false;
        });
    }

    // Hàm load fragment
    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.frameLayout, fragment) // Thay thế nội dung của FrameLayout
                .commit();
    }
}
