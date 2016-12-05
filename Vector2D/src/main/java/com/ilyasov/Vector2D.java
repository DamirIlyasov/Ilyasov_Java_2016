package com.ilyasov;

public class Vector2D {
    private double x;
    private double y;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double length() {
        return Math.sqrt(Math.pow(x, x) + Math.pow(y, y));
    }

    public Vector2D add(Vector2D vector2D) {
        return new Vector2D(this.x + vector2D.getX(), this.y + vector2D.getY());
    }

    public Vector2D mult(double k) {
        return new Vector2D(this.x * k, this.y * k);
    }

    public Vector2D scalarMult(Vector2D vector2D) {
        return new Vector2D(x * vector2D.getX(), y * vector2D.getY());
    }

    public boolean equals(Vector2D vector2D) {
        return (this.x == vector2D.getX() && this.y == vector2D.getY());
    }

}
