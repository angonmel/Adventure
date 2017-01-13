package com.example.antonio.adventure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.antonio.adventure.model.Inventory;
import com.example.antonio.adventure.model.Item;
import com.example.antonio.adventure.model.MapGenerator;
import com.example.antonio.adventure.model.Room;

public class MainActivity extends AppCompatActivity  {
    ImageButton helpButton;
    TextView mainTest;
    ImageButton botonNorte;
    ImageButton botonSur;
    ImageButton botonEste;
    ImageButton botonOeste;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonNorte = (ImageButton) findViewById(R.id.activity_main_north_button);
        botonSur = (ImageButton) findViewById(R.id.activity_main_south_button_button);
        botonEste = (ImageButton) findViewById(R.id.activity_main_east_button);
        botonOeste = (ImageButton) findViewById(R.id.activity_main_west_button);
        mainTest =(TextView) findViewById(R.id.activity_main_scene_text);
        helpButton = (ImageButton) findViewById(R.id.activity_main_help_button);
        helpButton.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View view){
               Intent i = new Intent(MainActivity.this,HelpActivity.class);
                startActivity(i);

            }
        });
        botonNorte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //botonSur.OnClickListener(new View.OnClickListener(){
            //@Override
            //public void onClick(View v){
        //finish();
        //}
        //});
        //botonEste.OnClickListener(new View.OnClickListener(){
        // @Override
        //  public void onClick(View v){
        //      finish();
        //  }
        //});
        initGame();
        mainTest.setText(currentRoom.getDescription());



    }

    Inventory inventory = new Inventory();
    Room currentRoom;
    private void initGame() {
        Item sword = new Item("Sword", " A shine blade");
        Item pieceOfPaper = new Item("Piece of Paper", "A blank piece of paper");
        Item rubberChicken = new Item("Pollo de Goma", "Un 'inútil' pollo de goma");

        inventory.add(sword);
        inventory.add(pieceOfPaper);
        inventory.add(rubberChicken);

        MapGenerator.generate();
        currentRoom = MapGenerator.initialRoom;

}
}



