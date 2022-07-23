package br.com.gabrieldeoliveira.msr.api.controllers;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gabrieldeoliveira.msr.api.model.entrega.EntregaDeEntrada;
import br.com.gabrieldeoliveira.msr.api.model.entrega.EntregaResumo;
import br.com.gabrieldeoliveira.msr.api.transporters.TransportadorEntrega;
import br.com.gabrieldeoliveira.msr.domain.model.Entrega;
import br.com.gabrieldeoliveira.msr.domain.services.ServicoNovaEntrega;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/entregas")
@AllArgsConstructor
public class ControladorEntrega {
    
    private ServicoNovaEntrega servicoNovaEntrega;
    private TransportadorEntrega transportadorEntrega;

    @PostMapping
    public ResponseEntity<EntregaResumo> gerarEntrada(@RequestBody @Valid EntregaDeEntrada dto) {
        Entrega entrega = transportadorEntrega.paraEntidade(dto);
        entrega = servicoNovaEntrega.gerar(entrega);
        return ResponseEntity.ok(transportadorEntrega.paraModeloResumo(entrega));
    }
}
