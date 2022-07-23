package br.com.gabrieldeoliveira.msr.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.gabrieldeoliveira.msr.api.model.ocorrencia.OcorrenciaDeEntrada;
import br.com.gabrieldeoliveira.msr.api.model.ocorrencia.OcorrenciaResumo;
import br.com.gabrieldeoliveira.msr.api.transporters.TransportadorOcorrencia;
import br.com.gabrieldeoliveira.msr.domain.model.Entrega;
import br.com.gabrieldeoliveira.msr.domain.model.Ocorrencia;
import br.com.gabrieldeoliveira.msr.domain.services.ServicoBuscaEntrega;
import br.com.gabrieldeoliveira.msr.domain.services.ServicoGeraOcorrencia;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
@AllArgsConstructor
public class ControladorOcorrencia {

    private ServicoGeraOcorrencia servicoGeraOcorrencia;
    private ServicoBuscaEntrega servicoBuscaEntrega;
    private TransportadorOcorrencia transportadorOcorrencia;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OcorrenciaResumo gerar(@PathVariable Long entregaId, @RequestBody @Valid OcorrenciaDeEntrada dto) {
        Ocorrencia ocorrencia = servicoGeraOcorrencia.gerar(entregaId, dto.getDescricao());
        return transportadorOcorrencia.paraModeloResumo(ocorrencia);
    }

    @GetMapping
    public List<OcorrenciaResumo> listar(@PathVariable Long entregaId) {
        Entrega entrega = servicoBuscaEntrega.buscaId(entregaId);
        return transportadorOcorrencia.paraListModeloResumo(entrega.getOcorrencias());
    }
}
