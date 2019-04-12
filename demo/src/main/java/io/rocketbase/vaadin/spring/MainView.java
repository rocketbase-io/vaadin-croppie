package io.rocketbase.vaadin.spring;

import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import io.rocketbase.vaadin.croppie.CorsProxyResource;
import io.rocketbase.vaadin.croppie.Croppie;
import io.rocketbase.vaadin.croppie.model.*;

import java.io.IOException;

@Route
@PageTitle("Croppie-Demo")
public class MainView extends VerticalLayout {

    public MainView() throws IOException {
        add(new H2("Vaadin-Croppie Demo"));

        addRocketbaseCroppie();

        Croppie reindeerCropper = new Croppie("frontend/hero-reindeer.jpg")
                .withViewport(new ViewPortConfig(150, 200, ViewPortType.SQUARE))
                .withShowZoomer(false);
        add(reindeerCropper);


        add(new Croppie(new CorsProxyResource("photo-1474827650307-5aeff1907b88.jpeg", "https://images.unsplash.com/photo-1474827650307-5aeff1907b88?auto=format&fit=crop&w=1052&q=80"))
                .withEnableResize(true)
                .withBoundary(new SizeConfig(600, 400)));
    }

    private void addRocketbaseCroppie() {
        TextArea eventLog = new TextArea("Events", "", "no event's received");
        eventLog.setWidth("500px");
        eventLog.addClassName("font-size-xs");
        eventLog.setHeight("250px");

        Croppie croppie = new Croppie("frontend/rocketbase-brand-logo.jpg")
                .withConfig(CroppieConfiguration.builder()
                        .viewport(new ViewPortConfig(200, 200, ViewPortType.CIRCLE))
                        .boundary(new SizeConfig(250, 250))
                        .points(new CropPoints(406, 173, 571, 338))
                        .build())
                .withLabel("Croppie");
        croppie.addClassName("font-size-xs");

        croppie.addCropListener(e -> {
            eventLog.setValue(e.toString() + ", isFromClient=" + e.isFromClient() + "\n" + eventLog.getValue());
        });
        add(croppie);

        HorizontalLayout layout = new HorizontalLayout();
        layout.setWidth("100%");
        layout.add(croppie);
        layout.add(eventLog);
        add(layout);
    }

}
