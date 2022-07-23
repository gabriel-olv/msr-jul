package br.com.gabrieldeoliveira.msr.api.transporters;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.gabrieldeoliveira.msr.api.model.ClienteDeEntrada;
import br.com.gabrieldeoliveira.msr.api.model.ClienteDeEntradaAtualizacao;
import br.com.gabrieldeoliveira.msr.api.model.ClienteResumo;
import br.com.gabrieldeoliveira.msr.domain.model.Cliente;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class TransportadorCliente {
    
    private ModelMapper modelMapper;

    public ClienteResumo paraModeloResumo(Cliente cliente) {
        return modelMapper.map(cliente, ClienteResumo.class);
    }

    public List<ClienteResumo> paraListModeloResumo(List<Cliente> clientes) {
        return clientes.stream().map(x -> paraModeloResumo(x)).toList();
    }

    public Cliente paraEntidade(ClienteDeEntrada dto) {
        return modelMapper.map(dto, Cliente.class);
    }

    public Cliente paraEntidade(ClienteDeEntradaAtualizacao dto) {
        return modelMapper.map(dto, Cliente.class);
    }
}
