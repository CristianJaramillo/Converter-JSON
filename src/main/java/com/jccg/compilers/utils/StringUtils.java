package com.jccg.compilers.utils;

/**
 *
 * @author Cristian Jaramillo (cristian_gerar@hotmail.com)
 */
public class StringUtils {

    private StringUtils() {}

    /**
     *
     * @return
     */
    public static final boolean contains(final String[] array, final String key)
    {
        for(final String item : array)
            if(item.equals(key))
                return true;
        return false;
    }

}
