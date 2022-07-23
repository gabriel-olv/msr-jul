package br.com.gabrieldeoliveira.msr.api.exceptionHandler.errors.models;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class ErroValidacao extends Erro {
    
    private @Getter List<CampoMensagem> erros = new ArrayList<>();

    

    public ErroValidacao(OffsetDateTime timestamp, Integer status, String title) {
        super(timestamp, status, title);
    }

    @AllArgsConstructor
    @Getter
    @Setter
    public static class CampoMensagem {

        private String campo;

        private String mensagem;
    }
}
