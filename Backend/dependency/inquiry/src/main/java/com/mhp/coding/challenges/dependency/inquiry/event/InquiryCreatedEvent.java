package com.mhp.coding.challenges.dependency.inquiry.event;

import com.mhp.coding.challenges.dependency.inquiry.Inquiry;
import org.springframework.context.ApplicationEvent;

public class InquiryCreatedEvent extends ApplicationEvent {

    private final Inquiry inquiry;

    /**
     * Create a new ApplicationEvent.
     *
     * @param source the object on which the event initially occurred (never {@code null})
     */
    public InquiryCreatedEvent(final Object source, final Inquiry inquiry) {
        super(source);
        this.inquiry = inquiry;
    }

    public Inquiry getInquiry() {
        return inquiry;
    }
}
