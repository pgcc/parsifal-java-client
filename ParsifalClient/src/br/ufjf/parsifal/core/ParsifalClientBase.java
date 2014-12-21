/*
 * The MIT License
 *
 * Copyright 2014 Pós-Graduação em Ciência da Computação UFJF.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package br.ufjf.parsifal.core;

import br.ufjf.parsifal.exception.ParsifalException;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.commons.codec.binary.Base64;

/**
 *
 * @author vitorfs
 */
public abstract class ParsifalClientBase {
    
    private String baseUri;
    private String username;
    private String password;
    
    public ParsifalClientBase() {
    
    }
    
    public ParsifalClientBase(String baseUri) {
        this.baseUri = baseUri;
    }
    
    public ParsifalClientBase(String baseUri, String username, String password) {
        this.baseUri = baseUri;
        this.username = username;
        this.password = password;
    }
        
    protected HttpURLConnection request(String endpoint, String method, int expectedResponseCode, String acceptData) throws ParsifalException {
        HttpURLConnection connection = null;
        
        try {            
            String uri = this.getBaseUri() + endpoint;
            URL url = new URL(uri);
            connection = (HttpURLConnection) url.openConnection();
            connection.setUseCaches(false);
            connection.setDoOutput(true);
            connection.setRequestProperty("Connection", "Keep-Alive");
            connection.setRequestProperty("Cache-Control", "no-cache");
            String authorization = this.username + ":" + this.password;
            String encodedAuthorization = "Basic "+ new String(Base64.encodeBase64(authorization.getBytes()));
            connection.setRequestProperty ("Authorization", encodedAuthorization);
            connection.setRequestMethod(method);
            
            if (acceptData != null) {
                connection.setRequestProperty("Accept", acceptData);
            }
            
            int responseCode = connection.getResponseCode();
            if (responseCode != expectedResponseCode) {
                throw new ParsifalException(String.format("Invalid HTTP Response Code. Expected %d, actual %d, URL %s", expectedResponseCode, responseCode, url));
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return connection;
    }
    
    protected String parseResponse(HttpURLConnection response) {
        try {
            InputStream responseStream = new BufferedInputStream(response.getInputStream());
            BufferedReader responseStreamReader = new BufferedReader(new InputStreamReader(responseStream));
            String line = "";
            StringBuilder stringBuilder = new StringBuilder();

            while ((line = responseStreamReader.readLine()) != null)
            {
                stringBuilder.append(line).append("\n");
            }

            responseStreamReader.close();
            String output = stringBuilder.toString();
            responseStream.close();

            return output;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    
    public void setAuthorization(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    /**
     * @return the baseUri
     */
    public String getBaseUri() {
        return baseUri;
    }

    /**
     * @param baseUri the baseUri to set
     */
    public void setBaseUri(String baseUri) {
        this.baseUri = baseUri;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
}
