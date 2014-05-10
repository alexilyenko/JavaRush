package com.javarush.test.level24.lesson14.big01;

/**
 * Класс для шарика в игре
 */
public class Ball extends BaseObject
{
    //скорость
    private double speed;
    //направление  (в градусах от 0 до 360)
    private double direction;

    //текущее значение вектора движения (dx,dy)
    private double dx;
    private double dy;

    //заморожен ли объект или может двигаться
    private boolean isFrozen;

    public Ball(double x, double y, double speed, double direction)
    {
        super(x, y, 1);

        this.direction = direction;
        this.speed = speed;

        this.isFrozen = true;
    }

    public double getSpeed()
    {
        return speed;
    }

    public void setSpeed(double speed)
    {
        this.speed = speed;
    }

    public double getDirection()
    {
        return direction;
    }

    public double getDx()
    {
        return dx;
    }

    public double getDy()
    {
        return dy;
    }

    /**
     * Устанавливаем новое направление движения.
     * Тут же вычисляем и новый вектор.
     * Тако подход удобно использовать при отскоках от стен.
     */
    public void setDirection(double direction)
    {
        this.direction = direction;

        double angel = Math.toRadians(direction);
        dx = Math.cos(angel) * speed;
        dy = -Math.sin(angel) * speed;
    }

    /**
     * Рисуем себя на "канвасе".
     */
    @Override
    public void draw(Canvas canvas)
    {
        canvas.setPoint(x, y, 'O');
    }

    /**
     * Двигаем себя на один шаг.
     */
    public void move()
    {
        if (isFrozen) return;

        x += dx;
        y += dy;

        checkRebound(1, Arcanoid.game.getWidth(), 1, Arcanoid.game.getHeight() + 5);
    }

    /**
     * Проверяем не улетел ли шарик за стенку.
     * Если да - отражаем его.
     */
    public void checkRebound(int minx, int maxx, int miny, int maxy)
    {
        if (x < minx)
        {
            x = minx + (minx - x);
            dx = -dx;
        }

        if (x > maxx)
        {
            x = maxx - (x - maxx);
            dx = -dx;
        }

        if (y < miny)
        {
            y = miny + (miny - y);
            dy = -dy;
        }

        if (y > maxy)
        {
            y = maxy - (y - maxy);
            dy = -dy;
        }
    }

    /**
     * Запускам шарик.
     * isFrozen = false.
     * Пересчитываем вектор движения (dx,dy).
     */
    public void start()
    {
        this.setDirection(direction);
        this.isFrozen = false;
    }
}
