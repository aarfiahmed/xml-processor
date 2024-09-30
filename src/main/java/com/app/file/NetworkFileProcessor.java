package com.app.file;

import java.io.*;
import java.net.URL;
import java.util.List;

import static com.app.constant.AppConstant.NETWORK_FILE_LOCATION;

public class NetworkFileProcessor {
    public static void main(String[] args) throws Exception {
        new NetworkFileProcessor().processNetworkFile(NETWORK_FILE_LOCATION).forEach(System.out::println);
    }

    public List<String> processNetworkFile(String networkFileLocation) throws Exception {
        URL url = new URL(networkFileLocation);

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
            return reader.lines().toList();
        } catch (Exception ex) {
            System.out.println("exception occurred while reading and processing the file -> " + ex.getMessage());
        }
        return null;
    }
}
