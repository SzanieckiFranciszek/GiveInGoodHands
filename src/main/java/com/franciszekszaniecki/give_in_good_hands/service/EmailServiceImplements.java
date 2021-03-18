package com.franciszekszaniecki.give_in_good_hands.service;


import com.franciszekszaniecki.give_in_good_hands.repository.EmailSenderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailServiceImplements implements EmailSenderRepository {
    private final JavaMailSender mailSender;
    private final static Logger LOGGER = LoggerFactory
            .getLogger(EmailServiceImplements.class);

    public EmailServiceImplements(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    @Async
    public void send(String to, String email) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
            helper.setText(email, true);
            helper.setTo(to);
            helper.setSubject("Confirm your email");
            helper.setFrom("giveingoodhands@gmail.com");
            mailSender.send(mimeMessage);

        } catch (MessagingException e) {
            LOGGER.error("Fail to send email", e);
            throw new IllegalStateException("Failed to send email");
        }
    }
}
