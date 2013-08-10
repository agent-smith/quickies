package com.agentsmith.quickies;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class MoveRightOrDown
{
    private final int M;
    private final int N;

    private List<Point> blockedPoints = new ArrayList<>();

    private List<Point> path = new ArrayList<>();

    public MoveRightOrDown(int M, int N, List<Point> blockedPoints)
    {
        this.M = M;
        this.N = N;
        this.blockedPoints = blockedPoints;
    }

    public List<Point> getPath()
    {
        return path;
    }

    public boolean walk(int m, int n)
    {
        Point point = new Point(m, n);

        if (!blockedPoints.contains(new Point(m, n)))
        {
            path.add(point);
        }

        // If we're at the bottom-right most point, we're done.
        if (m == M && n == N)
        {
            return true;
        }

        boolean success = false;

        // Try moving down.
        if (m <= M && !blockedPoints.contains(new Point(m+1, n)))
        {
            success = walk(m+1, n);
        }

        // If moving down failed, then try to move right.
        if (!success && n <= N && !blockedPoints.contains(new Point(m, n+1)))
        {
            success = walk(m, n+1);
        }

        if (!success)
        {
            path.remove(point);
        }

        return success;
    }

    public static void main(String[] args)
    {
        int M = Integer.parseInt(args[0]);
        int N = Integer.parseInt(args[1]);

        List<Point> blockedPoints = new ArrayList<>();
        blockedPoints.add(new Point(1, 0));

        System.out.println("Moving robot from upper left (0,0) to bottom right (" + M + ", " + N + ") " +
                           "by only going right or down, and avoiding the following obstructions: " + blockedPoints);

        MoveRightOrDown f = new MoveRightOrDown(M, N, blockedPoints);
        f.walk(0, 0);

        System.out.println("Path is: "  + f.getPath());
    }
}
