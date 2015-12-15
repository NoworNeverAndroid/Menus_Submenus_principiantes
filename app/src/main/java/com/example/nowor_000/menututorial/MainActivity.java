package com.example.nowor_000.menututorial;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {

    private LinearLayout layout_elementos;

    private static final int MENU_OPC4 = 4;
    private static final int MENU_OPC5 = 5;
    private static final int MENU_OPC6 = 6;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        layout_elementos = (LinearLayout) findViewById(R.id.LinearLayout_elementos);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    /**
     * MENU DINAMICO
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);


        menu.add(Menu.NONE, MENU_OPC4, Menu.CATEGORY_SECONDARY, "Item 1 dinamico")
                .setIcon(android.R.drawable.ic_menu_preferences);

        menu.add(Menu.NONE, MENU_OPC5, Menu.CATEGORY_SECONDARY, "Item 2 dinamico")
                .setIcon(android.R.drawable.ic_menu_compass)
                .setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(getApplicationContext(), "Item 2 dinamico", Toast.LENGTH_LONG).show();
                        return true;
                    }
                });




        SubMenu SubMenuDinamico = menu.addSubMenu(Menu.CATEGORY_CONTAINER, MENU_OPC6, Menu.CATEGORY_SECONDARY, "Item 3 dinamico - SubItems")
                .setIcon(android.R.drawable.ic_dialog_info);


        for (int i=1; i<31; i++){
            SubMenuDinamico.add(Menu.NONE, i, Menu.NONE, "SubItem " + i);
        }




        return true;
    }


    /**
     * MENU ESTATICO
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        final int tamaño = 30; // total number of textviews to add

        final TextView[] myTextViews = new TextView[tamaño]; // create an empty array;


        switch (id) {
            case R.id.Item1_añadir:



                for (int i = 0; i < tamaño; i++) {
                    // create a new textview
                    final TextView filasTextView = new TextView(this);

                    // set some properties of filasTextView or something
                    filasTextView.setText("Item #" + i);

                    // add the textview to the linearlayout
                    layout_elementos.addView(filasTextView);

                    // save a reference to the textview for later
                    myTextViews[i] = filasTextView;
                }


                return true;

            case R.id.Item2_borrar:
                layout_elementos.removeAllViews();
                return true;

            default:
                return super.onOptionsItemSelected(item);


        }
    }



}
