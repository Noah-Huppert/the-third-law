package com.noahhuppert.thethirdlaw.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.PolygonShape;

public class Shapes {
    public static Vector2 getPolygonBoundingBox(PolygonShape shape) {
        Vector2 bottomLeft = new Vector2();
        Vector2 topRight = new Vector2();

        Vector2 currentVertex = new Vector2();

        for(int i = 0; i < shape.getVertexCount(); i++) {
            shape.getVertex(i, currentVertex);

            if(currentVertex.x < bottomLeft.x) bottomLeft.x = currentVertex.x;
            if(currentVertex.y < bottomLeft.y) bottomLeft.y = currentVertex.y;

            if(currentVertex.x > topRight.x) topRight.x = currentVertex.x;
            if(currentVertex.y > topRight.y) topRight.y = currentVertex.y;
        }

        return topRight.sub(bottomLeft);
    }
}
