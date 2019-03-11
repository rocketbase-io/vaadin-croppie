package io.rocketbase.vaadin.croppie;

import com.vaadin.flow.server.InputStreamFactory;
import com.vaadin.flow.server.StreamResource;
import lombok.SneakyThrows;

import java.io.InputStream;
import java.net.URL;


public class CorsProxyResource extends StreamResource {

    public CorsProxyResource(String filename, String url) {
        super(filename,
                new InputStreamFactory() {
                    @SneakyThrows
                    @Override
                    public InputStream createInputStream() {
                        return new URL(url).openStream();
                    }
                }

        );
    }
}
