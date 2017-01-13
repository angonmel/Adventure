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
    ImageButton northButton;
    ImageButton southButton;
    ImageButton eastButton;
    ImageButton westButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        northButton = (ImageButton) findViewById(R.id.activity_main_north_button);
        southButton = (ImageButton) findViewById(R.id.activity_main_south_button_button);
        eastButton = (ImageButton) findViewById(R.id.activity_main_east_button);
        westButton = (ImageButton) findViewById(R.id.activity_main_west_button);
        mainTest =(TextView) findViewById(R.id.activity_main_scene_text);
        helpButton = (ImageButton) findViewById(R.id.activity_main_help_button);
        helpButton.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View view){
               Intent i = new Intent(MainActivity.this,HelpActivity.class);
                startActivity(i);

            }
        });
        northButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentRoom = currentRoom.getRoomNorth();
                repainScene();

            }
        });

        southButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentRoom = currentRoom.getRoomSouth();
                repainScene();
            }
        });

        westButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentRoom = currentRoom.getRoomWest();
                repainScene();
            }
        });
            eastButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    currentRoom = currentRoom.getRoomEast();
                    repainScene();
                }
            });




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
        private void repainScene(){
            mainText.setText(currentRoom.getDescription());
            mainImage.setImageResource(currentRomm.getImage());

            if(currentRoom.getRoomNorth()!=null){
        northButton.setVisibility(View.VISIBLE);
        }else{
        northButton.setVisibility(View.INVISIBLE);
        }
        if(currentRoom.getRoomSouth()!=null){
        southButton.setVisibility(View.VISIBLE);
        }else{
        southButton.setVisibility(View.INVISIBLE);
        }
        if(currentRoom.getRoomWest()!= null){
        westButton.setVisibility(View.VISIBLE);
        }else{
        westButton.setVisibility(View.INVISIBLE);

        }
        if(currentRoom.getRoomEast()!=null){
        eastButton.setVisibility(View.VISIBLE);
        }else{
        eastButton.setVisibility(View.INVISIBLE);
        }

}



