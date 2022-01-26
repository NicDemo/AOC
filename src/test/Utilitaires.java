package test;

import java.util.Iterator;

    public class Utilitaires {
        public static <T extends Comparable<? super T>>
        boolean isSorted(Iterable<T> iterable) {
            Iterator<T> iter = iterable.iterator();
            if (!iter.hasNext()) {
                return true;
            }
            T t = iter.next();
            while (iter.hasNext()) {
                T t2 = iter.next();
                if (t.compareTo(t2) > 0) {
                    return false;
                }
                t = t2;
            }
            return true;
        }
    }


