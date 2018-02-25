package com.android.shopfi.activity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.shopfi.R;
import com.android.shopfi.adapter.AllDealsAdapter;
import com.android.shopfi.response.AllDealsResponse;
import com.android.shopfi.response.Outlet;
import com.android.shopfi.rest.ApiClient;
import com.android.shopfi.rest.ApiInterface;
import com.android.shopfi.rest.DealsRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllDealsActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private static final String TAG = AllDealsActivity.class.getSimpleName();
    private WifiManager mainWifi;
    private WifiReceiver receiverWifi;
    List<ScanResult> wifiList;
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.all_delas_activity);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setImmersiveMode(AllDealsActivity.this);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        recyclerView = (RecyclerView) findViewById(R.id.all_deals_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        // Initiate wifi service manager
        mainWifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);

        // Check for wifi is disabled
//        if (mainWifi.isWifiEnabled() == false) {
//            // If wifi disabled then enable it
//            Toast.makeText(getApplicationContext(), "wifi is disabled..making it enabled",
//                    Toast.LENGTH_LONG).show();
//
//            mainWifi.setWifiEnabled(true);
//        }

        // wifi scaned value broadcast receiver
        receiverWifi = new WifiReceiver();

        // Register broadcast receiver
        // Broacast receiver will automatically call when number of wifi connections changed
        registerReceiver(receiverWifi, new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
        mainWifi.startScan();
    }

    public void setImmersiveMode(Activity activity) {
        activity.getWindow()
                .getDecorView()
                .setSystemUiVisibility(
                        View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                                | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }

    protected void onPause() {
//        unregisterReceiver(receiverWifi);
        super.onPause();
    }

    protected void onResume() {
        registerReceiver(receiverWifi, new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
        super.onResume();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    // Broadcast receiver class called its receive method
    // when number of wifi connections changed


    private void callDealsApi(DealsRequest dealsRequest) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<AllDealsResponse> call = apiService.getMyDeals(dealsRequest);
        call.enqueue(new Callback<AllDealsResponse>() {
            @Override
            public void onResponse(Call<AllDealsResponse> call, Response<AllDealsResponse> response) {
                int statusCode = response.code();
                List<Outlet> allDeals = response.body().getOutlets();
                recyclerView.setAdapter(new AllDealsAdapter(allDeals, R.layout.list_item_deals, getApplicationContext()));
            }

            @Override
            public void onFailure(Call<AllDealsResponse> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });
    }

    class WifiReceiver extends BroadcastReceiver {

        // This method call when number of wifi connections changed
        public void onReceive(Context c, Intent intent) {

            wifiList = mainWifi.getScanResults();
            String wifi = "";
            String bssidArray[] = new String[wifiList.size()];
            DealsRequest dealsRequest = new DealsRequest();
            dealsRequest.imei = "990000862471854";


            for (int i = 0; i < wifiList.size(); i++) {
                wifi = wifi + wifiList.get(i).SSID + "\n";
                bssidArray[i] = wifiList.get(i).BSSID;
                Log.d("Inzimam", (wifiList.get(i)).toString());
            }
            dealsRequest.bssids = bssidArray;
            if (dealsRequest.bssids.length > 0)
                callDealsApi(dealsRequest);
            Toast.makeText(AllDealsActivity.this, wifi, Toast.LENGTH_LONG).show();
        }

    }
}
