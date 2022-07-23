package br.com.gabrieldeoliveira.msr.api.exceptionHandler;

import java.time.OffsetDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.gabrieldeoliveira.msr.api.exceptionHandler.errors.models.Erro;
import br.com.gabrieldeoliveira.msr.api.exceptionHandler.errors.models.ErroPadrao;
import br.com.gabrieldeoliveira.msr.api.exceptionHandler.errors.models.ErroValidacao;
import br.com.gabrieldeoliveira.msr.domain.exceptions.ArgumentoInvalidoExcecao;
import br.com.gabrieldeoliveira.msr.domain.exceptions.EntidadeNaoEncontradaExcecao;
import lombok.AllArgsConstructor;

@RestControllerAdvice
@AllArgsConstructor
public class TratadorExcecaoControlador {

    private MessageSource messageSource;

    @ExceptionHandler(EntidadeNaoEncontradaExcecao.class)
    public ResponseEntity<Erro> tratarEntidadeNaoEncontrada(EntidadeNaoEncontradaExcecao e, HttpServletRequest req) {
        final Integer status = HttpStatus.NOT_FOUND.value();
        final String title = "Entidade não encontrada";

        Erro erro = new ErroPadrao(OffsetDateTime.now(), status, title, e.getMessage());

        return ResponseEntity.status(status).body(erro);
    }

    @ExceptionHandler(ArgumentoInvalidoExcecao.class)
    public ResponseEntity<Erro> tratarArgumentoInvalidao(ArgumentoInvalidoExcecao e, HttpServletRequest req) {
        final Integer status = HttpStatus.BAD_REQUEST.value();
        final String title = "Argumento inválido";

        Erro erro = new ErroPadrao(OffsetDateTime.now(), status, title, e.getMessage());

        return ResponseEntity.status(status).body(erro);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Erro> tratarHttpMessageNotReadable(HttpMessageNotReadableException e,
            HttpServletRequest req) {
        final Integer status = HttpStatus.BAD_REQUEST.value();
        final String title = "Entraga inválida";

        Erro erro = new ErroPadrao(OffsetDateTime.now(), status, title, e.getMostSpecificCause().getMessage());

        return ResponseEntity.status(status).body(erro);
    }

    @ExceptionHandler(MissingPathVariableException.class)
    public ResponseEntity<Erro> tratarMissingPathVariable(MissingPathVariableException e, HttpServletRequest req) {
        final Integer status = HttpStatus.BAD_REQUEST.value();
        final String title = "Argumento inválido";

        Erro erro = new ErroPadrao(OffsetDateTime.now(), status, title, e.getMessage());

        return ResponseEntity.status(status).body(erro);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Erro> tratarMethodArgumentNotValid(MethodArgumentNotValidException e,
            HttpServletRequest req) {
        final Integer status = HttpStatus.BAD_REQUEST.value();
        final String title = "Erro de validação";

        ErroValidacao erro = new ErroValidacao(OffsetDateTime.now(), status, title);

        e.getFieldErrors().forEach(x -> {
            erro.getErros().add(
                    new ErroValidacao.CampoMensagem(x.getField(),
                            messageSource.getMessage(x, LocaleContextHolder.getLocale())));
        });

        return ResponseEntity.status(status).body(erro);
    }
}
