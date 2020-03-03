package com.example.b_sitter;

import android.os.Bundle;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    FirebaseAuth mAuth;
    FirebaseFirestore mFirestore;
    private String status = "Admin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        mAuth = FirebaseAuth.getInstance();
//        FirebaseUser user = mAuth.getCurrentUser();
//
//        if (user != null){
//            String uid = user.getUid();
//            mFirestore.collection("Data").document(uid).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                @Override
//                public void onSuccess(DocumentSnapshot documentSnapshot) {
//                    CollectionReference data = mFirestore.collection("Data");
//                    Query q = data.whereEqualTo("status", true);
//
//                    if (status.equals("Majikan")) {
//                        mAppBarConfiguration = new AppBarConfiguration.Builder(
//                                R.id.nav_majikan_dashboard, R.id.nav_majikan_profile, R.id.nav_majikan_order,
//                                R.id.nav_majikan_chat, R.id.nav_majikan_wishlist, R.id.nav_majikan_logout)
//                                .setDrawerLayout(drawer)
//                                .build();
//                        navigationView.getMenu().clear();
//                        navigationView.inflateMenu(R.menu.activity_majikan_drawer);
//                        NavController navController = Navigation.findNavController(MainActivity.this, R.id.nav_host_fragment);
//                        navController.setGraph(R.navigation.mobile_navigation_majikan);
//                        NavigationUI.setupActionBarWithNavController(MainActivity.this, navController, mAppBarConfiguration);
//                        NavigationUI.setupWithNavController(navigationView, navController);
//                    } else if (status.equals("Penyalur")) {
//                        mAppBarConfiguration = new AppBarConfiguration.Builder(
//                                R.id.nav_penyalur_dashboard, R.id.nav_penyalur_profile, R.id.nav_penyalur_manage_order,
//                                R.id.nav_penyalur_manage_babysitter, R.id.nav_penyalur_chat, R.id.nav_penyalur_logout)
//                                .setDrawerLayout(drawer)
//                                .build();
//                        navigationView.getMenu().clear();
//                        navigationView.inflateMenu(R.menu.activity_penyalur_drawer);
//                        NavController navController = Navigation.findNavController(MainActivity.this, R.id.nav_host_fragment);
//                        navController.setGraph(R.navigation.mobile_navigation_penyalur);
//                        NavigationUI.setupActionBarWithNavController(MainActivity.this, navController, mAppBarConfiguration);
//                        NavigationUI.setupWithNavController(navigationView, navController);
//                    } else {
//                        mAppBarConfiguration = new AppBarConfiguration.Builder(
//                                R.id.nav_admin_verification, R.id.nav_admin_order_majikan, R.id.nav_admin_order_penyalur,
//                                R.id.nav_admin_logout)
//                                .setDrawerLayout(drawer)
//                                .build();
//                        navigationView.getMenu().clear();
//                        navigationView.inflateMenu(R.menu.activity_admin_drawer);
//                        NavController navController = Navigation.findNavController(MainActivity.this, R.id.nav_host_fragment);
//                        navController.setGraph(R.navigation.mobile_navigation_admin);
//                        NavigationUI.setupActionBarWithNavController(MainActivity.this, navController, mAppBarConfiguration);
//                        NavigationUI.setupWithNavController(navigationView, navController);
//                    }
//                }
//            });
//        }


        if (status.equals("Majikan")) {
            mAppBarConfiguration = new AppBarConfiguration.Builder(
                    R.id.nav_majikan_dashboard, R.id.nav_majikan_profile, R.id.nav_majikan_order,
                    R.id.nav_majikan_chat, R.id.nav_majikan_wishlist, R.id.nav_majikan_logout)
                    .setDrawerLayout(drawer)
                    .build();
            navigationView.getMenu().clear();
            navigationView.inflateMenu(R.menu.activity_majikan_drawer);
            NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
            navController.setGraph(R.navigation.mobile_navigation_majikan);
            NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
            NavigationUI.setupWithNavController(navigationView, navController);
        } else if (status.equals("Penyalur")) {
            mAppBarConfiguration = new AppBarConfiguration.Builder(
                    R.id.nav_penyalur_dashboard, R.id.nav_penyalur_profile, R.id.nav_penyalur_manage_order,
                    R.id.nav_penyalur_manage_babysitter, R.id.nav_penyalur_chat, R.id.nav_penyalur_logout)
                    .setDrawerLayout(drawer)
                    .build();
            navigationView.getMenu().clear();
            navigationView.inflateMenu(R.menu.activity_penyalur_drawer);
            NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
            navController.setGraph(R.navigation.mobile_navigation_penyalur);
            NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
            NavigationUI.setupWithNavController(navigationView, navController);
        } else {
            mAppBarConfiguration = new AppBarConfiguration.Builder(
                    R.id.nav_admin_verification, R.id.nav_admin_order_majikan, R.id.nav_admin_order_penyalur,
                    R.id.nav_admin_logout)
                    .setDrawerLayout(drawer)
                    .build();
            navigationView.getMenu().clear();
            navigationView.inflateMenu(R.menu.activity_admin_drawer);
            NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
            navController.setGraph(R.navigation.mobile_navigation_admin);
            NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
            NavigationUI.setupWithNavController(navigationView, navController);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
