package com.jccg.compilers;

import com.jccg.compilers.utils.StringUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Cristian Jaramillo (cristian_gerar@hotmail.com)
 */
public class Main {

    private static String[] avaliblesParams = { "fileName" };

    /**
     *
     * @param args
     */
    public static void main(String[] args)
    {

        Map<String, String> vars = new HashMap<String, String>();

        for (final String arg : args) {

            final String[] params = arg.split("=");

            System.out.println(params.length);

            if(params.length == 2)
            {
                if(StringUtils.contains(avaliblesParams, params[0]))
                {
                    vars.put(params[0], params[1]);
                } else {
                    System.out.println(String.format("El argumento %s no es valido", params[0]));
                }
            }

        }

        if(vars.containsKey("fileName"))
        {
            readFile(vars.get("fileName"));
        }

    }

    public static void readFile(String fileName) {

        BufferedReader br = null;
        StringBuilder sb = null;
        String line = null;

        try {

            br = new BufferedReader(new FileReader(fileName));
            sb = new StringBuilder();
            line = br.readLine();

            sb.append("{\n");

            while (line != null) {

                final String[] row = line.split(" ");

                if(row.length >= 2)
                {
                    String value = "";

                    for (int i = 1; i < row.length; i++) {
                        value += row[i];
                        if((i + 1) < row.length )
                            value += " ";
                    }
                    line = "\t" + "\"" + row[0] + "\"" + ": " + "\"" + value + "\"";
                }

                sb.append(line);

                line = br.readLine();

                if(line != null)
                    sb.append(",");

                sb.append("\n");


            }

            sb.append("}");

            String everything = sb.toString();

            System.out.println(everything);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
