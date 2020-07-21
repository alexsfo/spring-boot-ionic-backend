package com.alexsandro.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.alexsandro.cursomc.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);

	void sendEmail(SimpleMailMessage msg);

}
