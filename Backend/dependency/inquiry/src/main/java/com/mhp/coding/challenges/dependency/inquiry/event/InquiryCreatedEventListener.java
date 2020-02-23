package com.mhp.coding.challenges.dependency.inquiry.event;

import org.springframework.context.event.EventListener;

public interface InquiryCreatedEventListener {

    @EventListener
    void onInquiryCreated(final InquiryCreatedEvent event);
}
