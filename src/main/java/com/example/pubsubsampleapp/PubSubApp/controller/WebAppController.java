package com.example.pubsubsampleapp.PubSubApp.controller;

import com.example.pubsubsampleapp.PubSubApp.adapter.OutboundChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class WebAppController {

    // tag::autowireGateway[]
    @Autowired
    private OutboundChannel.PubsubOutboundGateway messagingGateway;
    // end::autowireGateway[]

    @PostMapping("/publishMessage")
    public RedirectView publishMessage(@RequestParam("message") String message) {
        messagingGateway.sendToPubsub(message);
        return new RedirectView("/");
    }
}
