package com.viabtc.http_demo;

import java.net.URI;

import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;

public class ViaHttpDelete extends HttpEntityEnclosingRequestBase  {
	public static final String METHOD_NAME = "DELETE";

    public String getMethod() {
        return METHOD_NAME;
    }

    public ViaHttpDelete(final String uri) {
        super();
        setURI(URI.create(uri));
    }

    public ViaHttpDelete(final URI uri) {
        super();
        setURI(uri);
    }

    public ViaHttpDelete() {
        super();
    }
}
