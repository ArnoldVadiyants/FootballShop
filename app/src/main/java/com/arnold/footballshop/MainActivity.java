package com.arnold.footballshop;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

private static FragmentManager mFragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       mFragmentManager = getSupportFragmentManager();
        mFragmentManager.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                if (getFragmentManager().getBackStackEntryCount() == 0) finish();
            }
        });
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (savedInstanceState != null) {
            //Restore the fragment's instance
           Fragment fragment = getSupportFragmentManager().getFragment(
                    savedInstanceState, "mFragment");
            startFragment(fragment);
        }
        else
        {
            displayView(R.id.nav_catalog);
        }

      //  onSaveInstanceState(savedInstanceState);

       /* String density = "";
        DisplayMetrics dm =
                getResources().getDisplayMetrics();
        switch (dm.densityDpi)
        {
            case DisplayMetrics.DENSITY_LOW:
                density = "ldpi";
                break;
            case DisplayMetrics.DENSITY_MEDIUM:
                density = "mdpi";
                break;
            case DisplayMetrics.DENSITY_HIGH:
                density = "hdpi";
                break;
            case DisplayMetrics.DENSITY_XHIGH:
                density = "xhdpi";
                break;
            default:
                density = "mdpi";
                break;
        }*/
      //  Log.v("****TAG****", density);

    /*    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });
*/
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        HandleXML handleXML= new HandleXML(this);
        handleXML.fetchXML();



    }

    @Override
    public void onBackPressed() {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            OnBackPressedListener backPressedListener = null;
            for (Fragment fragment: mFragmentManager.getFragments()) {
                if (fragment instanceof  OnBackPressedListener) {
                    backPressedListener = (OnBackPressedListener) fragment;
                    break;
                }
            }
            if (backPressedListener != null) {
                backPressedListener.onBackPressed();
            }
            else
            {
                super.onBackPressed();
            }

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void displayView(int id) {

        String title = getString(R.string.app_name);
        if (id == R.id.nav_catalog) {
          /*  FragmentManager fm = getSupportFragmentManager();
        //    Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);
         //   if (fragment == null) {
           Fragment     fragment = new CatalogListFragment();
            fm.beginTransaction().replace(R.id.fragmentContainer, fragment)
                        .commit();*/
            startFragment(new CatalogListFragment());
     //       }

        } else if (id == R.id.nav_sale) {
            int[] saleCatID ={87};
            startFragment(new OfferListFragment().newInstance(saleCatID));
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_info) {
            startFragment(new InfoListFragment());
        }/* else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }*/


/*
        if (fragment != null) {

        }*/

        // set the toolbar title
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

    }
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        displayView(item.getItemId());
        return true;
    }

public static void startFragment(Fragment fragment)
{
    if(mFragmentManager !=null)
    {
        if(fragment != null)
        {
            mFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment)
                    .commit();
        }

    }

    //       }
}

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if(mFragmentManager !=null)
        {
            Fragment fragment = mFragmentManager.findFragmentById(R.id.fragmentContainer);
            mFragmentManager.putFragment(outState, "mFragment",fragment);
        }
    }
}