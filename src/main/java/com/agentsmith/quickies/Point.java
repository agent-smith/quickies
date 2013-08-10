package com.agentsmith.quickies;

/**
 * Point(x, y)
 * <p/>
 * User: rmarquez
 * Date: 8/4/13
 * Time: 1:57 AM
 */
public class Point
{
    private final int x;
    private final int y;

    Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString()
    {
        return "(" + x + ", " + y + ')';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }

        Point point = (Point) o;

        if (x != point.x)
        {
            return false;
        }
        if (y != point.y)
        {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = x;
        result = 31*result+y;
        return result;
    }
}
