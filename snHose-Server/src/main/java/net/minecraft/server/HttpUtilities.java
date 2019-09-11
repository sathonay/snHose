package net.minecraft.server;

import java.util.concurrent.atomic.*;
import java.util.*;
import java.net.*;
import org.apache.logging.log4j.*;
import java.io.*;

public class HttpUtilities
{
    private static final AtomicInteger a;
    private static final Logger b;
    
    public static String a(final Map map) {
        final StringBuilder sb = new StringBuilder();
        for (final Map.Entry<String, V> entry : map.entrySet()) {
            if (sb.length() > 0) {
                sb.append('&');
            }
            try {
                sb.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            }
            catch (UnsupportedEncodingException ex) {
                ex.printStackTrace();
            }
            if (entry.getValue() != null) {
                sb.append('=');
                try {
                    sb.append(URLEncoder.encode(entry.getValue().toString(), "UTF-8"));
                }
                catch (UnsupportedEncodingException ex2) {
                    ex2.printStackTrace();
                }
            }
        }
        return sb.toString();
    }
    
    public static String a(final URL url, final Map map, final boolean b) {
        return a(url, a(map), b);
    }
    
    private static String a(final URL url, final String s, final boolean b) {
        try {
            Proxy no_PROXY = (MinecraftServer.getServer() == null) ? null : MinecraftServer.getServer().aq();
            if (no_PROXY == null) {
                no_PROXY = Proxy.NO_PROXY;
            }
            final HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection(no_PROXY);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpURLConnection.setRequestProperty("Content-Length", "" + s.getBytes().length);
            httpURLConnection.setRequestProperty("Content-Language", "en-US");
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            final DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
            dataOutputStream.writeBytes(s);
            dataOutputStream.flush();
            dataOutputStream.close();
            final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            final StringBuffer sb = new StringBuffer();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
                sb.append('\r');
            }
            bufferedReader.close();
            return sb.toString();
        }
        catch (Exception ex) {
            if (!b) {
                HttpUtilities.b.error("Could not post to " + url, ex);
            }
            return "";
        }
    }
    
    static {
        a = new AtomicInteger(0);
        b = LogManager.getLogger();
    }
}
