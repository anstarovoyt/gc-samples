package ru.naumen.gc;

import java.util.HashSet;
import java.util.Set;

/**
 * @author astarovoyt
 *
 */
public class GarbageCreator
{
    private static final int COUNTER = 1000000000;

    private static final int SIZE = 100000;

    private static final Set<Object> set = new HashSet();

    public static boolean isAdd(int i)
    {
        return Boolean.FALSE;
    }

    public static void main(String... arg)
    {
        Runnable runnable = new Runnable()
        {

            public void run()
            {
                GarbageCreator.run();
            }
        };

        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
        new Thread(runnable).start();
    }

    private static void run()
    {
        for (int i = 0; i < COUNTER; i++)
        {
            int a[] = new int[SIZE];
            if (isAdd(i))
            {
                set.add(a);
            }
        }
        System.out.print(set);
    }
}
