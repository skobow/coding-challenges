package com.mhp.coding.challenges.dependency.notifications;

import com.mhp.coding.challenges.dependency.inquiry.Inquiry;
import com.mhp.coding.challenges.dependency.inquiry.event.InquiryCreatedEventListener;
import com.mhp.coding.challenges.dependency.inquiry.event.InquiryCreatedEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class EmailHandler implements InquiryCreatedEventListener {

    private static final Logger LOG = LoggerFactory.getLogger(EmailHandler.class);

    public void sendEmail(final Inquiry inquiry) {
        LOG.info("Sending email for: {}", inquiry);
    }

    public void onInquiryCreated(final InquiryCreatedEvent event) {
        sendEmail(event.getInquiry());
    }
}
