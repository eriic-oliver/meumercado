package com.querocasar.apirest.services;

import com.querocasar.apirest.models.CasamentoModel;
import com.querocasar.apirest.models.EmailModel;

import javax.inject.Inject;
public class ServicoNotificacaoAssinaturaPresente {

    public void enviarNotificacao(String email, String convidado, String item) {
        StringBuilder textoEmail = new StringBuilder("Informamos que ");
        textoEmail
                .append(convidado)
                .append(" assinou um item da sua lista de presentes: \n")
                .append("\n")
                .append(item)
                .append(" \n")
                .append("\n")
                .append("Atenciosamente, \n")
                .append("Quero Casar \n");

        StringBuilder emailsDestino = new StringBuilder();

        emailsDestino.append(email);

        EmailModel mensagemEmail = new EmailModel();
        mensagemEmail.setTitulo("Há um novo item assinado em sua lista de presentes");
        mensagemEmail.setDestino(emailsDestino.toString());
        mensagemEmail.setTexto(textoEmail.toString());

        EmailService emailService = new EmailService();
        emailService.enviarEmail(mensagemEmail);
    }
}
