package br.com.gabrieldeoliveira.msr.api.transporters;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.gabrieldeoliveira.msr.api.models.entrega.EntregaDeEntrada;
import br.com.gabrieldeoliveira.msr.api.models.entrega.EntregaResumo;
import br.com.gabrieldeoliveira.msr.domain.models.Entrega;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class TransportadorEntrega {
    
    private ModelMapper modelMapper;

    public Entrega paraEntidade(EntregaDeEntrada dto) {
        return modelMapper.map(dto, Entrega.class);
    }

    public EntregaResumo paraModeloResumo(Entrega entrega) {
        return modelMapper.map(entrega, EntregaResumo.class);
    }

    public List<EntregaResumo> paraListModeloResumo(List<Entrega> entregas) {
        return entregas.stream().map(x -> paraModeloResumo(x)).toList();
    }
}
