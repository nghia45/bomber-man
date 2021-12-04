package uet.oop.bomberman.graphics;

import uet.oop.bomberman.entities.*;
import uet.oop.bomberman.entities.Bomber.Bomber;

import static uet.oop.bomberman.BombermanGame.*;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Map {
    public Map(String level) {
        File fileName = new File(level);
        try (FileReader inputFile = new FileReader(fileName)) {
            Scanner scanner = new Scanner(inputFile);
            String line = scanner.nextLine();

            StringTokenizer tokens = new StringTokenizer(line);
            _level = Integer.parseInt(tokens.nextToken());
            _height = Integer.parseInt(tokens.nextToken());
            _width = Integer.parseInt(tokens.nextToken());

            while (scanner.hasNextLine()) {
                position = new int[_width][_height];
                for (int i = 0; i < _height; ++i) {
                    String lineTile = scanner.nextLine();
                    StringTokenizer tokenTile = new StringTokenizer(lineTile);

                    for (int j = 0; j < _width; j++) {
                        int val = Integer.parseInt(tokenTile.nextToken());
                        Entity object;
                        if(val == 8) {
                            object = new Wall(j, i, Sprite.wall.getFxImage());
                        }else if(val == 2) {
                            object = new Wall(j, i, Sprite.wall.getFxImage());
                        } else if(val == 3) {
                            object = new Brick(j, i, Sprite.brick.getFxImage());
                        } else if(val == 4) {
                            object = new Brick(j, i, Sprite.brick.getFxImage());
                        } else if(val == 5) {
                            object = new Brick(j, i, Sprite.brick.getFxImage());
                        } else if(val == 6) {
                            object = new Brick(j, i, Sprite.brick.getFxImage());
                        } else if(val == 7) {
                            val = 0;
                            object = new Portal(j, i, Sprite.grass.getFxImage());
                        } else {
                            object = new Grass(j, i, Sprite.grass.getFxImage());
                        }
                        position[j][i] = val;
                        stillObjects.add(object);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
