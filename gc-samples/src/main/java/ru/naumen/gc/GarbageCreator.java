package ru.naumen.gc;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * run: java -Xmx10g -verbose:gc -jar gc-samples-0.0.1-SNAPSHOT.jar
 * @author astarovoyt
 *
 */
public class GarbageCreator
{
    private static int THREAD_COUNT = 10;
    private static int SIZE = 1000000;
    private static int COUNTER = 1000000000;

    private static final Set<Object> set = new HashSet();

    public static boolean isAdd(int i)
    {
        return Boolean.FALSE;
    }

    public static void main(String... arg)
    {
        if (arg != null)
        {
            if (arg.length > 0)
            {
                THREAD_COUNT = Integer.parseInt(arg[0]);
            }

            if (arg.length > 1)
            {
                SIZE = Integer.parseInt(arg[1]);
            }

            if (arg.length > 2)
            {
                COUNTER = Integer.parseInt(arg[1]);
            }
        }

        Runnable runnable = new Runnable()
        {

            @Override
            public void run()
            {
                GarbageCreator.run();
            }
        };

        for (int i = 0; i < THREAD_COUNT; i++)
        {
            new Thread(runnable).start();
        }
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
