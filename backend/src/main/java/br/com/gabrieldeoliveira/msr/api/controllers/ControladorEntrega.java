package br.com.gabrieldeoliveira.msr.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gabrieldeoliveira.msr.api.model.entrega.EntregaDeEntrada;
import br.com.gabrieldeoliveira.msr.api.model.entrega.EntregaResumo;
import br.com.gabrieldeoliveira.msr.api.transporters.TransportadorEntrega;
import br.com.gabrieldeoliveira.msr.domain.model.Entrega;
import br.com.gabrieldeoliveira.msr.domain.services.ServicoCancelaEntrega;
import br.com.gabrieldeoliveira.msr.domain.services.ServicoBuscaEntrega;
import br.com.gabrieldeoliveira.msr.domain.services.ServicoFinalizaEntrega;
import br.com.gabrieldeoliveira.msr.domain.services.ServicoNovaEntrega;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/entregas")
@AllArgsConstructor
public class ControladorEntrega {
    
    private ServicoNovaEntrega servicoNovaEntrega;
    private ServicoBuscaEntrega servicoBuscaEntrega;
    private ServicoFinalizaEntrega servicoFinalizaEntrega;
    private ServicoCancelaEntrega ServicoCancelaEntrega;
    private TransportadorEntrega transportadorEntrega;

    @GetMapping
    public ResponseEntity<List<EntregaResumo>> listar() {
        List<Entrega> entregas = servicoBuscaEntrega.todasEntregas();
        return ResponseEntity.ok(transportadorEntrega.paraListModeloResumo(entregas));
    }

    @PostMapping
    public ResponseEntity<EntregaResumo> gerarEntrada(@RequestBody @Valid EntregaDeEntrada dto) {
        Entrega entrega = transportadorEntrega.paraEntidade(dto);
        entrega = servicoNovaEntrega.gerar(entrega);
        return ResponseEntity.ok(transportadorEntrega.paraModeloResumo(entrega));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntregaResumo> buscarId(@PathVariable Long id) {
        Entrega entrega = servicoBuscaEntrega.buscaId(id);
        return ResponseEntity.ok(transportadorEntrega.paraModeloResumo(entrega));
    }

    @PutMapping("/{id}/finalizacao")
    public ResponseEntity<EntregaResumo> finaliza(@PathVariable(name = "id") Long entregaId) {
        servicoFinalizaEntrega.finalizar(entregaId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/cancelamento")
    public ResponseEntity<EntregaResumo> cancela(@PathVariable(name = "id") Long entregaId) {
        ServicoCancelaEntrega.cancelar(entregaId);
        return ResponseEntity.noContent().build();
    }
}
