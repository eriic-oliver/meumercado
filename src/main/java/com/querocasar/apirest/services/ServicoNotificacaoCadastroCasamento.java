package com.querocasar.apirest.services;

import com.querocasar.apirest.models.EmailModel;

public class ServicoNotificacaoCadastroCasamento {

    public void enviarNotificacaoCadastro(String email, Long id) {
        StringBuilder textoEmail = new StringBuilder("Bem-vindo ao Quero Casar!!! \n \n");
        textoEmail
                .append(" Seu ID de acesso é: \n")
                .append(id)
                .append(" \n")
                .append("\n")
                .append("Atenciosamente, \n")
                .append("Quero Casar \n");

        StringBuilder emailsDestino = new StringBuilder();

        emailsDestino.append(email);

        EmailModel mensagemEmail = new EmailModel();
        mensagemEmail.setTitulo("Boas vindas!");
        mensagemEmail.setDestino(emailsDestino.toString());
        mensagemEmail.setTexto(textoEmail.toString());

        EmailService emailService = new EmailService();
        emailService.enviarEmail(mensagemEmail);
    }
}
